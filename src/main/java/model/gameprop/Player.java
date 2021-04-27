package model.gameprop;

import model.cards.cardsProp.Card;
import model.userProp.Deck;
import model.userProp.User;

import java.util.ArrayList;

public class Player {
    int playerLifePoint;
    User user;
    MagicHouse[] magicHouse;
    MonsterHouse[] monsterHouse;
    ArrayList<Card> playerHand;
    Deck deck;
    GraveYard graveYard;

    {
        playerLifePoint = 8000;
        graveYard = new GraveYard();
        magicHouse = new MagicHouse[5];
        monsterHouse = new MonsterHouse[5];
        playerHand = new ArrayList<>();
        deck = user.getActiveDeck().getCopy();
    }

    protected Player(User user) {
        setUser(user);
    }

    public GraveYard getGraveYard() {
        return graveYard;
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

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public Deck getDeck() {
        return deck;
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
}
