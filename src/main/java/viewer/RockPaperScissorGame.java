package viewer;

import controller.ImportScanner;
import controller.RockPaperScissorController;
import controller.enums.PlayerOrientation;
import controller.enums.rockpaperscissor.GameError;
import controller.enums.rockpaperscissor.GameMessages;
import viewer.display.RockPaperScissorDisplay;

public class RockPaperScissorGame {
    public static PlayerOrientation run() {
        String playerOneChoice;
        String playerTwoChoice;
        while (true) {
            RockPaperScissorDisplay.display(GameMessages.PLAYER_ONE_CHOOSE);

            playerOneChoice = ImportScanner.getInput().toLowerCase();
            if (chooseWrongTool(playerOneChoice)) {
                continue;
            }
            RockPaperScissorDisplay.display(GameMessages.PLAYER_TWO_CHOOSE);

            playerTwoChoice = ImportScanner.getInput().toLowerCase();
            if (chooseWrongTool(playerTwoChoice)) {
                continue;
            }

            PlayerOrientation firstPlayer = RockPaperScissorController.
                    recognizeGameWinner(playerOneChoice, playerTwoChoice);
            if (firstPlayer.equals(PlayerOrientation.PLAYER_ONE)) {
                RockPaperScissorDisplay.display(GameMessages.PLAYER_ONE_WIN_MESSAGE);
                return firstPlayer;
            } else if (firstPlayer.equals(PlayerOrientation.PLAYER_TWO)) {
                RockPaperScissorDisplay.display(GameMessages.PLAYER_TWO_WIN_MESSAGE);
                return firstPlayer;
            }
            RockPaperScissorDisplay.display(GameMessages.DRAW_MESSAGE);
        }
    }

    private static boolean chooseWrongTool(String weapon) {
        if (!weapon.equals("paper") && !weapon.equals("rock") && !weapon.equals("scissor")) {
            RockPaperScissorDisplay.display(GameError.WRONG_WEAPON_CHOOSE);
            return true;
        }
        return false;
    }
}
