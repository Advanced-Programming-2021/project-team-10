package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.GameInProcess;

import java.util.ArrayList;

public class ChangeDefenceOfMonsterCard extends ActionOfMagic {

    private int changeDefence;
    private ArrayList<String> typesToChangeAttack;
    private int addOrMinus;

    {
        name = this.getClass().getSimpleName();
    }


    @Override
    public void active() {
        MonsterHouse[] monsterHouses = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT).getBoard().getMonsterHouse();
        for (MonsterHouse monsterHouse : monsterHouses) {
            if (typesToChangeAttack.contains(monsterHouse.getMonsterCard().getRace().toString())) {
                int newAttack = monsterHouse.getMonsterCard().getAttack();
                newAttack += changeDefence * addOrMinus;
                monsterHouse.getMonsterCard().setAttack(newAttack);
            }
        }
    }
}
