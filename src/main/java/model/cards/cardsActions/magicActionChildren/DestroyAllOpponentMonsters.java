package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;

public class DestroyAllOpponentMonsters extends ActionOfMagic {
    {
        name = this.getClass().getSimpleName();
    }

    @Override
    public void active() {
        PlayerBoard opponentBoard = GameInProcess.getGame().getPlayer(SideOfFeature.OPPONENT).getBoard();
        for (MonsterHouse monsterHouse : opponentBoard.getMonsterHouse()) {
            if (monsterHouse.getMonsterCard() != null) {
                opponentBoard.getGraveYard().addCardToGraveYard(monsterHouse.getMonsterCard());
                monsterHouse.setMonsterCard(null);
            }
        }
        isActivatedBefore = true;
    }
}
