package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class EndBattlePhaseAction extends ActionOfMagic {
    private static EndBattlePhaseAction instance;

    public static EndBattlePhaseAction getInstance() {
        if (instance == null) {
            instance = new EndBattlePhaseAction();
        }
        return instance;
    }
}
