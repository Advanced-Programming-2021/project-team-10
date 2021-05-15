package model.gameprop.gamemodel;

import model.cards.cardsProp.Card;
import model.enums.GameEnums.PlayerTurn;
import model.enums.GameEnums.SideOfFeature;
import model.enums.GameEnums.TypeOfHire;
import model.enums.GameEnums.gamestage.GameMainStage;
import model.enums.GameEnums.gamestage.GameSideStage;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.GameInProcess;
import model.gameprop.Player;
import model.gameprop.SelectedCardProp;
import model.gameprop.turnBasedObserver.TurnObserver;
import model.userProp.Deck;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private boolean isGameFinished;
    private PlayerTurn turnOfGame;
    private Player firstPlayer;
    private Player secondPlayer;
    private Player winner;
    private Turn turn;
    private GameSideStage gameSideStage;
    private GameMainStage gameMainStage;

    {
        isGameFinished = false;
        turnOfGame = PlayerTurn.PLAYER_ONE;
        gameMainStage = GameMainStage.DRAW_PHASE;
        gameSideStage = GameSideStage.START_STAGE;
    }

    public Game(Player firstPlayer, Player secondPlayer) {
        setFirstPlayer(firstPlayer);
        setSecondPlayer(secondPlayer);
        turn = new Turn(firstPlayer);
    }

    public boolean isPlayerDrawInThisTurn() {
        return turn.isCardDraw();
    }

    public void setPlayerDrawInTurn() {
        turn.setCardDraw();
    }

    public Player getPlayer(SideOfFeature turn) {
        switch (turn) {
            case CURRENT: {
                if (this.turnOfGame.equals(PlayerTurn.PLAYER_ONE)) {
                    return firstPlayer;
                } else {
                    return secondPlayer;
                }
            }
            case OPPONENT: {
                if (this.turnOfGame.equals(PlayerTurn.PLAYER_ONE)) {
                    return secondPlayer;
                } else
                    return firstPlayer;
            }
            default:
                return null;
        }
    }

    public MonsterHouse getHiredMonster() {
        return turn.getMonsterHouseOfHiredMonster();
    }

    public void setHiredMonster(MonsterHouse monsterHouse) {
        turn.setMonsterHouseOfHiredMonster(monsterHouse);
    }

    public void changeTurn() {
        if (turnOfGame.equals(PlayerTurn.PLAYER_ONE)) {
            turnOfGame = PlayerTurn.PLAYER_TWO;
        } else {
            turnOfGame = PlayerTurn.PLAYER_ONE;
        }
    }


    private void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    private void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public GameMainStage getGameMainStage() {
        return gameMainStage;
    }

    public GameSideStage getGameSideStage() {
        return gameSideStage;
    }

    public void setGameSideStage(GameSideStage gameSideStage) {
        this.gameSideStage = gameSideStage;
    }

    public SelectedCardProp getCardProp() {
        return turn.getSelectedCardProp();
    }

    public void setCardProp(SelectedCardProp cardProp) {
        turn.selectedCardProp = cardProp;
    }

    public void goToNextPhase() {
        gameMainStage = GameMainStage.getNextPhase(gameMainStage.getPhaseNumber());
        if (gameMainStage.equals(GameMainStage.DRAW_PHASE))
            resetLastTurnData();
    }

    public PlayerTurn getTurnOfGame() {
        return turnOfGame;
    }

    public boolean isGameFinished() {
        return isGameFinished;
    }

    public void finishGame(PlayerTurn looserTurn) {
        Player looser = null;
        switch (looserTurn) {
            case PLAYER_ONE: {
                winner = secondPlayer;
                looser = firstPlayer;
                break;
            }
            case PLAYER_TWO:
                winner = firstPlayer;
                looser = secondPlayer;
        }
        assert winner != null;
        winner.getUser().changeBalance(100);
        assert looser != null;
        looser.getUser().increaseScore(1000);
        secondPlayer.getUser().changeBalance(1000 + secondPlayer.playerLifePoint);
        isGameFinished = true;
    }

    public Player getWinner() {
        return winner;
    }

    public int getTributeNumber() {
        return turn.getTributeNumber();
    }

    private void resetLastTurnData() {
        changeTurn();

        ArrayList<TurnObserver> turnObservers = TurnObserver.getTurnObservers();
        if (turnObservers != null) {
            for (TurnObserver turnObserver : turnObservers) {
                turnObserver.update();
            }
        }

        turn = new Turn(getPlayer(SideOfFeature.CURRENT));
    }

    public void setTributeSize(int numberOfCard) {
        turn.setTributeNumber(numberOfCard);
    }

    public TypeOfHire getTypeOfMonsterHire() {
        return turn.getTypeOfHighLevelMonsterHire();
    }

    public void setTypeOfMonsterHire(TypeOfHire typeOfMonsterHire) {
            turn.setTypeOfHighLevelMonsterHire(typeOfMonsterHire);
    }

    public void moveCardFromHandToDeck (Card card) {
        Player player = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT);
        Deck deck = player.getDeck();
        ArrayList<Card> hand = player.getBoard().getPlayerHand();

        deck.removeCardFromMainDeck(card);
        hand.add(card);

        Collections.shuffle(deck.getMainDeck());
    }
}
