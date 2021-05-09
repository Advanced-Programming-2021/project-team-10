package controller.gamecontrollers.gamestagecontroller;

import model.enums.GameEnums.GameError;
import model.enums.GameEnums.gamestage.GameSideStage;
import model.gameprop.Game;
import model.gameprop.GameInProcess;
import viewer.game.BoardDrawer;
import viewer.game.GameDisplay;

public class SideStageController {
    public void run(String command) {
        Game game = GameInProcess.getGame();
        if (command.equals("resume")) {
            if (game.getGameSideStage().equals(GameSideStage.WAIT_STAGE)) {
                game.setGameSideStage(GameSideStage.NONE);
                BoardDrawer.drawBoard(GameInProcess.getGame());
            }else{
                GameDisplay.display(GameError.INVALID_SIDE_MENU_REQUEST);
            }
        }
    }
}
