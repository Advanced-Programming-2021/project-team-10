package model.enums.GameEnums;

public enum RequestingInput {
    FROM_GRAVEYARD("Enter the name of card you want to summon from graveyard"),
    GUESS_CARD("Declare a card name:"),
    CHOOSE_FIELD_CARD("Declare a field card:"),
    CHOOSE_FROM_OPPO_MONSTER_HOUSES("Declare one of your opponents monsters:");

    private final String errorMessage;

    RequestingInput(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public String toString() {
        return errorMessage;
    }
}
