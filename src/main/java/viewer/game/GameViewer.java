package viewer.game;

import controller.ImportScanner;
import model.enums.GameEnums.GameError;
import controller.gamecontrollers.HeadController;
import model.gameprop.GameInProcess;
import viewer.Regex;

public class GameViewer {
    public static void run() {
        HeadController headController = new HeadController();
        String command;
        while (true) {
            BoardDrawer.drawBoard(GameInProcess.getGame());
            command = ImportScanner.getInput();
            if (isCommandValid(command)) {
                headController.run(command);
            } else {
                GameDisplay.display(GameError.INVALID_COMMAND);
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
