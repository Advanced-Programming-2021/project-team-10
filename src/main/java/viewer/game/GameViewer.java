package viewer.game;

import com.sanityinc.jargs.CmdLineParser;
import controller.ImportScanner;
import model.enums.GameEnums.GameError;
import controller.gamecontrollers.HeadController;
import model.gameprop.GameInProcess;
import viewer.Regex;

public class GameViewer {
    public static void run() throws CmdLineParser.OptionException {
        HeadController headController = new HeadController();
        String command;
        while (true) {
            command = ImportScanner.getInput();
            if (isCommandValid(command)) {

                headController.run(command);
            } else {
                GameDisplay.display(GameError.INVALID_COMMAND.getErrorToString());
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
        return false;
    }
}
