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
    public int playerLifePoint;
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

    public void changePlayerLifePoint(int amount) {
        playerLifePoint -= amount;
        if (playerLifePoint < 0)
            playerLifePoint = 0;
    }

    private void gameSetUp() {
        //Collections.shuffle(deck.getMainDeck());
        //Collections.shuffle(deck.getSideDeck());

        for (int i = 0; i < 5; i++) {
            board.getPlayerHand().add(deck.getMainDeck().get(i));
        }
        deck.getMainDeck().subList(0, 5).clear();
    }
}
