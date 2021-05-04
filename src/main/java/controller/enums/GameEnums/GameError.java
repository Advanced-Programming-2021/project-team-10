package controller.enums.GameEnums;

public enum GameError {
    INVALID_COMMAND("invalid command");
    String errorToString;
    GameError(String errorToString){
        this.errorToString = errorToString;
    }
}
