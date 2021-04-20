package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Card {
    protected static List<Card> allCards;

    static {
        allCards = new ArrayList<>();
    }

    protected String name;
    protected String number;
    protected int price;
    protected String description;

    {
        name = null;
        number = null;
        description = null;
        allCards = null;
    }

    public static Card getCardByName(String name) {
        for (Card card : allCards) {
            if (card.name.equals(name)) {
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
