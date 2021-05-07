package model.cards.cardsActions.magicActionChildren;

import controller.enums.GameEnums.SideOfFeature;
import model.cards.cardsActions.ActionOfMagic;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;
import model.gameprop.cardvisibility.MonsterHouseVisibilityState;

public class DestroyACardAction extends ActionOfMagic {
    private static DestroyACardAction instance;

    public static DestroyACardAction getInstance() {
        if (instance == null) {
            instance = new DestroyACardAction();
        }
        return instance;
    }

    @Override
    public void active() {
        PlayerBoard opponentBoard = GameInProcess.getGame().getPlayer(SideOfFeature.OPPONENT).getBoard();
        MonsterHouse[] opponentMonsterHouse = opponentBoard.getMonsterHouse();
        for (MonsterHouse monsterHouse : opponentMonsterHouse) {
            if (monsterHouse.getMonsterCard() != null) {
                opponentBoard.getGraveYard().addCardToGraveYard(monsterHouse.getMonsterCard());
                monsterHouse.setMonsterCard(null);
                monsterHouse.setState(MonsterHouseVisibilityState.EMPTY);
            }
        }
    }
}
