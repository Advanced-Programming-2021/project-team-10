package model.gameprop.gamemodel;

import model.enums.GameEnums.PlayerTurn;
import model.enums.GameEnums.TypeOfHire;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.Player;
import model.gameprop.SelectedCardProp;

public class Turn {
    PlayerTurn playerWithTurn;
    TypeOfHire typeOfHighLevelMonsterHire;
    MonsterHouse monsterHouseOfHiredMonster;
    SelectedCardProp selectedCardProp;
    int tributeNumber;
    boolean isCardDraw;

    {
        typeOfHighLevelMonsterHire = null;
        tributeNumber = 0;
        isCardDraw = false;
        monsterHouseOfHiredMonster = null;
    }

    public void setTributeNumber(int tributeNumber) {
        this.tributeNumber = tributeNumber;
    }

    public int getTributeNumber() {
        return tributeNumber;
    }

    public SelectedCardProp getSelectedCardProp() {
        return selectedCardProp;
    }

    public void setSelectedCardProp(SelectedCardProp selectedCardProp) {
        this.selectedCardProp = selectedCardProp;
    }

    protected Turn(PlayerTurn playerWithTurn) {
        this.playerWithTurn = playerWithTurn;
    }

    public boolean isCardDraw() {
        return isCardDraw;
    }

    public void setCardDraw() {
        isCardDraw = true;
    }

    public MonsterHouse getMonsterHouseOfHiredMonster() {
        return monsterHouseOfHiredMonster;
    }

    public void setMonsterHouseOfHiredMonster(MonsterHouse monsterHouseOfHiredMonster) {
        this.monsterHouseOfHiredMonster = monsterHouseOfHiredMonster;
    }

    public void setTypeOfHighLevelMonsterHire(TypeOfHire typeOfHighLevelMonsterHire) {
        this.typeOfHighLevelMonsterHire = typeOfHighLevelMonsterHire;
    }

    public TypeOfHire getTypeOfHighLevelMonsterHire() {
        return typeOfHighLevelMonsterHire;
    }

    public PlayerTurn getPlayerWithTurn() {
        return playerWithTurn;
    }
}
