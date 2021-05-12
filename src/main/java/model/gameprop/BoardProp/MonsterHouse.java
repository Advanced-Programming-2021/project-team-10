package model.gameprop.BoardProp;

import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;

public class MonsterHouse extends GameHouse {
    MonsterCard monsterCard;
    MonsterHouseVisibilityState state;
    private boolean isMonsterAttacked ;
    {
        isMonsterAttacked = false;
        changePos = false;
        monsterCard = null;
        state = MonsterHouseVisibilityState.E;
    }

    public MonsterHouseVisibilityState getState() {
        return state;
    }

    public void setState(MonsterHouseVisibilityState state) {
        this.state = state;
    }

    public void setMonsterCard(MonsterCard monsterCard) {
        this.monsterCard = monsterCard;
    }

    public MonsterCard getMonsterCard() {
        return monsterCard;
    }

    public boolean isPosChange(){
        return changePos;
    }

    public void changePos(){
        changePos = true;
    }

    public void setMonsterAttacked(boolean monsterAttacked) {
        isMonsterAttacked = monsterAttacked;
    }

    public boolean isMonsterAttacked(){
        return isMonsterAttacked;
    }
}
//TODO game map and where to add it