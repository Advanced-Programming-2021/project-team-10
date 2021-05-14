package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class AddCardFromDeckToHand extends ActionOfMagic {
    private static AddCardFromDeckToHand instance;

    {
        name = this.getClass().getSimpleName();
    }

    private AddCardFromDeckToHand(){
    }

    public static AddCardFromDeckToHand getInstance(){
        if (instance == null) instance = new AddCardFromDeckToHand();
        return instance;
    }

    @Override
    public void active() {
        super.active();
    }
}
