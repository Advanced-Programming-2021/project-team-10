package model.enums.MenusMassages;

public enum ImportExport {
    CURRENT_MENU("Import Export menu"),
    SUCCESSFULLY_ENTER_MENU("you entered Import Export menu successfully"),
    SUCCESSFULLY_EXIT_MENU("Import Export menu exited successfully");
    private final String message;

    ImportExport(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
