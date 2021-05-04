package viewer.menudisplay;

import controller.enums.Error;
import controller.enums.MenusMassages.Profile;


public class ProfileMenuDisplay {
    public static void display(Profile message) {
            System.out.println(message.getMessage());

    }

    public static void display(Error message) {
            System.out.println(message.getMassage());
    }

    public static void display(Profile message, String name) {
            System.out.printf(message.getMessage(), name);
            System.out.println();

    }

    public static void display(Error message, String name) {
            System.out.printf(message.getMassage(), name);
            System.out.println();

    }
}
