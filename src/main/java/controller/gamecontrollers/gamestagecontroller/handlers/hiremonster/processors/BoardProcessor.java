package controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.processors;

import controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.MonsterProcessor;
import model.cards.cardsProp.MagicCard;
import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.gamemodel.Game;

public class BoardProcessor extends MonsterProcessor {
    public BoardProcessor(MonsterProcessor processor) {
        super(processor);
    }

    public MainPhase process(Game game) {
        PlayerBoard board = game.getPlayer(SideOfFeature.CURRENT).getBoard();
        if (game.getCardProp().getCard() instanceof MonsterCard){
            if (game.getHiredMonster() != null) return MainPhase.HIRE_MONSTER_BEFORE;
            if (board.numberOfFullHouse("monster") == 5) return MainPhase.BOARD_IS_FULL;
        }else if(game.getCardProp().getCard() instanceof MagicCard){
            if (board.numberOfFullHouse("spell") == 5) return MainPhase.BOARD_IS_FULL;
        }
        return super.process(game);
    }

}
