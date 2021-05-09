package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class ChangingMonsterAttackAction extends ActionOfMagic {
    private static ChangingLifePointAction instance;

    {
        name = this.getClass().getSimpleName();
    }

    public static ChangingLifePointAction getInstance() {
        if (instance == null) {
            instance = new ChangingLifePointAction();
        }
        return instance;
    }
}
