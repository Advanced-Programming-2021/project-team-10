package model.gameprop;

import controller.enums.GameEnums.PlayerTurn;
import controller.enums.GameEnums.SideOfFeature;
import model.cards.cardsProp.Card;
import model.gameprop.gamestage.GameMainStage;
import model.gameprop.gamestage.GameSideStage;

public class Game {
    private SelectedCardProp cardProp;
    private SideOfFeature sideOfSelectedCard;
    private PlayerTurn turn;
    private Player firstPlayer;
    private Player secondPlayer;
    private GameSideStage gameSideStage;
    private GameMainStage gameMainStage;

    {
        sideOfSelectedCard = null;
        turn = PlayerTurn.PLAYER_ONE;
        gameMainStage = GameMainStage.DRAW_PHASE;
        gameSideStage = GameSideStage.NONE;
    }


    public Game() {
    }

    public Player getPlayer(SideOfFeature turn) {
        switch (turn) {
            case CURRENT: {
                if (this.turn.equals(PlayerTurn.PLAYER_ONE)) {
                    return firstPlayer;
                } else {
                    return secondPlayer;
                }
            }
            case OPPONENT: {
                if (this.turn.equals(PlayerTurn.PLAYER_ONE)) {
                    return secondPlayer;
                } else
                    return firstPlayer;
            }
            default:
                return null;
        }
    }

    public SideOfFeature getSideOfSelectedCard() {
        return sideOfSelectedCard;
    }

    public void changeTurn() {
        if (turn.equals(PlayerTurn.PLAYER_ONE)) {
            turn = PlayerTurn.PLAYER_TWO;
        } else {
            turn = PlayerTurn.PLAYER_ONE;
        }
    }


    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
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

    public SelectedCardProp getCardProp() {
        return cardProp;
    }

    public void setCardProp(SelectedCardProp cardProp) {
        this.cardProp = cardProp;
    }
}
