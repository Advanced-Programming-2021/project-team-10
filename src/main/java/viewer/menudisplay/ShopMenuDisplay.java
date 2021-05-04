package viewer.menudisplay;

import controller.enums.Error;
import controller.enums.MenusMassages.ShopMessages;
import model.cards.cardsProp.Card;

public class ShopMenuDisplay {
    public static void display(ShopMessages message) {
            System.out.println(message.getMessage());
    }

    public static void display(Error message) {
            System.out.println(message.getMassage());
    }

    public static void display(ShopMessages message, String field) {
            System.out.printf(message.getMessage(), field);
            System.out.println();
    }

    public static void display(Error message, String field) {
            System.out.printf(message.getMassage(), field);
            System.out.println();
    }

    public static void printCardDetail(Card card){
        System.out.println( card.getCardDetail());
    }

    public static void printAllCards(Card[] cards) {
        for (Card card : cards) {
            System.out.println(card.getName() + ": " + card.getPrice());
        }
    }

}
