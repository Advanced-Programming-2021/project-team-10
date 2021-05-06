package controller.enums.GameEnums.GamePhaseEnums;

public enum DrawPhaseMessage {
    ADD_NEW_CARD("new card added to the hand : %s");
    String drawMessageToString;

    DrawPhaseMessage(String drawMessageToString) {
        this.drawMessageToString = drawMessageToString;
    }

    public String getMessage() {
        return drawMessageToString;
    }
}
