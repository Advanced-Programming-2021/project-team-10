import com.sanityinc.jargs.CmdLineParser;
import model.DataBase;
import viewer.menu.RegisterMenu;

public class Main {
    public static void main(String[] args) throws CmdLineParser.OptionException {
        DataBase dataBase = DataBase.getInstance();
        dataBase.restoreDate();
        RegisterMenu registerMenu = RegisterMenu.getInstance();
        registerMenu.run();
    }
}
