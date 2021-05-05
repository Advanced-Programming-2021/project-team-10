package model.gameprop.BoardProp;

import model.cards.cardsProp.Card;

import java.util.ArrayList;

public class PlayerBoard {
    MagicHouse[] magicHouse;
    MonsterHouse[] monsterHouse;
    ArrayList<Card> playerHand;
    GraveYard graveYard;

    {
        magicHouse = new MagicHouse[6];
        monsterHouse = new MonsterHouse[5];
        playerHand = new ArrayList<>();
        graveYard = new GraveYard();
    }

    public MagicHouse[] getMagicHouse() {
        return magicHouse;
    }

    public MonsterHouse[] getMonsterHouse() {
        return monsterHouse;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public GraveYard getGraveYard() {
        return graveYard;
    }
}
