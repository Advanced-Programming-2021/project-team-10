package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.GameInProcess;
import model.gameprop.gamemodel.Game;

import java.util.ArrayList;

public class ChangingMonsterAttackAction extends ActionOfMagic {
    private final int changeAttack;
    private final ArrayList<String> typesToChangeAttack;
    private final int addOrMinus;
    private final ArrayList<SideOfFeature> changeWhichTeamMonsterAttack;

    {
        name = this.getClass().getSimpleName();
    }

    public ChangingMonsterAttackAction(int changeAttack, ArrayList<String> typesToChangeAttack, int addOrMinus, ArrayList<SideOfFeature> changeWhichTeamMonsterAttack) {
        this.changeAttack = changeAttack;
        this.typesToChangeAttack = typesToChangeAttack;
        this.addOrMinus = addOrMinus;
        this.changeWhichTeamMonsterAttack = changeWhichTeamMonsterAttack;
    }

    @Override
    public void active(Game game) {
        for (SideOfFeature sideOfFeature : changeWhichTeamMonsterAttack) {
            MonsterHouse[] monsterHouses = game.getPlayer(sideOfFeature).getBoard().getMonsterHouse();
            for (MonsterHouse monsterHouse : monsterHouses) {
                if (typesToChangeAttack.contains(monsterHouse.getMonsterCard().getRace().toString())) {
                    int newAttack = monsterHouse.getMonsterCard().getAttack();
                    newAttack += changeAttack * addOrMinus;
                    monsterHouse.getMonsterCard().setAttack(newAttack);
                }
            }
        }
        isActivatedBefore = true;
    }
}
