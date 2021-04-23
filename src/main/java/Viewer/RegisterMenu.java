package Viewer;

import Controller.ImportScanner;
import Controller.RegisterMenuController;
import Model.User;
import Model.UserInfoType;

import java.util.regex.Matcher;

public class RegisterMenu {
    private static RegisterMenu registerMenu;

    private RegisterMenu() {
    }


    private static void recognizeCommand(String command) {
        Matcher matcher;
        if ((matcher = Regex.getMatcher(command, Regex.menuEnter)).matches()) {
            RegisterMenuController.enterMenu(matcher);
            return;
        } else if (command.equals("menu show-current")) {
            RegisterMenuController.showCurrentMenu();
        } else if (Regex.getMatcher(command, Regex.createUser).matches()) {
            findUserDate(command);
            return;
        } else if (command.contains("user login")) {
            if (command.matches(Regex.username) && command.matches(Regex.password)) {
                String username = getInfoFromMatcher(command, Regex.username);
                String password = getInfoFromMatcher(command, Regex.password);
                User user = User.getUserByUserInfo(username, UserInfoType.USERNAME);
                RegisterMenuController.login(password, user);
                return;
            }
        }
        RegisterMenuController.invalidCommand();
    }

    private static void findUserDate(String command) {
        String username = null;
        String nickname = null;
        String password = null;

        if (Regex.getMatcher(command, Regex.username).matches()) {
            username = getInfoFromMatcher(command, Regex.username);
        }

        if (Regex.getMatcher(command, Regex.nickname).matches()) {
            nickname = getInfoFromMatcher(command, Regex.nickname);
        }

        if (Regex.getMatcher(command, Regex.password).matches()) {
            password = getInfoFromMatcher(command, Regex.password);
        }

        if (checkForDoubleFlagUse(command)) return;

        if (newUserInfoNotFound(username, nickname, password)) return;

        RegisterMenuController.createUser(username, nickname, password);
    }

    private static boolean checkForDoubleFlagUse(String command) {
        if (Regex.doubleFlagUsing(command, "--nickname") ||
                Regex.doubleFlagUsing(command, "--username") ||
                Regex.doubleFlagUsing(command, "--password")) {
            RegisterMenuController.invalidCommand();
            return true;
        }
        return false;
    }

    private static boolean newUserInfoNotFound(String username, String nickname, String password) {
        if (username == null || nickname == null || password == null) {
            RegisterMenuController.invalidCommand();
            return true;
        }
        return false;
    }

    private static String getInfoFromMatcher(String command, String regexInfo) {
        Matcher matcher;
        String info = null;
        matcher = Regex.getMatcher(command, regexInfo);
        if (matcher.find()) {
            info = matcher.group(1);
        }
        return info;
    }

    public static RegisterMenu getInstance() {
        if (registerMenu == null)
            registerMenu = new RegisterMenu();

        return registerMenu;
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
    }

}
