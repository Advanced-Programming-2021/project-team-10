package viewer;

import controller.ImportScanner;
import model.gameprop.Game;

public class GamePlay {
    public static void run(Game game) {
        String command;
        while (true) {
            command = ImportScanner.getInput();
            if (isCommandValid(command)){

            }else{

            }
        }
    }

    private static boolean isCommandValid(String command) {
        return false;
    }
}
