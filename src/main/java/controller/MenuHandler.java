package controller;

import controller.enums.Menu;
import controller.enums.MenusMassages.Main;
import controller.enums.MenusMassages.Profile;
import controller.enums.MenusMassages.Register;
import controller.enums.MenusMassages.Scoreboard;
import viewer.*;

import java.util.ArrayList;

public class MenuHandler {
    private static final ArrayList<String> ALL_MENUS;

    static {
        ALL_MENUS = new ArrayList<>() {
            {
                add("Register menu");
                add("Main menu");
                add("Duel menu");
                add("Deck menu");
                add("Scoreboard menu");
                add("Profile menu");
                add("Shop menu");
            }
        };
    }

    public static void changeMenu(Menu menu) {
        if (menu == Menu.REGISTER_MENU) {
            RegisterMenu registerMenu = RegisterMenu.getInstance();
            System.out.println(Register.SUCCESSFULLY_ENTER_MENU.getMassage());
            registerMenu.run();
        }
        else if (menu == Menu.MAIN_MENU) {
            MainMenu mainMenu = MainMenu.getInstance();
            System.out.println(Main.SUCCESSFULLY_ENTER_MENU.getMainMessage());
            mainMenu.run();
        }
        else if (menu == Menu.SCORE_BOARD_MENU) {
            ScoreboardMenu scoreboardMenu = ScoreboardMenu.getInstance();
            ScoreboardMenuDisplay.display(Scoreboard.SUCCESSFULLY_ENTER_MENU);
            scoreboardMenu.run();
        }
        else if (menu == Menu.USER_PROFILE_MENU) {
            ProfileMenu profileMenu = ProfileMenu.getInstance();
            ProfileMenuDisplay.display(Profile.SUCCESSFULLY_ENTER_MENU);
            profileMenu.run();
        }
    }

    public static boolean isMenuExist(String menuName) {
        return ALL_MENUS.contains(menuName);
    }

}
