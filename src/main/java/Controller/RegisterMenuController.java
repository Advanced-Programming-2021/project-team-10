package Controller;


import Model.LoginUser;
import Model.User;

import java.util.regex.Matcher;

public class RegisterMenuController {

    public static String enterMenu(Matcher matcher) {
        if (matcher.group(1).equals("Main menu")) {
            if (null == LoginUser.getUser()) {
                return "please login first";
            } else {

                return null;
            }
        } else {
            if (MenuHandler.isMenuExist(matcher.group(1))) {
                return "menu navigation is not possible";
            } else {
                return "invalid menu name";
            }
        }
    }

    public static String createUser(String username, String nickname, String password) {
        if (null != User.getUserByUserInfo(username, UserInfoType.USERNAME)) {
            return "user with username " + username + " already exists ";
        } else if (null != User.getUserByUserInfo(username, UserInfoType.NICKNAME)) {
            return "user with nickname " + nickname + " already exists";
        } else {
            new User(username, nickname, password);
            return "user created successfully!";
        }
    }

    public static String login(String password, User user) {
        if (null != user) {
            if (user.isPasswordMatch(password)) {
                return "user logged in successfully!";
            }
        }
        return "Username and password didn't match!"; //change '
    }


}
