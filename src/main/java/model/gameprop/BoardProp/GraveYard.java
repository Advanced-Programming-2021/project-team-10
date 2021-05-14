package model.gameprop.BoardProp;

import model.cards.cardsProp.Card;
import model.cards.cardsProp.MonsterCard;

import java.awt.*;
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

    public void removeCardFromGraveYard(Card card) {
        destroyedCards.remove(card);
    }

    public MonsterCard getMonsterCardFromGraveyardByName(String name) {
        for (Card destroyedCard : destroyedCards) {
            if (destroyedCard.getName().equals(name)) {
                if (destroyedCard instanceof MonsterCard) {
                    return (MonsterCard) destroyedCard;
                }
            }
        }
        return null;
    }
}
