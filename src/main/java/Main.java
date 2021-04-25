import model.DataBase;
import viewer.RegisterMenu;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = DataBase.getInstance();
        dataBase.restoreDate();
        RegisterMenu registerMenu = RegisterMenu.getInstance();
        registerMenu.run();
    }
}
