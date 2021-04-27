package model.userProp;

import model.cards.cardsProp.Card;

import java.util.ArrayList;

public class Deck {
    private String name;
    private User owner;
    private ArrayList<Card> mainDeck;
    private ArrayList<Card> sideDeck;
    private boolean isDeckActivated;


    {
        mainDeck = new ArrayList<>();
        sideDeck = new ArrayList<>();
        isDeckActivated = false;
    }

    public Deck(String name, User owner) {
        setName(name);
        setOwner(owner);
        // adding to users decks
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getMainDeck() {
        return mainDeck;
    }

    public Deck getCopy(){
        Deck copy = new Deck(this.name, this.owner);
        copy.isDeckActivated = this.isDeckActivated;

        for (Card card : this.mainDeck) {
            copy.mainDeck.add(card.getCopy());
        }

        for (Card card : this.sideDeck) {
            copy.sideDeck.add(card.getCopy());
        }

        return copy;
    }
}
