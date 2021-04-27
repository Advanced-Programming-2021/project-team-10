package model.gameprop;

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
}
