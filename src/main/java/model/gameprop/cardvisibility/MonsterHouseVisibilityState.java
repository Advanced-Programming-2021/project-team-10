package model.gameprop.cardvisibility;

public enum MonsterHouseVisibilityState {
    EMPTY("E"),
    OFFENSIVE_OCCUPIED("OO"),
    DEFENSIVE_OCCUPIED("DO"),
    DEFENSIVE_HIDDEN("DH");

    private String stateOfCard;

    MonsterHouseVisibilityState(String stateOfCard) {
        this.stateOfCard = stateOfCard;
    }

    public String getStateOfCard() {
        return stateOfCard;
    }
}
