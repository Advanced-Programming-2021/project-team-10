package controller.menuControllers;

import controller.enums.Error;
import controller.enums.MenusMassages.DeckMessages;
import model.cards.cardsProp.Card;
import model.userProp.Deck;
import model.userProp.LoginUser;
import org.apache.commons.logging.Log;
import viewer.DeckMenu;
import viewer.DeckMenuDisplay;

import java.util.*;

public class DeckController {
    public static void showCurrent() {
        DeckMenuDisplay.display(DeckMessages.CURRENT_MENU);
    }

    public static void createDeck(String name) {
        if (LoginUser.getUser().getDeckByName(name) != null) {
            DeckMenuDisplay.display(Error.REPETITIOUS_DECK_NAME, name);
        } else {
            new Deck(name, LoginUser.getUser());
            DeckMenuDisplay.display(DeckMessages.SUCCESSFULLY_CREATE_DECK);
        }
    }

    public static void deleteDeck(String name) {
        if (LoginUser.getUser().getDeckByName(name) == null) {
            DeckMenuDisplay.display(Error.NOT_FOUND_DECK_NAME, name);
        } else {
            Deck selectedDeck = LoginUser.getUser().getDeckByName(name);
            selectedDeck.deleteDeckFromOwner();
            DeckMenuDisplay.display(DeckMessages.SUCCESSFULLY_DELETE_DECK);
        }
    }

    public static void activateDeck(String name) {
        if (LoginUser.getUser().getDeckByName(name) == null) {
            DeckMenuDisplay.display(Error.NOT_FOUND_DECK_NAME, name);
        } else {
            Deck selectedDeck = LoginUser.getUser().getDeckByName(name);
            LoginUser.getUser().setActiveDeck(selectedDeck);
            DeckMenuDisplay.display(DeckMessages.SUCCESSFULLY_ACTIVATE_DECK);
        }
    }

    public static void showAllDecks() {
        ArrayList<Deck> decks = LoginUser.getUser().getAllDecks();
        Deck activeDeck = LoginUser.getUser().getActiveDeck();
        Deck[] sortedDecks = DeckController.deckNameAlphabetSorter(decks);
        DeckMenuDisplay.showAllDecks(sortedDecks, activeDeck);
    }

    public static Deck[] deckNameAlphabetSorter(ArrayList<Deck> decks) {
        Deck[] sortedDecks =  decks.toArray(new Deck[0]);
        Comparator<Deck> deckNameSorter = Comparator.comparing(Deck::getName);

        Arrays.sort(sortedDecks, deckNameSorter);
        return sortedDecks;
    }

    public static void showOneMainDeck(String deckName) {

    }

    public static void showOneSideDeck(String deckName) {

    }

    public static void addCardToMainDeck(String cardName, String deckName) {
        Deck selectedDeck = LoginUser.getUser().getDeckByName(deckName);
        Card selectedCard = Card.getCardByName(cardName);
        if (selectedCard == null) {
            DeckMenuDisplay.display(Error.NOT_FOUND_CARD_NAME_IN_COLLECTION, cardName);
        } else if (selectedDeck == null) {
            DeckMenuDisplay.display(Error.NOT_FOUND_DECK_NAME, deckName);
        } else if (selectedDeck.getMainDeck().size() > 60) {
            DeckMenuDisplay.display(Error.FULL_MAIN_DECK);
        } else if (selectedDeck.numOfCardOccurrence(cardName, "both decks") == 3) {
            DeckMenuDisplay.display(Error.NUMBER_LIMITATION_PASSED, cardName, deckName);
        } else {
            selectedDeck.addCardToMainDeck(selectedCard);
            DeckMenuDisplay.display(DeckMessages.SUCCESSFULLY_ADD_CARD_TO_DECK);
        }
    }

    public static void addCardToSideDeck(String cardName, String deckName) {
        Deck selectedDeck = LoginUser.getUser().getDeckByName(deckName);
        Card selectedCard = Card.getCardByName(cardName);
        if (selectedCard == null) {
            DeckMenuDisplay.display(Error.NOT_FOUND_CARD_NAME_IN_COLLECTION, cardName);
        } else if (selectedDeck == null) {
            DeckMenuDisplay.display(Error.NOT_FOUND_DECK_NAME, deckName);
        } else if (selectedDeck.getMainDeck().size() > 15) {
            DeckMenuDisplay.display(Error.FULL_SIDE_DECK);
        } else if (selectedDeck.numOfCardOccurrence(cardName, "both decks") == 3) {
            DeckMenuDisplay.display(Error.NUMBER_LIMITATION_PASSED, cardName, deckName);
        } else {
            selectedDeck.addCardToSideDeck(selectedCard);
            DeckMenuDisplay.display(DeckMessages.SUCCESSFULLY_ADD_CARD_TO_DECK);
        }
    }

    public static void removeCardFromMainDeck(String cardName, String deckName) {
        Deck selectedDeck = LoginUser.getUser().getDeckByName(deckName);
        Card selectedCard = Card.getCardByName(cardName);
        if (selectedDeck == null) {
            DeckMenuDisplay.display(Error.NOT_FOUND_DECK_NAME, deckName);
        } else if (selectedDeck.numOfCardOccurrence(cardName, "main deck") == 0) {
            DeckMenuDisplay.display(Error.NOT_FOUND_CARD_NAME_IN_MAIN_DECK, cardName, deckName);
        } else {
            selectedDeck.removeCardFromMainDeck(selectedCard);
            DeckMenuDisplay.display(DeckMessages.SUCCESSFULLY_REMOVE_CARD_FROM_DECK);
        }
    }

    public static void removeCardFromSideDeck(String cardName, String deckName) {
        Deck selectedDeck = LoginUser.getUser().getDeckByName(deckName);
        Card selectedCard = Card.getCardByName(cardName);
        if (selectedDeck == null) {
            DeckMenuDisplay.display(Error.NOT_FOUND_DECK_NAME, deckName);
        } else if (selectedDeck.numOfCardOccurrence(cardName, "side deck") == 0) {
            DeckMenuDisplay.display(Error.NOT_FOUND_CARD_NAME_IN_SIDE_DECK, cardName, deckName);
        } else {
            selectedDeck.removeCardFromSideDeck(selectedCard);
            DeckMenuDisplay.display(DeckMessages.SUCCESSFULLY_REMOVE_CARD_FROM_DECK);
        }
    }

    public static void invalidCommand() {
        DeckMenuDisplay.display(Error.INVALID_COMMAND);
    }
}
