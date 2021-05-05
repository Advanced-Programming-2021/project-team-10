package model.gameprop.BoardProp;

import model.cards.cardsProp.MonsterCard;
import model.gameprop.cardvisibility.MonsterHouseVisibilityState;

public class MonsterHouse {
    MonsterCard monsterCard;
    MonsterHouseVisibilityState state;

    {
        monsterCard = null;
        state = MonsterHouseVisibilityState.EMPTY;
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
}
//TODO game map and where to add it