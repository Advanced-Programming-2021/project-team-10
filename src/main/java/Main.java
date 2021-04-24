import Controller.ProfileMenuControler;
import Model.DataBase;
import Viewer.Regex;
import Viewer.RegisterMenu;

import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = DataBase.getInstance();
        dataBase.restoreDate();
        RegisterMenu registerMenu = RegisterMenu.getInstance();
        registerMenu.run();
    }
}
