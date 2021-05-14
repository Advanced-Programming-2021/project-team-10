package controller.gamecontrollers.gamestagecontroller.handlers.attackdirect;

import model.enums.GameEnums.GamePhaseEnums.BattlePhase;
import model.gameprop.Player;
import model.gameprop.SelectedCardProp;

public abstract class AttackDirectProcessor {
    AttackDirectProcessor processor;

    public AttackDirectProcessor(AttackDirectProcessor processor) {
        this.processor = processor;
    }

    public String process(SelectedCardProp cardProp , Player target) {
        if (processor != null) {
            return processor.process(cardProp  ,target);
        } else return null;
    }
}
