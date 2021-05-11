package model.enums.GameEnums.GamePhaseEnums;

public enum General {
    SELECT_CARD_MESSAGE("card selected"),
    NEXT_PHASE_MESSAGE("phase: StAgE"),
    CARD_DESELECT_SUCCESSFULLY("card deselected"),
    CARD_SELECTED_SUCCESSFULLY("card selected successfully");
    String messageToString;

    General(String messageToString) {
        this.messageToString = messageToString;
    }

    public String toString() {
        return messageToString;
    }
}
