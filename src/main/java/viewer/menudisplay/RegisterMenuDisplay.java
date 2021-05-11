package viewer.menudisplay;

import model.enums.Error;
import model.enums.MenusMassages.Register;

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
        System.out.println(message.toString());
    }

    public void display(Error message) {
        System.out.println(message.toString());
    }

    public void display(Register message, String name) {
        System.out.printf(message.toString(), name);
        System.out.println();
    }

    public void display(Error message, String name) {
        System.out.printf(message.toString(), name);
        System.out.println();

    }
}
