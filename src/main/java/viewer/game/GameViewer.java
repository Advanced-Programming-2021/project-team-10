package viewer.game;

import controller.ImportScanner;
import controller.enums.GameEnums.GameError;
import controller.gamecontrollers.HeadController;
import model.gameprop.Game;

public class GameViewer {
    public static void run(Game game) {
        String command;
        while (true) {
            command = ImportScanner.getInput();
            if (isCommandValid(command)){
                HeadController.run(command);
            }else{
                GameDisplay.display(GameError.INVALID_COMMAND);
            }
        }
    }

    private static boolean isCommandValid(String command) {
        return false;
    }
}
