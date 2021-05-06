package model.cards.cardsEffect.magicEffectChildren;

import controller.ImportScanner;
import controller.enums.GameEnums.SideOfFeature;
import model.cards.cardsEffect.EffectOfMagic;
import model.cards.cardsProp.Card;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;
import model.gameprop.cardvisibility.MonsterHouseVisibilityState;
import model.userProp.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MindCrushEffect extends EffectOfMagic {
    private static MindCrushEffect instance;

    {
        eventsActivateEffect = new ArrayList<>();
    }

    public static MindCrushEffect getInstance() {
        if (instance == null) {
            instance = new MindCrushEffect();
        }
        return instance;
    }

    @Override
    public void active() {
        System.out.println("declare a card name:");
        String name = ImportScanner.getInput();
        boolean isCardInOpponentHand = false;
        PlayerBoard opponentBoard = GameInProcess.getGame().getPlayer(SideOfFeature.OPPONENT).getBoard();
        for (Card card : opponentBoard.getPlayerHand()) {
            if (name.equals(card.getName())) {
                isCardInOpponentHand = true;
                break;
            }
        }
        if (isCardInOpponentHand) {
            Deck deck = GameInProcess.getGame().getPlayer(SideOfFeature.OPPONENT).getDeck();
            ArrayList<Card> mainDeck = deck.getMainDeck();
            Iterator<Card> mainDeckIterator = mainDeck.iterator();
            while (mainDeckIterator.hasNext()) {
                Card card = mainDeckIterator.next();
                if (card.getName().equals(name)) {
                    opponentBoard.getGraveYard().addCardToGraveYard(card);
                    mainDeckIterator.remove();
                }
            }
            ArrayList<Card> opponentHand = opponentBoard.getPlayerHand();
            Iterator<Card> handIterator = opponentHand.iterator();
            while (handIterator.hasNext()) {
                Card card = handIterator.next();
                if (card.getName().equals(name)) {
                    opponentBoard.getGraveYard().addCardToGraveYard(card);
                    handIterator.remove();
                }
            }
            MonsterHouse[] opponentMonsterHouse = opponentBoard.getMonsterHouse();
            for (MonsterHouse monsterHouse : opponentMonsterHouse) {
                if (monsterHouse.getMonsterCard().getName().equals(name)) {
                    opponentBoard.getGraveYard().addCardToGraveYard(monsterHouse.getMonsterCard());
                    monsterHouse.setMonsterCard(null);
                    monsterHouse.setState(MonsterHouseVisibilityState.EMPTY);
                }
            }
        }
        else {
            PlayerBoard currentPlayerBoard = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT).getBoard();
            ArrayList<Card> hand = currentPlayerBoard.getPlayerHand();
            Collections.shuffle(hand);
            Card card = hand.get(0);
            currentPlayerBoard.getGraveYard().addCardToGraveYard(card);
            hand.remove(0);
        }
    }
}
