package viewer.game;

import controller.enums.GameEnums.SideOfFeature;
import model.cards.cardsProp.Card;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.Game;
import model.gameprop.Player;

public class BoardDrawer {
    public static void drawBoard(Game game) {
            StringBuilder mapDisplay = new StringBuilder();
            Player opponentPlayer = game.getPlayer(SideOfFeature.OPPONENT);
            Player currentPlayer = game.getPlayer(SideOfFeature.CURRENT);
            drawOpponentPlayerBoard(mapDisplay, opponentPlayer);
            mapDisplay.append("\n\n--------------------------");
            drawCurrentPlayerBoard(mapDisplay, currentPlayer);
    }

    private static  void drawOpponentPlayerBoard(StringBuilder mapDisplay, Player opponentPlayer) {
        mapDisplay.append(opponentPlayer.getUser().getNickname()).append(" : ").
                append(opponentPlayer.getPlayerLifePoint()).append("\n\t");

        for (Card ignored : opponentPlayer.getBoard().getPlayerHand()) {
            mapDisplay.append("\tc");
        }
        mapDisplay.append("\n").append(opponentPlayer.
                getDeck().getMainDeck().size()).append("\n");
        int[] cardOrientation = {4, 2, 1, 3, 5};
        MagicHouse[] magicHouses = opponentPlayer.getBoard().getMagicHouse();
        MonsterHouse[] monsterHouses = opponentPlayer.getBoard().getMonsterHouse();
        for (int i : cardOrientation) {
            mapDisplay.append("\t").append(magicHouses[i].getState().stateToString());
        }
        mapDisplay.append("\n");
        for (int i : cardOrientation) {
            mapDisplay.append("\t").append(monsterHouses[i].getState().stateToString());
        }
        mapDisplay.append("\n").append(opponentPlayer.getBoard().getGraveYard().getDestroyedCards().size()).
                append("\t\t\t\t\t").
                append(magicHouses[6]);
    }

    private static void drawCurrentPlayerBoard(StringBuilder mapDisplay, Player currentPlayer) {
        MagicHouse[] magicHouses = currentPlayer.getBoard().getMagicHouse();
        MonsterHouse[] monsterHouses = currentPlayer.getBoard().getMonsterHouse();

        mapDisplay.append("\n").append(currentPlayer.getBoard().getGraveYard().getDestroyedCards().size()).
                append("\t\t\t\t\t").
                append(magicHouses[6]).append("\n");
        int[] cardOrientation = {5, 3, 1, 2, 4};
        for (int i : cardOrientation) {
            mapDisplay.append("\t").append(monsterHouses[i].getState().stateToString());
        }
        mapDisplay.append("\n");
        for (int i : cardOrientation) {
            mapDisplay.append("\t").append(magicHouses[i].getState().stateToString());
        }
        mapDisplay.append("\n");
        mapDisplay.append("\n").append(currentPlayer.
                getDeck().getMainDeck().size()).append("\n");

        mapDisplay.append("\n");
        for (Card ignored : currentPlayer.getBoard().getPlayerHand()) {
            mapDisplay.append("\tc");
        }
        mapDisplay.append("\n");
        mapDisplay.append(currentPlayer.getUser().getNickname()).append(" : ").
                append(currentPlayer.getPlayerLifePoint());
        //TODO debug map drawer later
    }
}
