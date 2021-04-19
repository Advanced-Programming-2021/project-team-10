package Controller.Enums.MenusMassages;

public enum Register {

    CURRENT_MENU("Login Menu"),
    SUCCESSFULLY_USER_CREATE("user created successfully!"),
    SUCCESSFULLY_LOGIN("user logged in successfully!");


    private final String registerMessage;

    Register(String registerMessage) {
        this.registerMessage = registerMessage;
    }

    public String getMassage() {
        return registerMessage;
    }
}
