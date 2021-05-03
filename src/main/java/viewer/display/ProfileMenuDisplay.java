package viewer.display;

import controller.enums.Error;
import controller.enums.MenusMassages.Profile;


public class ProfileMenuDisplay {
    public static void display(Enum message) {
        if (message instanceof Profile) {
            System.out.println(((Profile) message).getMessage());
        } else if (message instanceof Error) {
            System.out.println(((Error) message).getMassage());
        } else {
            System.out.println("invalid enum type");
        }
    }

    public static void display(Enum message, String name) {
        if (message instanceof Profile) {
            System.out.printf(((Profile) message).getMessage(), name);
            System.out.println();
        } else if (message instanceof Error) {
            Error outPut = (Error) message;
            System.out.printf(outPut.getMassage(), name);
            System.out.println();
        } else {
            System.out.println("invalid type of enum");
        }
    }
}
