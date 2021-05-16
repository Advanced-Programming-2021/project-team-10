package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.Action;
import model.cards.cardsProp.MonsterCard;
import model.gameprop.gamemodel.Game;

public class ChangingEquipedMonsterAttack extends Action {
    private MonsterCard equipedMonster;
    private final int changeAttack;
    private final int addOrMinus;

    {
        name = this.getClass().getSimpleName();
        equipedMonster = null;
        isActivatedBefore = false;
    }

    public ChangingEquipedMonsterAttack(int changeAttack, int addOrMinus) {
        this.addOrMinus = addOrMinus;
        this.changeAttack = changeAttack;
    }

    public MonsterCard getEquipedMonster() {
        return equipedMonster;
    }

    @Override
    public void active(Game game) {
        equipedMonster = Action.equipAMonsterWithSpell(this, game);
        int attack = equipedMonster.getAttack();
        attack += changeAttack * addOrMinus;
        equipedMonster.setAttack(attack);
        isActivatedBefore = true;
    }
}
