package controller;

import controller.enums.PlayerEnum;
import model.cards.cardsProp.Card;
import model.gameprop.Game;
import model.gameprop.GraveYard;
import model.gameprop.Player;
import viewer.display.GamePlayDisplay;

public class GamePlayGeneralController {

    private final Game game;
    private final GamePlayDisplay gamePlayDisplay;

    {
        gamePlayDisplay = new GamePlayDisplay();
    }


    public GamePlayGeneralController(Game game) {
        this.game = game;
    }

    public void showGameBoard() {
        StringBuilder mapDisplay = new StringBuilder();
        Player opponentPlayer = game.getSecondPlayer();
        Player currentPlayer = game.getFirstPlayer();
        drawOpponentPlayerBoard(mapDisplay, opponentPlayer);
        mapDisplay.append("\n\n--------------------------");
        drawCurrentPlayerBoard(mapDisplay, currentPlayer);
    }

    private void drawOpponentPlayerBoard(StringBuilder mapDisplay, Player opponentPlayer) {
        mapDisplay.append(opponentPlayer.getUser().getNickname()).append(" : ").
                append(opponentPlayer.getPlayerLifePoint()).append("\n\t");

        for (Card ignored : opponentPlayer.getPlayerHand()) {
            mapDisplay.append("\tc");
        }
        mapDisplay.append("\n").append(opponentPlayer.
                getDeck().getMainDeck().size()).append("\n");
        int[] cardOrientation = {4, 2, 1, 3, 5};
        for (int i : cardOrientation) {
            mapDisplay.append("\t").append(opponentPlayer.getMagicHouse(i).getState().stateToString());
        }
        mapDisplay.append("\n");
        for (int i : cardOrientation) {
            mapDisplay.append("\t").append(opponentPlayer.getMonsterHouse(i).getState().stateToString());
        }
        mapDisplay.append("\n").append(opponentPlayer.getGraveYard().getDestroyedCards().size()).
                append("\t\t\t\t\t").
                append(opponentPlayer.getMagicHouse(6));
    }

    private void drawCurrentPlayerBoard(StringBuilder mapDisplay, Player currentPlayer) {
        mapDisplay.append("\n").append(currentPlayer.getGraveYard().getDestroyedCards().size()).
                append("\t\t\t\t\t").
                append(currentPlayer.getMagicHouse(6)).append("\n");
        int[] cardOrientation = {5, 3, 1, 2, 4};
        for (int i : cardOrientation) {
            mapDisplay.append("\t").append(currentPlayer.getMonsterHouse(i).getState().stateToString());
        }
        mapDisplay.append("\n");
        for (int i : cardOrientation) {
            mapDisplay.append("\t").append(currentPlayer.getMagicHouse(i).getState().stateToString());
        }
        mapDisplay.append("\n");
        mapDisplay.append("\n").append(currentPlayer.
                getDeck().getMainDeck().size()).append("\n");

        mapDisplay.append("\n");
        for (Card ignored : currentPlayer.getPlayerHand()) {
            mapDisplay.append("\tc");
        }
        mapDisplay.append("\n");
        mapDisplay.append(currentPlayer.getUser().getNickname()).append(" : ").
                append(currentPlayer.getPlayerLifePoint());
        //TODO debug map drawer later
    }

    public void showGraveYard(PlayerEnum currentPlayer) {
        StringBuilder graveYardDisplay = new StringBuilder();
        GraveYard graveYard;
        if (currentPlayer == PlayerEnum.FRIEND) {
            graveYard = game.getFirstPlayer().getGraveYard();
        } else {
            graveYard = game.getSecondPlayer().getGraveYard();
        }

        if (graveYard.getDestroyedCards().size() == 0) {
            graveYardDisplay.append("graveyard empty");
        } else {
            for (Card destroyedCard : graveYard.getDestroyedCards()) {
                graveYardDisplay.append(destroyedCard.getName()).append(":").
                        append(destroyedCard.getDescription()).append("\n");
            }
            graveYardDisplay.deleteCharAt(graveYardDisplay.length() - 1);
        }

        gamePlayDisplay.displayInfo(graveYardDisplay.toString());
    }
}
