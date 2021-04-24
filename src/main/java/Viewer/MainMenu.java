package Viewer;

import Controller.Enums.MenusMassages.Main;
import Controller.ImportScanner;
import Controller.MainMenuControler;

import java.util.regex.Matcher;

public class MainMenu {
    private static MainMenu MAIN_MENU;

    public static MainMenu getInstance() {
        if (MAIN_MENU == null) {
            MAIN_MENU = new MainMenu();
        }
        return MAIN_MENU;
    }

    private static void recognizeCommand(String command) {
        Matcher matcher;
        if ((matcher = Regex.getMatcher(command, Regex.menuEnter)).matches()) {
            MainMenuControler.enterMenu(matcher);
        }
        else if (command.equals("menu show-current")) {
            MainMenuControler.showCurrentMenu();
        }
        else {
            MainMenuControler.invalidCommand();
        }
    }

    public void run() {
        String command;
        while (true) {
            command = ImportScanner.getInput();
            if (command.equals("menu exit")) {
                break;
            }
            recognizeCommand(command);
        }
        MainMenuDisplay.display(Main.SUCCESSFULLY_EXIT_MENU);
    }
}
