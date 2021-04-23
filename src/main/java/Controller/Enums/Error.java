package Controller.Enums;

public enum Error {

    INVALID_COMMAND("invalid command"),
    INVALID_NAVIGATION("menu navigation is not possible"),
    INVALID_USER_OR_PASS("Username and password didn’t match!"),
    INVALID_ENTER_MENU("please login first"),
    INVALID_NICKNAME("user with nickname %s already exists"),
    INVALID_USERNAME("user with username %s already exists"),
    INVALID_LOGOUT("no user is logged in now"),
    INVALID_PASSWORD("current password is invalid"),
    INVALID_NEW_PASSWORD("please enter a new password");

    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public String getMassage() {
        return errorMessage;
    }
}
