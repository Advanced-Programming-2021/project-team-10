package viewer;

import controller.enums.Error;
import controller.enums.MenusMassages.Duel;

public class DuelMenuDisplay {
    public static void display(Enum message) {
        if (message instanceof Duel) {
            System.out.println(((Duel) message).getMessage());
        }
        else if (message instanceof Error) {
            System.out.println(((Error) message).getMassage());
        }
        else {
            System.out.println("invalid enum type");
        }
    }

    public static void display(Enum message, String username) {
        if (message instanceof Duel) {
            System.out.printf(((Duel) message).getMessage(), username);
            System.out.println();
        }
        else if (message instanceof Error) {
            System.out.printf(((Error) message).getMassage(), username);
            System.out.println();
        }
        else {
            System.out.println("invalid enum type");
        }
    }
}
