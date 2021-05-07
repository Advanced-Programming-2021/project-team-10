package viewer.game;

import model.enums.GameEnums.GameError;
import model.enums.GameEnums.GamePhaseEnums.DrawPhaseMessage;
import model.enums.GameEnums.GamePhaseEnums.GeneralMessage;
import model.enums.GameEnums.gamestage.GameMainStage;

public class GameDisplay {
    public static void display(GameError error) {
        System.out.println(error);
    }

    public static void display(GeneralMessage message) {
        System.out.println(message);
    }

    public static void display(DrawPhaseMessage message, String cardName) {
        System.out.printf(message.getMessage(), cardName);
    }

    public static void display(String message) {
        System.out.println(message);
    }

    public static void showCurrentPhase(GameMainStage stage) {

    }

}
