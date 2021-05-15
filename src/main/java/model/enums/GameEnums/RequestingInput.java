package model.enums.GameEnums;

public enum RequestingInput {
    FROM_GRAVEYARD("Enter the name of card you want to summon from graveyard"),
    GUESS_CARD("Declare a card name:"),
    MAGIC_CARD_TO_DESTROY("Declare a magic card to destroy:"),
    SET_EQUIPED_MONSTER("Declare a monster card you want to equip:");

    private final String message;

    RequestingInput(String message) {
        this.message = message;
    }


    public String toString() {
        return message;
    }
}
