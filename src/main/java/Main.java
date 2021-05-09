import model.DataBase;
import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsActions.magicActionChildren.AddCardFromDeckTOHand;
import viewer.menu.RegisterMenu;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = DataBase.getInstance();
        dataBase.restoreDate();
        RegisterMenu registerMenu = RegisterMenu.getInstance();
        registerMenu.run();
    }
}
