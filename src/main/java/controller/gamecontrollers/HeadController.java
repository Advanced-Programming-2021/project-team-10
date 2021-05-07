package controller.gamecontrollers;

import com.sanityinc.jargs.CmdLineParser;
import controller.gamecontrollers.phaseControllers.DrawPhaseController;
import model.gameprop.GameInProcess;
import viewer.Regex;

public class HeadController {
    DrawPhaseController drawPhaseController;

    public HeadController() {
        drawPhaseController = new DrawPhaseController();
    }

    public void run(String command) throws CmdLineParser.OptionException {
        if (isGeneralCommand(command))
            getPhaseController().run(command);
        else{

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

    private GeneralController getPhaseController() {
        switch (GameInProcess.getGame().getGameMainStage()) {
            case DRAW_PHASE:
                return drawPhaseController;
            default:
                return null;
        }

    }

}
