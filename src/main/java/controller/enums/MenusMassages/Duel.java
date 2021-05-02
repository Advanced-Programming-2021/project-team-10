package controller.enums.MenusMassages;

public enum Duel {
    CURRENT_MENU("Duel menu"),
    SUCCESSFULLY_ENTER_MENU("you entered Duel menu successfully"),
    SUCCESSFULLY_EXIT_MENU("Duel menu exited successfully"),
    INVALID_SECOND_PLAYER("there is no player with this username"),
    INVALID_ACTIVE_DECK("%s has no active deck"),
    INVALID_NUMBER_OF_ROUNDS("number of rounds is not supported");

    private final String message;

    Duel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
