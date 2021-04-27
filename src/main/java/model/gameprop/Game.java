package model.gameprop;

import model.gameprop.gamestage.GameMainStage;
import model.gameprop.gamestage.GameSideStage;

public class Game {
    private Player currentPlayer;
    private Player opponentPlayer;
    private GameSideStage gameSideStage;
    private GameMainStage gameMainStage;


    {
        gameMainStage = GameMainStage.DRAW_PHASE;
        gameSideStage = GameSideStage.NONE;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getOpponentPlayer() {
        return opponentPlayer;
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

    public void setGameMainStage(GameMainStage gameMainStage) {
        this.gameMainStage = gameMainStage;
    }
}
