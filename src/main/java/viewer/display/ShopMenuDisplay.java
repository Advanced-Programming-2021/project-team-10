package viewer.display;

import controller.enums.Error;
import controller.enums.MenusMassages.ShopMessages;
import model.cards.cardsProp.Card;

public class ShopMenuDisplay {
    public static void display(Enum message) {
        if (message instanceof ShopMessages) {
            System.out.println(((ShopMessages) message).getMessage());
        }
        else if (message instanceof Error) {
            System.out.println(((Error) message).getMassage());
        }
        else {
            System.out.println("invalid enum type");
        }
    }

    public static void display(Enum message, String field) {
        if (message instanceof ShopMessages) {
            System.out.printf(((ShopMessages) message).getMessage(), field);
            System.out.println();
        } else if (message instanceof Error) {
            System.out.printf(((Error) message).getMassage(), field);
            System.out.println();
        } else {
            System.out.println("invalid type of enum");
        }
    }

    public static void printAllCards(Card[] cards) {
        for (Card card : cards) {
            System.out.println(card.getName() + ": " + card.getPrice());
        }
    }

}
