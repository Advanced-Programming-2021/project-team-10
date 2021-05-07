package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class DamageOpponentHealthBar extends ActionOfMagic {
    private static DamageOpponentHealthBar instance;

    private DamageOpponentHealthBar(){
    }

    public static DamageOpponentHealthBar getInstance() {
        if (instance == null) instance = new DamageOpponentHealthBar();
        return instance;
    }

    @Override
    public void active() {
        super.active();
    }
}
