package model.gameprop.BoardProp;

import model.cards.cardsProp.MagicCard;
import model.enums.GameEnums.cardvisibility.MagicHouseVisibilityState;

public class MagicHouse extends GameHouse {
    MagicCard magicCard;
    MagicHouseVisibilityState state;

    {
        magicCard = null;
        state = MagicHouseVisibilityState.E;
    }

    public void setMagicCard(MagicCard magicCard) {
        this.magicCard = magicCard;
    }

    public MagicHouseVisibilityState getState() {
        return state;
    }

    public void setState(MagicHouseVisibilityState state) {
        this.state = state;
    }

    public MagicCard getMagicCard() {
        return magicCard;
    }
}
