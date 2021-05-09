package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class AvoidAttackOfMonsters extends ActionOfMagic {
    private static AvoidAttackOfMonsters instance;

    {
        name = this.getClass().getSimpleName();
    }

    private AvoidAttackOfMonsters(){
    }

    public static AvoidAttackOfMonsters getInstance() {
        if (instance == null) instance = new AvoidAttackOfMonsters();
        return instance;
    }

    @Override
    public void active() {
        super.active();
    }
}
