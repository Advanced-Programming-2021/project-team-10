package model.enums.GameEnums.GamePhaseEnums;

public enum MainPhase {
    SUMMONED_SUCCESSFULLY("summon successfully"),
    SET_SUCCESSFULLY("set successfully"),
    CANT_SUMMON_CARD("cant summon this card"),
    HIRE_MONSTER_BEFORE("you already summoned/set on this turn"),
    BOARD_IS_FULL("player board is full"),
    NO_CARD_SELECTED_YET("no card selected yet");
    String messageToString;

    MainPhase(String messageToString) {
        this.messageToString = messageToString;
    }

    public String toString() {
        return messageToString;
    }
}
