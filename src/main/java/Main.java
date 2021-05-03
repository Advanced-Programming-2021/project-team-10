import model.DataBase;
import viewer.menu.RegisterMenu;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = DataBase.getInstance();
        dataBase.restoreDate();
        RegisterMenu registerMenu = RegisterMenu.getInstance();
        registerMenu.run();
    }
}
