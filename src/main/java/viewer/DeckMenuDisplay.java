package viewer;

import controller.enums.Error;
import controller.enums.MenusMassages.DeckMessages;
import model.userProp.Deck;
import model.userProp.LoginUser;
import model.userProp.User;

public class DeckMenuDisplay {

    public static void showAllDecks() {
        User user = LoginUser.getUser();
        System.out.println("Decks:");
        System.out.println("Active deck:");
        if (user.getActiveDeck() != null) {
            Deck active = user.getActiveDeck();
            System.out.println(active.getName() + ": main deck " + active.getMainDeck().size() + ", side deck " + active.getSideDeck().size() + ", " + active.getValidity());
        }
        System.out.println("Other decks:");
        if (user.getAllDecks().size() > 0) {
            for (Deck deck : user.getAllDecks()) {
                String name = deck.getName();
                int numMainDeck = deck.getMainDeck().size();
                int numSideDeck = deck.getSideDeck().size();
                String validity = deck.getValidity();
                System.out.println(name + ": main deck " + numMainDeck + ", side deck " + numSideDeck + ", " + validity);
            }
        }
    }
    public static void display(Enum message) {
        if (message instanceof DeckMessages) {
            System.out.println(((DeckMessages) message).getMessage());
        }
        else if (message instanceof Error) {
            System.out.println(((Error) message).getMassage());
        }
        else {
            System.out.println("invalid enum type");
        }
    }

    public static void display(Enum message, String field) {
        if (message instanceof DeckMessages) {
            System.out.printf(((DeckMessages) message).getMessage(), field);
            System.out.println();
        } else if (message instanceof Error) {
            System.out.printf(((Error) message).getMassage(), field);
            System.out.println();
        } else {
            System.out.println("invalid type of enum");
        }
    }

    public static void display(Enum message, String field1, String field2) {
        if (message instanceof DeckMessages) {
            System.out.printf(((DeckMessages) message).getMessage(), field1, field2);
            System.out.println();
        } else if (message instanceof Error) {
            System.out.printf(((Error) message).getMassage(), field1, field2);
            System.out.println();
        } else {
            System.out.println("invalid type of enum");
        }
    }
}
