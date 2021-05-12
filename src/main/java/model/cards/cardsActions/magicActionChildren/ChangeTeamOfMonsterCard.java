package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;

public class ChangeTeamOfMonsterCard extends ActionOfMagic {
    private static ChangeTeamOfMonsterCard instance;

    {
        name = this.getClass().getSimpleName();
    }

    private ChangeTeamOfMonsterCard(){
    }

    public static ChangeTeamOfMonsterCard getInstance() {
        if (instance == null) instance = new ChangeTeamOfMonsterCard();
        return instance;
    }

    @Override
    public void active() {
        super.active();
    }
}
