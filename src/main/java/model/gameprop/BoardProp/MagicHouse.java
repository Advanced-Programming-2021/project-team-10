package model.gameprop.BoardProp;

import model.cards.cardsProp.MagicCard;
import model.gameprop.cardvisibility.MagicHouseVisibilityState;

public class MagicHouse {
    MagicCard magicCard;
    MagicHouseVisibilityState state;

    {
        magicCard = null;
        state = MagicHouseVisibilityState.EMPTY;
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
