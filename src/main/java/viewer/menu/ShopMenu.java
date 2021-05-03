package viewer.menu;

import controller.ImportScanner;
import controller.enums.MenusMassages.ShopMessages;
import controller.menuControllers.ShopMenuController;
import viewer.Regex;
import viewer.display.ShopMenuDisplay;

import java.util.regex.Matcher;

public class ShopMenu {
    private static ShopMenu shopMenu;

    private ShopMenu(){
    }

    public static ShopMenu getInstance() {
        if (shopMenu == null) {
            shopMenu = new ShopMenu();
        }
        return shopMenu;
    }

    public static void recognizeCommand(String command){
        command = command.trim();
        Matcher matcher;
        if ((matcher = Regex.getMatcher(command, Regex.buyCard)).matches()) {
            String cardName = matcher.group("cardName");
            ShopMenuController.buyCard(cardName);
        } else if (Regex.getMatcher(command, Regex.showAllShop).matches()) {
            ShopMenuController.showAllCards();
        } else {
            ShopMenuController.invalidCommand();
        }
    }

    public void run(){
        String command;
        while (true) {
            command = ImportScanner.getInput();
            if (command.equals("menu exit")) {
                break;
            }
            recognizeCommand(command);
        }
        ShopMenuDisplay.display(ShopMessages.SUCCESSFULLY_EXIT_MENU);
    }
}
