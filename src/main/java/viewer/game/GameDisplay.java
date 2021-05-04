package viewer.game;

import controller.enums.GameEnums.GameError;

public class GameDisplay {
    public static void display(GameError error) {
        System.out.println(error);
    }

    public static void display(String message) {
        System.out.println(message);
    }
}
