package viewer.menudisplay;

import model.enums.Error;
import model.enums.MenusMassages.Duel;

public class DuelMenuDisplay {
    public static void display(Duel message) {
        System.out.println(message.getMessage());
    }

    public static void display(Error message) {
        System.out.println(message.getMassage());
    }

    public static void display(Duel message, String username) {

        System.out.printf(message.getMessage(), username);
        System.out.println();
    }

    public static void display(Error message, String username) {

        System.out.printf(message.getMassage(), username);
        System.out.println();

    }
}
