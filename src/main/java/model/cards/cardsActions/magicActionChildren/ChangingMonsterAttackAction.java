package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.GameInProcess;

import java.util.ArrayList;

public class ChangingMonsterAttackAction extends ActionOfMagic {
    private final int changeAttack;
    private final ArrayList<String> typesToChangeAttack;
    private final int addOrMinus;

    {
        name = this.getClass().getSimpleName();
    }

    public ChangingMonsterAttackAction(int changeAttack, ArrayList<String> typesToChangeAttack, int addOrMinus) {
        this.changeAttack = changeAttack;
        this.typesToChangeAttack = typesToChangeAttack;
        this.addOrMinus = addOrMinus;
    }

    @Override
    public void active() {
        MonsterHouse[] monsterHouses = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT).getBoard().getMonsterHouse();
        for (MonsterHouse monsterHouse : monsterHouses) {
            if (typesToChangeAttack.contains(monsterHouse.getMonsterCard().getRace().toString())) {
                int newAttack = monsterHouse.getMonsterCard().getAttack();
                newAttack += changeAttack * addOrMinus;
                monsterHouse.getMonsterCard().setAttack(newAttack);
            }
        }
    }
}
