package model.enums.GameEnums.GamePhaseEnums;

public enum GeneralMessage {
    SELECT_CARD_MESSAGE("card selected"),
    NEXT_PHASE_MESSAGE("phase: %s"),
    DESELECT_CARD_MESSAGE("card deselected");
    String messageToString;

    GeneralMessage(String messageToString) {
        this.messageToString = messageToString;
    }

    public String getMessageToString() {
        return messageToString;
    }
}
