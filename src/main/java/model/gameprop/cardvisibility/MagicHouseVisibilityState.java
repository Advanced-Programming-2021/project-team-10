package model.gameprop.cardvisibility;

public enum MagicHouseVisibilityState {
    EMPTY("E"),
    OCCUPIED("O"),
    HIDDEN("H");

    String stateOfCard;

    MagicHouseVisibilityState(String stateOfCard) {
        this.stateOfCard = stateOfCard;
    }

    public String getStateOfCard() {
        return stateOfCard;
    }
}
