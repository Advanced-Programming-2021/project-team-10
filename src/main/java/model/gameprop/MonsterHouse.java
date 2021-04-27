package model.gameprop;

import model.cards.cardsProp.MonsterCard;
import model.gameprop.cardvisibility.MonsterHouseVisibilityState;

public class MonsterHouse {
    MonsterCard monsterCard;
    MonsterHouseVisibilityState state;

    {
        monsterCard = null;
        state = MonsterHouseVisibilityState.EMPTY;
    }
}
//TODO game map and where to add it