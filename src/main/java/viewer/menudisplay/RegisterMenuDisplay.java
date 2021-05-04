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

    public void display(Enum massage) {

        if (massage instanceof Register) {
            Register outPut = (Register) massage;
            System.out.println(outPut.getMassage());
        } else if (massage instanceof Error) {
            Error outPut = (Error) massage;
            System.out.println(outPut.getMassage());
        } else {
            System.out.println("invalid type of enum");
        }

    }

    public void display(Enum massage, String name) {
        if (massage instanceof Register) {
            Register outPut = (Register) massage;
            System.out.printf(outPut.getMassage(), name);
            System.out.println();
        } else if (massage instanceof Error) {
            Error outPut = (Error) massage;
            System.out.printf(outPut.getMassage(), name);
            System.out.println();
        } else {
            System.out.println("invalid type of enum");
        }
    }
}
