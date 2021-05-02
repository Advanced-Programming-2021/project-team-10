package controller.enums;

public enum Error {

    INVALID_COMMAND("invalid command"),
    INVALID_NAVIGATION("menu navigation is not possible"),
    INVALID_USER_OR_PASS("Username and password didn't match!"),
    INVALID_ENTER_MENU("please login first"),
    INVALID_NICKNAME("user with nickname %s already exists"),
    INVALID_USERNAME("user with username %s already exists"),
    INVALID_LOGOUT("no user is logged in now"),
    INVALID_PASSWORD("current password is invalid"),
    INVALID_NEW_PASSWORD("please enter a new password"),

    // DeckMenu errors:
    REPETITIOUS_DECK_NAME("deck with name %s already exists"),
    NOT_FOUND_DECK_NAME("deck with name %s does not exist"),
    NOT_FOUND_CARD_NAME_IN_COLLECTION("card with name %s does not exist in your collection or totally doesn't exist"),
    FULL_MAIN_DECK("main deck is full"),
    FULL_SIDE_DECK("side deck is full"),
    NUMBER_LIMITATION_PASSED("there are already three cards with name %s in deck %s"),
    NOT_FOUND_CARD_NAME_IN_MAIN_DECK("card with name %s does not exist in main deck"),
    NOT_FOUND_CARD_NAME_IN_SIDE_DECK("card with name %s does not exist in side deck"),
    //

    //ShopMenu errors:
    INVALID_CARD_NAME_IN_SHOP("there is no card with name %s"),
    NOT_ENOUGH_MONEY("not enough money");
    //


    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public String getMassage() {
        return errorMessage;
    }
}
