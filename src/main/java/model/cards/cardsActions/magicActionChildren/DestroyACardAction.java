package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsProp.MagicCard;
import model.enums.GameEnums.SideOfFeature;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;

import java.util.ArrayList;

public class DestroyACardAction extends ActionOfMagic {
    private ArrayList<MonsterHouse> monstersToBeDestroyed;
    private ArrayList<MagicHouse> magicsToBeDestroyed;
    private int numberOfInputs;

    public DestroyACardAction(ArrayList<MonsterHouse> monstersToBeDestroyed, ArrayList<MagicHouse> magicsToBeDestroyed, int numberOfInputs) {
        this.monstersToBeDestroyed = monstersToBeDestroyed;
        this.magicsToBeDestroyed = magicsToBeDestroyed;
        this.numberOfInputs = numberOfInputs;
    }

    {
        name = this.getClass().getSimpleName();
    }

    @Override
    public void active() {
        PlayerBoard opponentBoard = GameInProcess.getGame().getPlayer(SideOfFeature.OPPONENT).getBoard();
        MonsterHouse[] opponentMonsterHouse = opponentBoard.getMonsterHouse();
        for (MonsterHouse monsterHouse : opponentMonsterHouse) {
            if (monsterHouse.getMonsterCard() != null) {
                opponentBoard.getGraveYard().addCardToGraveYard(monsterHouse.getMonsterCard());
                monsterHouse.setMonsterCard(null);
            }
        }
    }
}
