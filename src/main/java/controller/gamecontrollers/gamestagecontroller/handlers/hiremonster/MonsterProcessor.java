package controller.gamecontrollers.gamestagecontroller.handlers.hiremonster;

import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.gameprop.gamemodel.Game;

public abstract class MonsterProcessor {
    MonsterProcessor processor;

    protected MonsterProcessor(MonsterProcessor processor) {
        this.processor = processor;
    }

    protected MainPhase process(Game game ) {
        if (processor != null) {
            return processor.process(game);
        }else{
            return null;
        }
    }
}
