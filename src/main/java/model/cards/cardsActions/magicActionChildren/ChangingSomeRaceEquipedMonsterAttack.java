package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.Action;
import model.cards.cardsProp.MonsterCard;
import model.gameprop.gamemodel.Game;

import java.util.ArrayList;

public class ChangingSomeRaceEquipedMonsterAttack extends Action {
    private final ArrayList<String> typesToChangeAttack;
    private final int changeAttack;
    private final int addOrMinus;
    private MonsterCard equipedMonster;

    {
        name = this.getClass().getSimpleName();
    }

    public ChangingSomeRaceEquipedMonsterAttack(int changeAttack, int addOrMinus, ArrayList<String> typesToChangeAttack) {
        this.changeAttack = changeAttack;
        this.addOrMinus = addOrMinus;
        this.typesToChangeAttack = typesToChangeAttack;
    }

    public MonsterCard getEquipedMonster() {
        return equipedMonster;
    }

    @Override
    public void active(Game game) {
        equipedMonster = Action.equipAMonsterWithSpell(this, game);
        if (typesToChangeAttack.contains(equipedMonster.getRace().toString())) {
            int attack = equipedMonster.getAttack();
            attack += changeAttack * addOrMinus;
            equipedMonster.setAttack(attack);
            isActivatedBefore = true;
        }
        isActivatedBefore = true;
    }
}
