package controller.gamecontrollers.gamestagecontroller;

import model.enums.GameEnums.GameError;
import model.enums.GameEnums.gamestage.GameSideStage;
import model.gameprop.Game;
import model.gameprop.GameInProcess;
import viewer.game.BoardDrawer;

public class SideStageController {

    private static SideStageController instance ;

    private SideStageController(){}

    public static SideStageController getInstance() {
        if (instance == null) instance = new SideStageController();
        return instance;
    }

    public String run(String command) {
        Game game = GameInProcess.getGame();
        if (command.equals("resume")) {
            if (game.getGameSideStage().equals(GameSideStage.WAIT_STAGE)) {
                game.setGameSideStage(GameSideStage.NONE);
                BoardDrawer boardDrawer = new BoardDrawer(game);
                return boardDrawer.drawBoard();
            }else{
             return GameError.INVALID_SIDE_MENU_REQUEST.toString();
            }
        }
        else return null;
    }
}
