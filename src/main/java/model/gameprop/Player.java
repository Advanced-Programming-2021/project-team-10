package model.gameprop;

import model.gameprop.BoardProp.PlayerBoard;
import model.userProp.Deck;
import model.userProp.User;

enum Change {
    INCREASE,
    DECREASE
    //TODO Change the name to the better one
}

public class Player {
    int playerLifePoint;
    User user;
    PlayerBoard board;
    Deck deck;

    {
        playerLifePoint = 8000;
    }

    public Player(User user) {
        setUser(user);
        board = new PlayerBoard();
        deck = user.getActiveDeck().getCopy();
        gameSetUp();
    }

    public User getUser() {
        return user;
    }

    private void setUser(User user) {
        this.user = user;
    }

    public int getPlayerLifePoint() {
        return this.playerLifePoint;
    }

    public Deck getDeck() {
        return deck;
    }

    public PlayerBoard getBoard() {
        return board;
    }

    private void changePlayerLifePoint(Change change, int amount) {
        switch (change) {
            case INCREASE: {
                this.playerLifePoint += amount;
                break;
            }
            case DECREASE: {
                this.playerLifePoint -= amount;
                if (this.playerLifePoint < 0)
                    this.playerLifePoint = 0;
                break;
            }
        }
    }

    private void gameSetUp() {
        for (int i = 0; i < 5; i++) {
            board.getPlayerHand().add(deck.getMainDeck().get(i));
        }
        deck.getMainDeck().subList(0, 5).clear();
    }
}
