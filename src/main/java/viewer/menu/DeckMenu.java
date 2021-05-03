package viewer.menu;


import controller.ImportScanner;
import controller.enums.MenusMassages.DeckMessages;
import controller.menuControllers.DeckController;
import viewer.Regex;
import viewer.display.DeckMenuDisplay;

import java.util.regex.Matcher;

public class DeckMenu {
    private static DeckMenu deckMenu;

    private DeckMenu() {
    }

    public static DeckMenu getinstance() {
        if (deckMenu == null) {
            deckMenu = new DeckMenu();
        }
        return deckMenu;
    }

    private static void recognizeCommand(String command) {
        boolean haveRecognizedCommand = false;
        Matcher matcher;
        if (command.equals("menu show-current")) {
            DeckController.showCurrent();
        } else if ((matcher = Regex.getMatcher(command, Regex.createDeck)).matches()) {
            DeckController.createDeck(matcher.group("deckName"));
        } else if ((matcher = Regex.getMatcher(command, Regex.deleteDeck)).matches()) {
            DeckController.deleteDeck(matcher.group("deckName"));
        } else if ((matcher = Regex.getMatcher(command, Regex.activateDeck)).matches()) {
            DeckController.activateDeck(matcher.group("deckName"));
        } else if (command.equals("deck show --all")) {
            DeckController.showAllDecks();
        } else if ((matcher = Regex.getMatcher(command, Regex.showOneMainDeck)).matches()) {
            String deckName = matcher.group("deckName");
            DeckController.showOneMainDeck(deckName);
        } else {
            for (int i = 0; i < 2; i++) {
                if ((matcher = Regex.getMatcher(command, Regex.showOneSideDeck[i])).matches()) {
                    haveRecognizedCommand = true;
                    String deckName = matcher.group("deckName");
                    DeckController.showOneSideDeck(deckName);
                    break;
                }
            }
        }
        if (!haveRecognizedCommand) {
            for (int i = 0; i < 2; i++) {
                if ((matcher = Regex.getMatcher(command, Regex.addCardToMainDeck[i])).matches()) {
                    haveRecognizedCommand = true;
                    String cardName = matcher.group("cardName");
                    String deckName = matcher.group("deckName");
                    DeckController.addCardToMainDeck(cardName, deckName);
                    break;
                }
            }
        }
        if (!haveRecognizedCommand) {
            for (int i = 0; i < 6; i++) {
                if ((matcher = Regex.getMatcher(command, Regex.addCardToSideDeck[i])).matches()) {
                    haveRecognizedCommand = true;
                    String cardName = matcher.group("cardName");
                    String deckName = matcher.group("deckName");
                    DeckController.addCardToSideDeck(cardName, deckName);
                    break;
                }
            }
        }
        if (!haveRecognizedCommand) {
            for (int i = 0; i < 2; i++) {
                if ((matcher = Regex.getMatcher(command, Regex.removeCardFromMainDeck[i])).matches()) {
                    haveRecognizedCommand = true;
                    String cardName = matcher.group("cardName");
                    String deckName = matcher.group("deckName");
                    DeckController.removeCardFromMainDeck(cardName, deckName);
                    break;
                }
            }
        }
        if (!haveRecognizedCommand) {
            for (int i = 0; i < 6; i++) {
                if ((matcher = Regex.getMatcher(command, Regex.removeCardFromSideDeck[i])).matches()) {
                    haveRecognizedCommand = true;
                    String cardName = matcher.group("cardName");
                    String deckName = matcher.group("deckName");
                    DeckController.removeCardFromSideDeck(cardName, deckName);
                    break;
                }
            }
        }
        System.out.println("invalid command");

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
        DeckMenuDisplay.display(DeckMessages.SUCCESSFULLY_EXIT_MENU);
    }
}
