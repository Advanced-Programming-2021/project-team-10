package model.enums.GameEnums;

public enum GameError {
    INVALID_COMMAND("invalid command"),
    INVALID_SHOW_CARD_REQUEST("this card is not visible"),
    INVALID_DESELECT_CARD_REQUEST("no card is selected yet"),
    INVALID_SELECTION("invalid selection"),
    EMPTY_SELECTION("no card in this place"),
    INVALID_SIDE_MENU_REQUEST("invalid side menu request");
    String errorToString;

    GameError(String errorToString) {
        this.errorToString = errorToString;
    }

    public String getErrorToString() {
        return errorToString;
    }
}
