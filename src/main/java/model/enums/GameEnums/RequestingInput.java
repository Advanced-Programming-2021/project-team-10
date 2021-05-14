package model.enums.GameEnums;

public enum RequestingInput {
    FROM_GRAVEYARD("Enter the name of card you want to summon from graveyard"),
    GUESS_CARD("Declare a card name:");

    private final String errorMessage;

    RequestingInput(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public String toString() {
        return errorMessage;
    }
}
