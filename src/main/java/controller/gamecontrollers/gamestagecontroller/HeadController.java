package controller.gamecontrollers.gamestagecontroller;

import com.sanityinc.jargs.CmdLineParser;
import controller.gamecontrollers.GeneralController;
import viewer.Regex;

public class HeadController {
    DrawPhaseController drawPhaseController;
    SideStageController sideStageController;
    MainPhaseController mainPhaseController;
    StandByPhaseController standByPhaseController;
    GeneralController generalController;

    public HeadController() {
        drawPhaseController =  DrawPhaseController.getInstance();
        standByPhaseController =  StandByPhaseController.getInstance();
        sideStageController =  SideStageController.getInstance();
        mainPhaseController =  MainPhaseController.getInstance();
        generalController =  GeneralController.getInstance();
    }

    public String run(String command) throws CmdLineParser.OptionException {
        if (isGeneralCommand(command)) return generalController.run(command);
        else if (isSideStageCommand(command)) return sideStageController.run(command);
        else {
            return getCommandController(command).run(command);
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


    private GeneralController getCommandController(String command) {
        for (String commandPattern : Regex.mainPhaseCommands) {
            if (commandPattern.matches(command)) {
                return mainPhaseController;
            }
        }
        return null;
    }
}
