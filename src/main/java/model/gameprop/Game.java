package model.gameprop;

import model.gameprop.gamestage.GameMainStage;
import model.gameprop.gamestage.GameSideStage;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;
    private GameSideStage gameSideStage;
    private GameMainStage gameMainStage;

    {
        gameMainStage = GameMainStage.DRAW_PHASE;
        gameSideStage = GameSideStage.NONE;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Game() {
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public GameMainStage getGameMainStage() {
        return gameMainStage;
    }

    public void setGameMainStage(GameMainStage gameMainStage) {
        this.gameMainStage = gameMainStage;
    }

    public GameSideStage getGameSideStage() {
        return gameSideStage;
    }

    public void setGameSideStage(GameSideStage gameSideStage) {
        this.gameSideStage = gameSideStage;
    }
}
