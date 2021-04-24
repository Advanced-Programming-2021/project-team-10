import Model.DataBase;
import Viewer.RegisterMenu;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = DataBase.getInstance();
        dataBase.restoreDate();
        RegisterMenu registerMenu = RegisterMenu.getInstance();
        registerMenu.run();
    }
}
