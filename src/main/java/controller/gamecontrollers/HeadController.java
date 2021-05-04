package controller.gamecontrollers;

import controller.enums.GameEnums.GameError;
import viewer.GameDisplay;

public class HeadController {
    public static void run(String command) {
        System.out.println("TODO write if clause for each controller");
    }

    public static void invalidCommand() {
        GameDisplay.display(GameError.INVALID_COMMAND);
    }
}
