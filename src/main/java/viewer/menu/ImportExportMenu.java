package viewer.menu;

import controller.ImportScanner;
import controller.menues.menuhandlers.menucontrollers.ImportExportMenuController;
import model.enums.Error;
import model.enums.MenusMassages.ImportExport;
import model.enums.MenusMassages.Main;
import model.userProp.LoginUser;
import viewer.Regex;
import viewer.menudisplay.MainMenuDisplay;

public class ImportExportMenu {
    private static ImportExportMenu instance;

    private ImportExportMenu() {}

    public static ImportExportMenu getInstance() {
        if (instance == null) {
            instance = new ImportExportMenu();
        }
        return instance;
    }

    private String recognizeCommand(String command) {
        if (command.equals("menu show-current")) {
            return ImportExport.CURRENT_MENU.toString();
        } else if (isCommandInValid(command)) {
            return Error.INVALID_COMMAND.toString();
        } else {
            return ImportExportMenuController.update(command);
        }
    }

    public void run() {
        System.out.println("you entered Import/Export menu Successfully");
        String command;
        while (true) {
            command = ImportScanner.getInput();
            if (command.equals("menu exit")) {
                System.out.println(ImportExport.SUCCESSFULLY_EXIT_MENU);
                break;
            }
            System.out.println(recognizeCommand(command));
        }
    }

    private boolean isCommandInValid(String command) {
        for (String pattern : Regex.importExportCommand) {
            if (command.matches(pattern))
                return false;
        }
        return true;
    }
}
