package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class SummonMonsterFromGraveYardAction extends ActionOfMagic {
    private static SummonMonsterFromGraveYardAction instance;

    private SummonMonsterFromGraveYardAction(){}

    public static SummonMonsterFromGraveYardAction getInstance() {
        if (instance == null) {
            instance = new SummonMonsterFromGraveYardAction();
        }
        return instance;
    }

    @Override
    public void active() {
        super.active();
    }
}
