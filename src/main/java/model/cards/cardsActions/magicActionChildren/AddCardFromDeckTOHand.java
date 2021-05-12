package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class AddCardFromDeckTOHand extends ActionOfMagic {
    private static AddCardFromDeckTOHand instance;

    {
        name = this.getClass().getSimpleName();
    }

    private AddCardFromDeckTOHand(){
    }

    public static AddCardFromDeckTOHand getInstance(){
        if (instance == null) instance = new AddCardFromDeckTOHand();
        return instance;
    }

    @Override
    public void active() {
        super.active();
    }
}
