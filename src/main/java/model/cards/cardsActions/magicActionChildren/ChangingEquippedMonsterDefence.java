package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsProp.MonsterCard;
import model.gameprop.gamemodel.Game;

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
    public void active(Game game) {
        equipedMonster = ActionOfMagic.equipAMonsterWithSpell(this, game);
        int defence = equipedMonster.getDefence();
        defence += changeDefence * addOrMinus;
        equipedMonster.setDefence(defence);
        isActivatedBefore = true;
    }
}
