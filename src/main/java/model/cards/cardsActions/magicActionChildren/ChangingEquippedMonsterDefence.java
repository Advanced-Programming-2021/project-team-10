package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsProp.MonsterCard;

public class ChangingEquippedMonsterDefence extends ActionOfMagic {
    private MonsterCard equipedMonster;
    private final int changeDefence;
    private final int addOrMinus;

    {
        name = this.getClass().getSimpleName();
        equipedMonster = null;
        isActivatedBefore = false;
    }

    public ChangingEquippedMonsterDefence(int changeDefence, int addOrMinus){
        this.changeDefence = changeDefence;
        this.addOrMinus = addOrMinus;
    }

    public MonsterCard getEquipedMonster() {
        return equipedMonster;
    }

    @Override
    public void active() {
        equipedMonster = ActionOfMagic.equipAMonsterWithSpell(this);

        int defence = equipedMonster.getDefence();
        defence += changeDefence * addOrMinus;
        equipedMonster.setDefence(defence);
        isActivatedBefore = true;
    }
}
