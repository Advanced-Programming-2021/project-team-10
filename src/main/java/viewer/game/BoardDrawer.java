package viewer.game;

import model.cards.cardsProp.Card;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.GameHouse;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.gamemodel.Game;
import model.gameprop.Player;

public class BoardDrawer {

    Game game;
    public BoardDrawer(Game game){
        this.game = game;
    }

    public String drawBoard() {
        StringBuilder mapDisplay = new StringBuilder();
        Player opponentPlayer = game.getPlayer(SideOfFeature.OPPONENT);
        Player currentPlayer = game.getPlayer(SideOfFeature.CURRENT);
        drawOpponentPlayerBoard(mapDisplay, opponentPlayer);
        mapDisplay.append("\n--------------------------");
        drawCurrentPlayerBoard(mapDisplay, currentPlayer);
        return mapDisplay.toString();
    }

    private void drawOpponentPlayerBoard(StringBuilder mapDisplay, Player opponentPlayer) {
        mapDisplay.append(opponentPlayer.getUser().getNickname()).append(" : ").
                append(opponentPlayer.getPlayerLifePoint()).append("\n");

        PlayerBoard board = opponentPlayer.getBoard();
        for (Card ignored : board.getPlayerHand()) {
            mapDisplay.append("\tc");
        }
        mapDisplay.append("\n").append(opponentPlayer.
                getDeck().getMainDeck().size()).append("\n");

        MagicHouse[] magicHouses = board.getMagicHouse();
        MonsterHouse[] monsterHouses = board.getMonsterHouse();

        int[] houseOrientation = {4, 2, 1, 3, 5};
        displayGameHouses(mapDisplay, magicHouses, houseOrientation);
        mapDisplay.append("\n");
        displayGameHouses(mapDisplay, monsterHouses, houseOrientation);

        mapDisplay.append("\n\n").append(board.getGraveYard().getDestroyedCards().size()).
                append("\t\t\t\t\t").
                append(board.getFieldHouse().getState());
    }

    private void drawCurrentPlayerBoard(StringBuilder mapDisplay, Player currentPlayer) {
        MagicHouse[] magicHouses = currentPlayer.getBoard().getMagicHouse();
        MonsterHouse[] monsterHouses = currentPlayer.getBoard().getMonsterHouse();
        PlayerBoard board = currentPlayer.getBoard();
        mapDisplay.append("\n").append(board.getGraveYard().getDestroyedCards().size()).
                append("\t\t\t\t\t").
                append(board.getFieldHouse().getState()).append("\n\n");

        int[] cardOrientation = {5, 3, 1, 2, 4};
        displayGameHouses(mapDisplay, monsterHouses, cardOrientation);
        mapDisplay.append("\n");
        displayGameHouses(mapDisplay, magicHouses, cardOrientation);

        mapDisplay.append("\n");
        mapDisplay.append("\n").append(currentPlayer.
                getDeck().getMainDeck().size()).append("\n");


        for (Card ignored : currentPlayer.getBoard().getPlayerHand()) {
            mapDisplay.append("\tc");
        }
        mapDisplay.append("\n").append(currentPlayer.getUser().getNickname()).append(" : ").
                append(currentPlayer.getPlayerLifePoint());
    }

    private void displayGameHouses(StringBuilder mapDisplay, GameHouse[] house, int[] orientation) {
        for (int i : orientation) {
            mapDisplay.append("\t").append(house[i - 1].getState());
        }
    }
}
