package controller.gamecontrollers.phaseControllers;

import controller.enums.GameEnums.SideOfFeature;
import model.cards.cardsProp.Card;
import model.gameprop.Game;
import model.gameprop.GameInProcess;
import model.gameprop.Player;

import java.util.ArrayList;

public class DrawPhaseController {
    public void run() {
        Game game = GameInProcess.getGame();
        Player player = game.getPlayer(SideOfFeature.CURRENT);
        ArrayList<Card> hand = player.getBoard().getPlayerHand();
        if (hand.size() >= 6) {

        } else {

        }
    }
}
