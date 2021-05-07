package controller.gamecontrollers.phaseControllers;

import model.enums.GameEnums.GamePhaseEnums.DrawPhaseMessage;
import model.enums.GameEnums.SideOfFeature;
import controller.gamecontrollers.GeneralCommands;
import model.cards.cardsProp.Card;
import model.gameprop.Game;
import model.gameprop.GameInProcess;
import model.gameprop.Player;
import model.userProp.Deck;
import viewer.game.GameDisplay;

import java.util.ArrayList;

public class DrawPhaseController extends GeneralCommands {
    public void draw() {
        Game game = GameInProcess.getGame();
        Player player = game.getPlayer(SideOfFeature.CURRENT);
        ArrayList<Card> hand = player.getBoard().getPlayerHand();
        if (hand.size() < 6) {
            Deck playerDeck = player.getDeck();
            Card newCard = playerDeck.getMainDeck().get(0);
            playerDeck.removeCardFromMainDeck(newCard);
            GameDisplay.display(DrawPhaseMessage.ADD_NEW_CARD, newCard.getName());
        }
    }

    public void run(String command) {
        if (command.startsWith("select")){
           // selectCard(command);
        }
    }
}
