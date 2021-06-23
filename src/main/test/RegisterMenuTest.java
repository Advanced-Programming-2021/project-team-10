import com.sanityinc.jargs.CmdLineParser;
import controller.menues.menuhandlers.menucontrollers.RegisterMenuController;
import model.userProp.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RegisterMenuTest {
    RegisterMenuController registerMenuController;

    @BeforeEach
    void initialize() {
        registerMenuController = RegisterMenuController.getInstance();
        User.setAllUsers(new ArrayList<>());
    }

    @Test
    @DisplayName("Register successful")
    void successfulRegister() {
        String resultToBeTested = null;
        try {
            resultToBeTested = registerMenuController.run("user create --username yaroo --nickname kaftarbaz --password 1234"); // successful
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        boolean firstUserCreation = resultToBeTested.equals("user created successfully!");

        Assertions.assertTrue(firstUserCreation);
    }
    @Test
    @DisplayName("Register attempt with repetitious username(unsuccessful)")
    void repetitiousUsername() {

        String resultFirst = null;
        String resultToBeTested = null;
        try {
            resultFirst = registerMenuController.run("user create --username yaroo --nickname kaftarbaz --password 1234"); // successful
            resultToBeTested = registerMenuController.run("user create --username yaroo --nickname angrybird --password 1234");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }


        boolean firstUserCreation = resultFirst.equals("user created successfully!");
        boolean secondUserCreation = resultToBeTested.equals("user with username yaroo already exists");

        Assertions.assertTrue(firstUserCreation);
        Assertions.assertTrue(secondUserCreation);
    }

    @Test
    @DisplayName("Register attempt with repetitious nickname(unsuccessful)")
    void repetitiousNickname() {
        String resultFirst = null;
        String resultToBeTested = null;
        try {
            resultFirst = registerMenuController.run("user create --username man --nickname kaftarbaz --password 1234"); // successful
            resultToBeTested = registerMenuController.run("user create --username too --nickname kaftarbaz --password 1234");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        boolean firstUserCreation = resultFirst.equals("user created successfully!");
        boolean secondUserCreation = resultToBeTested.equals("user with nickname kaftarbaz already exists");

        Assertions.assertTrue(firstUserCreation);
        Assertions.assertTrue(secondUserCreation);
    }

    @Test
    @DisplayName("Login successful")
    void successfulLogin(){
        String creatingUserResult = null;
        String resultToBeTested = null;
        try {
            creatingUserResult = registerMenuController.run("user create --username man --nickname kaftarbaz --password 1234"); // successful
            resultToBeTested = registerMenuController.run("user login --username man --password 1234");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        boolean userCreated = creatingUserResult.equals("user created successfully!");
        boolean userUnableToLogin = resultToBeTested.equals("user logged in successfully!");

        Assertions.assertTrue(userCreated);
        Assertions.assertTrue(userUnableToLogin);
    }

    @Test
    @DisplayName("Login attempt with a not created user(unsuccessful)")
    void notExistingUserLogin() {
        String resultToBeTested = null;
        try {
            resultToBeTested = registerMenuController.run("user login --username man --password 4321");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        boolean userUnableToLogin = resultToBeTested.equals("Username and password didn't match!");

        Assertions.assertTrue(userUnableToLogin);
    }

    @Test
    @DisplayName("Login attempt with wrong password(unsuccessful)")
    void invalidPassword() {
        String creatingUserResult = null;
        String resultToBeTested = null;
        try {
            creatingUserResult = registerMenuController.run("user create --username man --nickname kaftarbaz --password 1234"); // successful
            resultToBeTested = registerMenuController.run("user login --username man --password 4321");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        boolean userCreated = creatingUserResult.equals("user created successfully!");
        boolean userUnableToLogin = resultToBeTested.equals("Username and password didn't match!");

        Assertions.assertTrue(userCreated);
        Assertions.assertTrue(userUnableToLogin);
    }

    @Test
    @DisplayName("Show current menu")
    void showMenu() {
        String resultCommand = null;
        try {
            resultCommand = registerMenuController.run("menu show-current");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        boolean shownCorrectly = resultCommand.equals("Login Menu");

        Assertions.assertTrue(shownCorrectly);
    }

    @Test
    @DisplayName("Logout before logging in(unsuccessful)")
    void logoutBeforeLogin() {
        String resultLogoutWithoutCreation = null;

        //Not create user
        try {
            resultLogoutWithoutCreation = registerMenuController.run("user logout");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        boolean resultBoolean = resultLogoutWithoutCreation.equals("no user is logged in now");

        Assertions.assertTrue(resultBoolean);

        //Create user / Not log in

    }
}
