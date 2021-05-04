package viewer.menudisplay;

import controller.enums.Error;
import controller.enums.MenusMassages.Main;

public class MainMenuDisplay {
    public static void display(Main message) {
        System.out.println(message.getMainMessage());
    }

    public static void display(Error message) {
        System.out.println(message.getMassage());
    }
}
