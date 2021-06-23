package controller.gamecontrollers.gamestagecontroller.handlers.attackdirect;

import model.enums.GameEnums.gamestage.GameMainStage;
import model.gameprop.Player;
import model.gameprop.SelectedCardProp;
import model.gameprop.gamemodel.Game;

public abstract class AttackDirectProcessor {
    AttackDirectProcessor processor;

    public AttackDirectProcessor(AttackDirectProcessor processor) {
        this.processor = processor;
    }

    public String process(Game game) {
        if (processor != null) {
            return processor.process(game);
        } else return null;
    }
}
