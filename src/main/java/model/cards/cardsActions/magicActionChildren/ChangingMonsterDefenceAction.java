package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.gamemodel.Game;

import java.util.ArrayList;

public class ChangingMonsterDefenceAction extends ActionOfMagic {
    private final int changeDefence;
    private final ArrayList<String> typesToChangeDefence;
    private final int addOrMinus;
    private final ArrayList<SideOfFeature> changeWhichTeamMonsterDefence;

    {
        name = this.getClass().getSimpleName();
    }

    public ChangingMonsterDefenceAction(int changeDefence, ArrayList<String> typesToChangeDefence, int addOrMinus, ArrayList<SideOfFeature> changeWhichTeamMonsterDefence) {
        this.changeDefence = changeDefence;
        this.typesToChangeDefence = typesToChangeDefence;
        this.addOrMinus = addOrMinus;
        this.changeWhichTeamMonsterDefence = changeWhichTeamMonsterDefence;
    }

    @Override
    public void active(Game game) {
        for (SideOfFeature sideOfFeature : changeWhichTeamMonsterDefence) {
            MonsterHouse[] monsterHouses = game.getPlayer(sideOfFeature).getBoard().getMonsterHouse();
            for (MonsterHouse monsterHouse : monsterHouses) {
                if (typesToChangeDefence.contains(monsterHouse.getMonsterCard().getRace().toString())) {
                    int newDefence = monsterHouse.getMonsterCard().getAttack();
                    newDefence += changeDefence * addOrMinus;
                    monsterHouse.getMonsterCard().setAttack(newDefence);
                }
            }
        }
        isActivatedBefore = true;
    }
}
