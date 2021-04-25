package model.gameProp;

import model.cards.cardsProp.Card;
import model.userProp.Deck_Demo;
import model.userProp.User;

import java.util.ArrayList;

public class Player {
    User user;
    MagicHouse[] magicHouse;
    MonsterHouse[] monsterHouse;
    ArrayList<Card> playerHand;
    Deck_Demo deck_demo;
    GraveYard graveYard;

    {
        graveYard = new GraveYard();
        magicHouse = new MagicHouse[5];
        monsterHouse = new MonsterHouse[5];
        playerHand = new ArrayList<>();
        deck_demo = user.getActiveDeck().getCopy();
    }

    protected Player(User user) {
        setUser(user);
    }

    private void setUser(User user) {
        this.user = user;
    }
}
