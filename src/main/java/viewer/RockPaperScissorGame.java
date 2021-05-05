package viewer;

import controller.ImportScanner;
import controller.RockPaperScissorController;
import controller.enums.GameEnums.PlayerTurn;
import controller.enums.rockpaperscissor.PaperRockScissorError;
import controller.enums.rockpaperscissor.RockPaperScissorMessage;
import viewer.menudisplay.RockPaperScissorDisplay;

public class RockPaperScissorGame {
    public static PlayerTurn run() {
        String playerOneChoice;
        String playerTwoChoice;
        while (true) {
            RockPaperScissorDisplay.display(RockPaperScissorMessage.PLAYER_ONE_CHOOSE);

            playerOneChoice = ImportScanner.getInput().toLowerCase();
            if (chooseWrongTool(playerOneChoice)) {
                continue;
            }
            RockPaperScissorDisplay.display(RockPaperScissorMessage.PLAYER_TWO_CHOOSE);

            playerTwoChoice = ImportScanner.getInput().toLowerCase();
            if (chooseWrongTool(playerTwoChoice)) {
                continue;
            }

            PlayerTurn firstPlayer = RockPaperScissorController.
                    recognizeGameWinner(playerOneChoice, playerTwoChoice);
            if (firstPlayer.equals(PlayerTurn.PLAYER_ONE)) {
                RockPaperScissorDisplay.display(RockPaperScissorMessage.PLAYER_ONE_WIN_MESSAGE);
                return firstPlayer;
            } else if (firstPlayer.equals(PlayerTurn.PLAYER_TWO)) {
                RockPaperScissorDisplay.display(RockPaperScissorMessage.PLAYER_TWO_WIN_MESSAGE);
                return firstPlayer;
            }
            RockPaperScissorDisplay.display(RockPaperScissorMessage.DRAW_MESSAGE);
        }
    }

    private static boolean chooseWrongTool(String weapon) {
        if (!weapon.equals("paper") && !weapon.equals("rock") && !weapon.equals("scissor")) {
            RockPaperScissorDisplay.display(PaperRockScissorError.WRONG_WEAPON_CHOOSE);
            return true;
        }
        return false;
    }
}
