package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.Action;
import model.cards.cardsProp.MonsterCard;
import model.gameprop.gamemodel.Game;

import java.util.ArrayList;

public class ChangingSomeRaceEquipedMonsterDefence extends Action {
    private final ArrayList<String> typesToChangeDefence;
    private final int changeDefence;
    private final int addOrMinus;
    private MonsterCard equipedMonster;

    {
        name = this.getClass().getSimpleName();
    }

    public ChangingSomeRaceEquipedMonsterDefence(int changeDefence, int addOrMinus, ArrayList<String> typesToChangeDefence) {
        this.changeDefence = changeDefence;
        this.addOrMinus = addOrMinus;
        this.typesToChangeDefence = typesToChangeDefence;
    }

    public MonsterCard getEquipedMonster() {
        return equipedMonster;
    }

    @Override
    public void active(Game game) {
        equipedMonster = Action.equipAMonsterWithSpell(this, game);
        if (typesToChangeDefence.contains(equipedMonster.getRace().toString())) {
            int defence = equipedMonster.getAttack();
            defence += changeDefence * addOrMinus;
            equipedMonster.setDefence(defence);
            isActivatedBefore = true;
        }
        isActivatedBefore = true;
    }
}
