package viewer.game;

import com.sanityinc.jargs.CmdLineParser;
import controller.ImportScanner;
import controller.gamecontrollers.gamestagecontroller.HeadController;
import model.enums.GameEnums.GameError;
import model.gameprop.GameInProcess;
import viewer.Regex;

public class GameViewer {
    public static void run() throws CmdLineParser.OptionException {
        HeadController headController = new HeadController();
        String command;
        System.out.println("press START to start game ");
        while (true) {
            command = ImportScanner.getInput();
            if (!GameInProcess.getGame().isGameFinished()) {
                if (isCommandValid(command)) {
                    headController.run(command);
                } else {
                    GameDisplay.display(GameError.INVALID_COMMAND.getErrorToString());
                }
            } else {
                break;
            }
        }
    }

    private static boolean isCommandValid(String command) {
        for (String[] phaseCommand : Regex.allGamePlayCommands) {
            for (String patternOfCommand : phaseCommand) {
                if (command.matches(patternOfCommand)) {
                    return true;
                }
            }
        }
        for (String patternOfCommand : Regex.sideStageCommand) {
            if (command.matches(patternOfCommand)) {
                return true;
            }
        }
        for (String patternOfCommand : Regex.generalCommands) {
            if (command.matches(patternOfCommand)) {
                return true;
            }
        }
        return false;
    }
}
