package Model;

import java.util.List;

public abstract class Card {
    protected String name = null;
    protected String number = null;
    protected int price;
    protected String description = null;
    protected static List<Card> allCards = null;

    public static Card getCardByName(String name){
        for (Card card : allCards) {
            if(card.name.equals(name)) {
                return card;
            }
        }
        return null; // No such CArd exists.
    }

    public static int getCardPriceByName(String name) {
        for (Card card : allCards) {
            if (card.name.equals(name)) {
                return card.price;
            }
        }
        return -1; // No such card exists.
    }

    public static String getDescriptionByName(String name) {
        for (Card card : allCards) {
            if (card.name.equals(name)) {
                return card.description;
            }
        }
        return null; // No such card exists.
    }

    public String getName() {
        return name;
    }
}
