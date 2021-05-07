package controller.gamecontrollers;

import com.sanityinc.jargs.CmdLineParser;
import controller.gamecontrollers.mainstagecontroller.DrawPhaseController;
import controller.gamecontrollers.mainstagecontroller.SideStageController;
import model.gameprop.GameInProcess;
import viewer.Regex;
import viewer.game.BoardDrawer;

import java.util.Objects;

public class HeadController {
    DrawPhaseController drawPhaseController;
    SideStageController sideStageController;

    public HeadController() {
        drawPhaseController = new DrawPhaseController();
        sideStageController = new SideStageController();
    }

    public void run(String command) throws CmdLineParser.OptionException {

        drawPhaseController.draw();
        if (command.equals("START")) {
            BoardDrawer.drawBoard(GameInProcess.getGame());
        }

        if (isSideStageCommand(command)) {
            sideStageController.run(command);
        } else {
            if (isGeneralCommand(command)) {
                Objects.requireNonNull(getPhaseController()).run(command);
            }
        }
    }


    private boolean isGeneralCommand(String command) {
        for (String generalPattern : Regex.generalCommands) {
            if (command.matches(generalPattern)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSideStageCommand(String command) {
        for (String commandPattern : Regex.sideStageCommand) {
            if (command.matches(commandPattern)) {
                return true;
            }
        }
        return false;
    }

    private GeneralController getPhaseController() {
        switch (GameInProcess.getGame().getGameMainStage()) {
            case DRAW_PHASE:
                return drawPhaseController;
            default:
                return null;
        }
    }
}
