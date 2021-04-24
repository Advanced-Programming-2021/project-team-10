package Model;

import java.util.ArrayList;
import java.util.List;

public class Card {
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

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", price=" + price +
                ", description='" + description + '\'';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
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

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

}
