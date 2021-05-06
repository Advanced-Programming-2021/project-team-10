package model.gameprop.BoardProp;

import model.cards.cardsProp.Card;

import java.util.ArrayList;

public class GraveYard {
    ArrayList<Card> destroyedCards;

    {
        destroyedCards = new ArrayList<>();
    }

    public ArrayList<Card> getDestroyedCards() {
        return destroyedCards;
    }

    public void addCardToGraveYard(Card card) {
        destroyedCards.add(card);
    }
}
