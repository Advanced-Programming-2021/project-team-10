package Viewer;

import Controller.ImportScanner;
import Controller.RegisterMenuController;
import Controller.UserInfoType;
import Model.LoginUser;
import Model.User;

import java.util.regex.Matcher;

public class RegisterMenu {
    private static RegisterMenu registerMenu;

    private RegisterMenu() {
    }


    private static void recognizeCommand(String command) {
        Matcher matcher;
        if ((matcher = Regex.getMatcher(command, Regex.menuEnter)).matches()) {
            RegisterMenuController.enterMenu(matcher);
        } else if (command.equals("menu show-current")) {
            RegisterMenuController.showCurrentMenu();
        } else if (Regex.getMatcher(command, Regex.createUser).matches()) {
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

            if (username == null || nickname == null || password == null) {
                return;
            }

            RegisterMenuController.createUser(username, nickname, password);

        } else if (command.contains("user login")) {
            if (command.matches(Regex.username) && command.matches(Regex.password)) {
                String username = getInfoFromMatcher(command, Regex.username);
                String password = getInfoFromMatcher(command, Regex.password);
                User user = User.getUserByUserInfo(username, UserInfoType.USERNAME);
                LoginUser.setUser(user);
                RegisterMenuController.login(password, user);
            }
        }
    }

    private static String getInfoFromMatcher(String command, String username) {
        Matcher matcher;
        String info = null;
        matcher = Regex.getMatcher(command, username);
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
