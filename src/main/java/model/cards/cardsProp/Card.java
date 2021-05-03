package model.cards.cardsProp;

import java.util.ArrayList;
import java.util.List;

public abstract class Card {
    protected static List<Card> cards;

    static {
        cards = new ArrayList<>();
    }

    protected String name;
    protected String number; // on card's picture
    protected int price;
    protected String description;

    public Card(String name, String description, String price) {
        setName(name);
        setDescription(description);
        setPrice(price);
        cards.add(this);
    }

    public Card() {
    }

    public static Card getCardByName(String name) {
        for (Card card : cards) {
            if (card.name.equals(name)) {
                return card;
            }
        }
        return null; // No such CArd exists.
    }

    public static int getCardPriceByName(String name) {
        for (Card card : cards) {
            if (card.name.equals(name)) {
                return card.price;
            }
        }
        return -1; // No such card exists.
    }

    public static String getDescriptionByName(String name) {
        for (Card card : cards) {
            if (card.name.equals(name)) {
                return card.description;
            }
        }
        return null; // No such card exists.
    }

    public static List<Card> getCards() {
        return cards;
    }

    public abstract String getCardDetail();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract Card getCopy(); // semi duplicate code in overrides; cause -> Card is abstract and not constructable!
}
