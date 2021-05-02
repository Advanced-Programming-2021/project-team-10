package model.userProp;

import model.cards.cardsProp.Card;

import java.util.ArrayList;

public class Deck {
    private boolean isValid;
    private String name;
    private User owner;
    private ArrayList<Card> mainDeck;
    private ArrayList<Card> sideDeck;
    private boolean isDeckActivated;


    {
        mainDeck = new ArrayList<>();
        sideDeck = new ArrayList<>();
        isDeckActivated = false;
        isValid = false;
    }

    public Deck(String name, User owner) {
        setName(name);
        setOwner(owner);
        owner.getAllDecks().add(this);
    }


    public boolean getIsActivated() {
        return this.isDeckActivated;
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

    public ArrayList<Card> getSideDeck() {
        return sideDeck;
    }

    public String getValidity() {
        if (isValid) {
            return "valid";
        }
        return "invalid";
    }

    public Deck getCopy(){ // Somehow "Prototype pattern" is implemented
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

    public void setDeckActivated(boolean deckActivated) {
        this.isDeckActivated = deckActivated;
    }

    public String getName() {
        return name;
    }

    public void removeCardFromMainDeck(Card card) {
        this.mainDeck.remove(card);
    }

    public void removeCardFromSideDeck(Card card) {
        this.sideDeck.remove(card);
    }

    public void addCardToMainDeck(Card card) {
        this.mainDeck.add(card);
    }

    public void addCardToSideDeck(Card card) {
        this.sideDeck.add(card);
    }

    public void deleteDeckFromOwner() {
        this.owner.getAllDecks().remove(this);
        if (isDeckActivated) {
            this.owner.setActiveDeck(null);
        }
    }

    public int numOfCardOccurrence(String cardName, String where) {
        int mainDeckCounter = 0;
        int sideDeckCounter = 0;
        if (where.equals("main deck") || where.equals("both decks")) {
            for (Card card : mainDeck) { // mainDeck count:
                if (card.getName().equals(cardName)) {
                    mainDeckCounter++;
                }
            }
        }

        if (where.equals("side deck") || where.equals("both decks")) {
            for (Card card : sideDeck) { // sideDeck count:
                if (card.getName().equals(cardName)) {
                    sideDeckCounter++;
                }
            }
        }

        return mainDeckCounter + sideDeckCounter; // in "single deck" situations, one of the counters would automatically be zero.
    }


}
