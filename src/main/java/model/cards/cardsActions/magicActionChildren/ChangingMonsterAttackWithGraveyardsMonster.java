package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsProp.Card;
import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;

import java.util.ArrayList;

public class ChangingMonsterAttackWithGraveyardsMonster extends ActionOfMagic {
    private final ArrayList<String> typesToChangeAttack;
    private final int changeAttackForEachMonsterInGraveyard;
    private final int addOrMinus;
    private final ArrayList<SideOfFeature> countWhichGraveYards;
    private final ArrayList<SideOfFeature> changeWhichTeamMonstersAttack;

    {
        name = this.getClass().getSimpleName();
    }

    public ChangingMonsterAttackWithGraveyardsMonster(int changeAttackForEachMonsterInGraveyard, int addOrMinus, ArrayList<String> typesToChangeAttack, ArrayList<SideOfFeature> countWhichGraveYards, ArrayList<SideOfFeature> changeWhichTeamMonstersAttack) {
        this.addOrMinus = addOrMinus;
        this.changeAttackForEachMonsterInGraveyard = changeAttackForEachMonsterInGraveyard;
        this.typesToChangeAttack = typesToChangeAttack;
        this.changeWhichTeamMonstersAttack = changeWhichTeamMonstersAttack;
        this.countWhichGraveYards = countWhichGraveYards;
    }

    @Override
    public void active() {
        int countMonstersInGraveyard = 0;
        for (SideOfFeature countWhichGraveYard : countWhichGraveYards) {
            PlayerBoard playerBoard = GameInProcess.getGame().getPlayer(countWhichGraveYard).getBoard();
            for (Card destroyedCard : playerBoard.getGraveYard().getDestroyedCards()) {
                if (destroyedCard instanceof MonsterCard) {
                    countMonstersInGraveyard++;
                }
            }
        }
        int changeAttack = countMonstersInGraveyard * changeAttackForEachMonsterInGraveyard * addOrMinus;
        for (SideOfFeature sideOfFeature : changeWhichTeamMonstersAttack) {
            PlayerBoard playerBoard = GameInProcess.getGame().getPlayer(sideOfFeature).getBoard();
            for (MonsterHouse monsterHouse : playerBoard.getMonsterHouse()) {
                if (typesToChangeAttack.contains(monsterHouse.getMonsterCard().getRace().toString())) {
                    int monsterAttack = monsterHouse.getMonsterCard().getAttack();
                    monsterAttack += changeAttack;
                    monsterHouse.getMonsterCard().setAttack(monsterAttack);
                }
            }
        }
        isActivatedBefore = true;
    }
}
