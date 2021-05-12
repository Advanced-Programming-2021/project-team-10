package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class ChangeDefenceOfMonsterCard extends ActionOfMagic {
    private static ChangeDefenceOfMonsterCard instance;

    {
        name = this.getClass().getSimpleName();
    }

    private ChangeDefenceOfMonsterCard() {
    }

    public static ChangeDefenceOfMonsterCard getInstance() {
        if (instance == null) instance = new ChangeDefenceOfMonsterCard();
        return instance;
    }

    @Override
    public void active() {
        super.active();
    }
}
