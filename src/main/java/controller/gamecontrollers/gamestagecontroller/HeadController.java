package controller.gamecontrollers.gamestagecontroller;

import com.sanityinc.jargs.CmdLineParser;
import controller.gamecontrollers.GeneralController;
import model.enums.GameEnums.GameError;
import model.gameprop.GameInProcess;
import viewer.Regex;
import viewer.game.BoardDrawer;
import viewer.game.GameDisplay;

import java.util.Objects;

public class HeadController {
    DrawPhaseController drawPhaseController;
    SideStageController sideStageController;
    MainPhaseController mainPhaseController;

    public HeadController() {
        drawPhaseController = new DrawPhaseController();
        sideStageController = new SideStageController();
        mainPhaseController = new MainPhaseController();
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
            } else {
                GeneralController generalController = getCommandController(command);
                if (generalController != getPhaseController()) {
                    GameDisplay.display(GameError.INVALID_PHASE_COMMAND);
                } else {
                    assert generalController != null;
                    generalController.run(command);
                }
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
            case FIRST_MAIN_PHASE:
            case SECOND_MAIN_PHASE:
                return mainPhaseController;
            default:
                return null;
        }
    }

    private GeneralController getCommandController(String command) {
        for (String commandPattern : Regex.mainPhaseCommands) {
            if (commandPattern.matches(command)) {
                return mainPhaseController;
            }
        }
        return null;
    }
}
