package controller;

import controller.enums.PlayerEnum;
import model.cards.cardsProp.Card;
import model.gameprop.Game;
import model.gameprop.GraveYard;
import model.gameprop.Player;
import viewer.GamePlayDisplay;

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
        Player opponentPlayer = game.getOpponentPlayer();
        Player currentPlayer = game.getCurrentPlayer();
        mapDisplay.append(opponentPlayer.getUser().getNickname()).append(" : ").
                append(opponentPlayer.getPlayerLifePoint()).append("\n\t");

        for (Card ignored : opponentPlayer.getPlayerHand()) {
            mapDisplay.append("\tc");
        }
        mapDisplay.append("\n").append(opponentPlayer.
                getDeck().getCardsOfDeck().size()).append("\n");
        int[] cardOrientation = {4, 2, 1, 3, 5};
        for (int i : cardOrientation) {

        }
    }

    public void showGraveYard(PlayerEnum currentPlayer) {
        StringBuilder graveYardDisplay = new StringBuilder();
        GraveYard graveYard;
        if (currentPlayer == PlayerEnum.FRIEND) {
            graveYard = game.getCurrentPlayer().getGraveYard();
        } else {
            graveYard = game.getOpponentPlayer().getGraveYard();
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
