package viewer.menudisplay;

import controller.enums.Error;
import controller.enums.MenusMassages.Register;

public class RegisterMenuDisplay {

    private static RegisterMenuDisplay display;

    private RegisterMenuDisplay() {
    }

    public static RegisterMenuDisplay getInstance() {
        if (display == null)
            display = new RegisterMenuDisplay();
        return display;
    }

    public void display(Register message) {
        System.out.println(message.getMassage());
    }

    public void display(Error message) {
        System.out.println(message.getMassage());
    }

    public void display(Register message, String name) {
        System.out.printf(message.getMassage(), name);
        System.out.println();
    }

    public void display(Error message, String name) {
        System.out.printf(message.getMassage(), name);
        System.out.println();

    }
}
