package controller.enums.rockpaperscissor;

public enum GameError {
    WRONG_WEAPON_CHOOSE("No such a weapon !! (you can only  choose rock paper or scissor");

    String errorMessageToString;

    GameError(String errorMessageToString) {
        this.errorMessageToString = errorMessageToString;
    }
}
