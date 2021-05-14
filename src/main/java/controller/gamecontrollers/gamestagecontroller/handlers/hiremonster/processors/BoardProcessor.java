package controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.processors;

import controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.MonsterProcessor;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.gamemodel.Game;

public class BoardProcessor extends MonsterProcessor {
    public BoardProcessor(MonsterProcessor processor) {
        super(processor);
    }

    public MainPhase process(Game game){
        if (game.getHiredMonster() != null) return MainPhase.HIRE_MONSTER_BEFORE;

        PlayerBoard board = game.getPlayer(SideOfFeature.CURRENT).getBoard();
        if (isBoardFull(board)) return MainPhase.BOARD_IS_FULL;

        return super.process(game);
    }

    private boolean isBoardFull(PlayerBoard board){
        for (MonsterHouse monsterHouse : board.getMonsterHouse()) {
            if (monsterHouse.getMonsterCard() == null)
                return false;
        }
        return true;
    }
}
