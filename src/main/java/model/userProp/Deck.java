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
        owner.getAllDecks().add(this);
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
        this.owner.setActiveDeck(this);
    }

    public String getName() {
        return name;
    }

    public void deleteCardFromMainDeck(Card card) {
        this.mainDeck.remove(card);
    }

    public void deleteCardFromSideDeck(Card card) {
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
    }
}
