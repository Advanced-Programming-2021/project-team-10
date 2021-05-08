package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class AvoidOpponentsCardDraw extends ActionOfMagic {
    private static AvoidOpponentsCardDraw instance;

    private AvoidOpponentsCardDraw(){
    }

    public static AvoidOpponentsCardDraw getInstance() {
        if (instance == null) instance = new AvoidOpponentsCardDraw();
        return instance;
    }

    @Override
    public void active() {
        super.active();
    }
}
