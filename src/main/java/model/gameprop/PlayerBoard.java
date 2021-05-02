package model.gameprop;

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

    public MagicHouse getMagicHouse(int i) {
        return this.magicHouse[i - 1];
    }

    public MonsterHouse getMonsterHouse(int i) {
        return this.monsterHouse[i - 1];
    }
}
