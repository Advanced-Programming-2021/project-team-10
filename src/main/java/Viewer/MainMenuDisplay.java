package Viewer;

import Controller.Enums.Error;
import Controller.Enums.MenusMassages.Main;

public class MainMenuDisplay {
    public static void display(Enum message) {
        if (message instanceof Main) {
            System.out.println(((Main) message).getMainMessage());
        }
        else if (message instanceof Error) {
            Error output = (Error) message;
            System.out.println(output.getMassage());
        }
        else {
            System.out.println("invalid enum type");
        }
    }
}
