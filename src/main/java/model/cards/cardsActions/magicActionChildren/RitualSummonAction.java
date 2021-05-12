package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class RitualSummonAction extends ActionOfMagic {
    private static RitualSummonAction instance;

    {
        name = this.getClass().getSimpleName();
    }

    public static RitualSummonAction getInstance() {
        if (instance == null) {
            instance = new RitualSummonAction();
        }
        return instance;
    }
}
