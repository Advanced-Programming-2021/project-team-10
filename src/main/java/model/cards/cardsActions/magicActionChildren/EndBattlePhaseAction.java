package model.cards.cardsActions.magicActionChildren;

import controller.gamecontrollers.GeneralController;
import model.cards.cardsActions.ActionOfMagic;
import model.gameprop.gamemodel.Game;

public class EndBattlePhaseAction extends ActionOfMagic {
    {
        name = this.getClass().getSimpleName();
    }

    @Override
    public void active(Game game) {
        GeneralController.getInstance().nextPhase(game);
        isActivatedBefore = true;
    }
}
