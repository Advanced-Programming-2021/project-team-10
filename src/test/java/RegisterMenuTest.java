import com.sanityinc.jargs.CmdLineParser;
import controller.menues.menuhandlers.menucontrollers.RegisterMenuController;
import model.userProp.LoginUser;
import model.userProp.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class RegisterMenuTest {
    RegisterMenuController registerMenuController;

    @BeforeEach
    void initialize() {
        registerMenuController = RegisterMenuController.getInstance();
        User.setAllUsers(new ArrayList<>());
        LoginUser.setUser(null);
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

        assert resultToBeTested != null;
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


        assert resultToBeTested != null;
        boolean secondUserCreation = resultToBeTested.equals("user with username yaroo already exists");

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

        assert resultFirst != null;
        boolean firstUserCreation = resultFirst.equals("user created successfully!");
        assert resultToBeTested != null;
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

        assert creatingUserResult != null;
        boolean userCreated = creatingUserResult.equals("user created successfully!");
        assert resultToBeTested != null;
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

        assert resultToBeTested != null;
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

        assert creatingUserResult != null;
        boolean userCreated = creatingUserResult.equals("user created successfully!");
        assert resultToBeTested != null;
        boolean userUnableToLogin = resultToBeTested.equals("Username and password didn't match!");

        Assertions.assertTrue(userCreated);
        Assertions.assertTrue(userUnableToLogin);
    }

    @Test
    @DisplayName("Login twice before logging out the first user")
    void loginTwice(){
        String loggingInUser2 = null;
        try {
            registerMenuController.run("user create --username man --nickname kaftarbaz --password 1234"); // successful
            registerMenuController.run("user create --username too --nickname random --password 1234"); // successful
            registerMenuController.run("user login --username man --password 1234");
            loggingInUser2 = registerMenuController.run("user login --username too --password 1234");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(loggingInUser2, "another user has login already");
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

        assert resultCommand != null;
        boolean shownCorrectly = resultCommand.equals("Login Menu");

        Assertions.assertTrue(shownCorrectly);
    }


    @Test
    @DisplayName("Logout successfully")
    void logoutSuccessful() {
        String resultCreation = null;
        String resultLogin = null;
        String resultLogout = null;
        try {
            resultCreation = registerMenuController.run("user create --username yaroo --nickname kaftarbaz --password 1234");
            resultLogin = registerMenuController.run("user login --username yaroo --password 1234");
            resultLogout = registerMenuController.run("user logout");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        assert resultCreation != null;
        boolean resultCreationBoolean = resultCreation.equals("user created successfully!");
        assert resultLogin != null;
        boolean resultLoginBoolean = resultLogin.equals("user logged in successfully!");
        assert resultLogout != null;
        boolean resultLogoutBoolean = resultLogout .equals("user logged out successfully!");

        Assertions.assertTrue(resultCreationBoolean);
        Assertions.assertTrue(resultLoginBoolean);
        Assertions.assertTrue(resultLogoutBoolean);
    }

    @Test
    @DisplayName("Logout before logging in(unsuccessful)")
    void logoutBeforeLogin() {

        //Not create user
        String resultLogoutWithoutCreation = null;
        try {
            resultLogoutWithoutCreation = registerMenuController.run("user logout");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        assert resultLogoutWithoutCreation != null;
        boolean resultBoolean = resultLogoutWithoutCreation.equals("no user is logged in now");

        Assertions.assertTrue(resultBoolean);

        //Create user / Not log in
        String resultCreation = null;
        String resultLogout = null;
        try {
            resultCreation = registerMenuController.run("user create --username yaroo --nickname kaftarbaz --password 1234");
            resultLogout = registerMenuController.run("user logout");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        assert resultCreation != null;
        boolean resultCreationBoolean = resultCreation.equals("user created successfully!");
        assert resultLogout != null;
        boolean resultLogoutBoolean = resultLogout .equals("no user is logged in now");

        Assertions.assertTrue(resultCreationBoolean);
        Assertions.assertTrue(resultLogoutBoolean);
    }

    @Test
    @DisplayName("Entering main menu before login and account creation(unsuccessful)")
    void enterMenuWithoutLogin() {
        //Not creating user
        String resultEnterMenu = null;
        try {
            resultEnterMenu = registerMenuController.run("menu enter Main menu");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        assert resultEnterMenu != null;
        boolean resultBoolean = resultEnterMenu.equals("please login first");

        Assertions.assertTrue(resultBoolean);

        //Creating user / Not logging in
        String resultCreation = null;
        try {
            resultCreation = registerMenuController.run("user create --username yaroo --nickname kaftarbaz --password 1234");
            resultEnterMenu = registerMenuController.run("menu enter Main menu");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        assert resultCreation != null;
        boolean resultCreationBoolean = resultCreation.equals("user created successfully!");
        boolean resultEnterMenuBoolean = resultEnterMenu.equals("please login first");

        Assertions.assertTrue(resultCreationBoolean);
        Assertions.assertTrue(resultEnterMenuBoolean);
    }


    @Test
    @DisplayName("Enter menu successful")
    void enterMenuSuccessful() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String resultCreation = null;
        String resultLogin = null;
        String resultEnterMenu = null;
        try {
            resultCreation = registerMenuController.run("user create --username yaroo --nickname kaftarbaz --password 1234");
            resultLogin = registerMenuController.run("user login --username yaroo --password 1234");
            System.setIn(new ByteArrayInputStream("user logout\n".getBytes())); // simulating input
            resultEnterMenu = registerMenuController.run("menu enter Main menu");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        assert resultCreation != null;
        boolean resultCreationBoolean = resultCreation.equals("user created successfully!");
        assert resultLogin != null;
        boolean resultLoginBoolean = resultLogin.equals("user logged in successfully!");
        assert resultEnterMenu != null;
        boolean resultEnterMenuBoolean = resultEnterMenu.equals("enter Main menu successfully");

        Assertions.assertTrue(resultCreationBoolean);
        Assertions.assertTrue(resultLoginBoolean);
        Assertions.assertTrue(resultEnterMenuBoolean);
        Assertions.assertEquals("you entered Main menu successfully\r\nUser logout successfully\r\n", outContent.toString());
    }

    @Test
    @DisplayName("Not Identifying which menu to enter")
    void notIdentifyingTargetMenu() {
        String resultEnterMenu = null;
        try {
            registerMenuController.run("user create --username yaroo --nickname kaftarbaz --password 1234");
            registerMenuController.run("user login --username yaroo --password 1234");
            resultEnterMenu = registerMenuController.run("menu enter Some random menu");
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

        Assertions.assertNull(resultEnterMenu);
    }

    @Test
    @DisplayName("Not identifying the command")
    void notIdentifyingCommand() {
        try {
            Assertions.assertNull(registerMenuController.run(""));
            Assertions.assertNull(registerMenuController.run("ye dastoor ke jozv dastoorat nist!"));
        } catch (CmdLineParser.OptionException e) {
            e.printStackTrace();
        }

    }

}
