package controller.gamecontrollers.gamestagecontroller.handlers.changeposition;

import controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.MonsterProcessor;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.WantedPos;
import model.gameprop.Game;
import model.gameprop.SelectedCardProp;

public abstract class ChangePosProcessor {
    ChangePosProcessor processor;

    protected ChangePosProcessor(ChangePosProcessor processor) {
        this.processor = processor;
    }

    protected MainPhase process(SelectedCardProp cardProp , WantedPos pos) {
        if (processor != null) {
            return processor.process(cardProp, pos);
        }else{
            return null;
        }
    }
}
