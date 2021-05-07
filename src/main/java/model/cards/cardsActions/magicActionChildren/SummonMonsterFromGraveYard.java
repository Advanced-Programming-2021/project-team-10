package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class SummonMonsterFromGraveYard extends ActionOfMagic {
    private static SummonMonsterFromGraveYard instance;

    public static SummonMonsterFromGraveYard getInstance() {
        if (instance == null) {
            instance = new SummonMonsterFromGraveYard();
        }
        return instance;
    }

    @Override
    public void active() {
        super.active();
    }
}
