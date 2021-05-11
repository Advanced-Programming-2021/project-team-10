package controller.gamecontrollers.gamestagecontroller.handlers.hiremonster;

import controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.processors.BoardProcessor;
import controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.processors.CardSelectProcessor;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.gameprop.Game;

public class HireMonsterChain {
    MonsterProcessor processor;

    public HireMonsterChain() {
        buildChain();
    }

    private void buildChain() {
        processor = new CardSelectProcessor(new BoardProcessor(null));
    }

    public MainPhase request(Game game) {
        return processor.process(game);
    }
}
