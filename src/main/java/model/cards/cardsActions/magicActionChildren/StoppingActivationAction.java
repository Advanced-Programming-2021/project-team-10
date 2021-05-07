package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class StoppingActivationAction extends ActionOfMagic {
    private static StoppingActivationAction instance;

    private StoppingActivationAction(){}

    public static StoppingActivationAction getInstance() {
        if (instance == null) {
            instance = new StoppingActivationAction();
        }
        return instance;
    }
}
