package Controller;

import Viewer.RegisterMenu;

import java.util.ArrayList;

public class MenuHandler {
    private static final ArrayList<String> ALL_MENUS;

    static {
        ALL_MENUS = new ArrayList<>() {
            {
                add("Register menu");
                add("Main menu");
            }
        };
    }

    public static void changeMenu(Menu menu) {
        if (menu == Menu.REGISTER_MENU) {
            RegisterMenu registerMenu = RegisterMenu.getInstance();
            registerMenu.run();
        }
        else if (menu == Menu.MAIN_MENU) {

        }
    }

    public static boolean isMenuExist(String menuName) {
        return ALL_MENUS.contains(menuName);
    }

}
