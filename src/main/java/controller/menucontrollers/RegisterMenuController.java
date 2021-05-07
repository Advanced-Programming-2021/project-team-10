package controller.menucontrollers;


import com.sanityinc.jargs.CmdLineParser;
import model.enums.Error;
import model.enums.MenusMassages.Register;
import model.enums.Menu;
import controller.MenuHandler;
import model.userProp.LoginUser;
import model.userProp.User;
import model.userProp.UserInfoType;
import viewer.menudisplay.RegisterMenuDisplay;

import java.util.regex.Matcher;

public class RegisterMenuController {

    private static final RegisterMenuDisplay MENU_DISPLAY = RegisterMenuDisplay.getInstance();

    public static void enterMenu(Matcher matcher) {
        if (matcher.group(1).equals("Main menu")) {
            if (null == LoginUser.getUser()) {
                MENU_DISPLAY.display(Error.INVALID_ENTER_MENU);
            } else {
                try {
                    MenuHandler.changeMenu(Menu.MAIN_MENU);
                } catch (CmdLineParser.OptionException e) {
                    e.printStackTrace();
                }
            }
        } else {
            if (MenuHandler.isMenuExist(matcher.group(1))) {
                MENU_DISPLAY.display(Error.INVALID_NAVIGATION);
            } else {
                MENU_DISPLAY.display(Error.INVALID_COMMAND);
            }
        }
    }

    public static void createUser(String username, String nickname, String password) {
        if (null != User.getUserByUserInfo(username, UserInfoType.USERNAME)) {
            MENU_DISPLAY.display(Error.INVALID_USERNAME, username);
            return;
        }
        if (null != User.getUserByUserInfo(username, UserInfoType.NICKNAME)) {
            MENU_DISPLAY.display(Error.INVALID_NICKNAME, nickname);
            return;
        }
        new User(username, nickname, password);
        MENU_DISPLAY.display(Register.SUCCESSFULLY_USER_CREATE);
    }

    public static void login(String password, User user) {
        if (null != user) {
            if (user.isPasswordMatch(password)) {
                if (LoginUser.getUser() == null)
                MENU_DISPLAY.display(Register.SUCCESSFULLY_LOGIN);
                LoginUser.setUser(user);
                return;
            }else{
                MENU_DISPLAY.display(Error.INVALID_LOGIN);
            }
        }
        MENU_DISPLAY.display(Error.INVALID_USER_OR_PASS);
    }

    public static void logout() {
        if (LoginUser.getUser() == null) {
            MENU_DISPLAY.display(Error.INVALID_LOGOUT);
        }
        else {
            LoginUser.setUser(null);
            MENU_DISPLAY.display(Register.SUCCESSFULLY_LOGOUT);
        }
    }

    public static void showCurrentMenu() {
        MENU_DISPLAY.display(Register.CURRENT_MENU);
    }

    public static void invalidCommand() {
        MENU_DISPLAY.display(Error.INVALID_COMMAND);
    }

}
