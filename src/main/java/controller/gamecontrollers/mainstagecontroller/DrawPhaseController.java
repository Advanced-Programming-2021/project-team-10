package controller.gamecontrollers.mainstagecontroller;

import com.sanityinc.jargs.CmdLineParser;
import model.enums.GameEnums.GamePhaseEnums.DrawPhaseMessage;
import model.enums.GameEnums.SideOfFeature;
import controller.gamecontrollers.GeneralController;
import model.cards.cardsProp.Card;
import model.gameprop.Game;
import model.gameprop.GameInProcess;
import model.gameprop.Player;
import model.userProp.Deck;
import viewer.game.GameDisplay;

import java.util.ArrayList;

public class DrawPhaseController extends GeneralController {
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

    public void run(String command) throws CmdLineParser.OptionException {
        if (command.startsWith("select -d")){
           deSelectCard();
           // d selecting card
        }else if(command.startsWith("show graveyard")){
            showGraveYard(command);
            // show grave yard (current / opponent)
        }else if(command.startsWith("select")){
            selectCard(command);
            // select a card from (monster / spell / hand )
        }else if (command.startsWith("card show")){
            showSelectedCard();
            // show card detail
        }else if(command.equals("surrender")){
            surrender();
        }
    }
}
