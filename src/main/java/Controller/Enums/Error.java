package Controller.Enums;

public enum Error {

    INVALID_COMMAND("invalid command"),
    INVALID_NAVIGATION("menu navigation is not possible"),
    INVALID_USER_OR_PASS("Username and password didn’t match!"),
    INVALID_ENTER_MENU("please login first"),
    INVALID_NICKNAME("user with nickname %s already exists"),
    INVALID_USERNAME("user with username %s already exists");

    private final String errorMessage;

    private Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public String getMassage() {
        return errorMessage;
    }
}
