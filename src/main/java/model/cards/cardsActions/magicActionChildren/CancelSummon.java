package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class CancelSummon extends ActionOfMagic {
    private static CancelSummon instance;

    private CancelSummon(){
    }

    public static CancelSummon getInstance() {
        if (instance == null) instance = new CancelSummon();
        return instance;
    }

    @Override
    public void active() {
        super.active();
    }
}
