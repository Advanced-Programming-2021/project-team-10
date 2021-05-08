package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class FlipCardAction extends ActionOfMagic {
    private static FlipCardAction instance;

    public static FlipCardAction getInstance() {
        if (instance == null) {
            instance = new FlipCardAction();
        }
        return instance;
    }
}
