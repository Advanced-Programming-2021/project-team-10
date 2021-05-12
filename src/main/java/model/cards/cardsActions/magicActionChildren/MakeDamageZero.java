package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class MakeDamageZero extends ActionOfMagic {
    private static MakeDamageZero instance;

    {
        name = this.getClass().getSimpleName();
    }

    private MakeDamageZero() {
    }

    public static MakeDamageZero getInstance() {
        if (instance == null) instance = new MakeDamageZero();
        return instance;
    }

    @Override
    public void active() {
        super.active();
    }
}
