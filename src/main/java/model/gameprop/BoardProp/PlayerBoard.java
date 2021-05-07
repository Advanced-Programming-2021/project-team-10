package model.gameprop.BoardProp;

import model.cards.cardsProp.Card;

import java.util.ArrayList;

public class PlayerBoard {
    MagicHouse[] magicHouse;
    MonsterHouse[] monsterHouse;
    MagicHouse field;
    ArrayList<Card> playerHand;
    GraveYard graveYard;

    {
        initializeBoardHouses();
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

    private void initializeBoardHouses() {
        monsterHouse = new MonsterHouse[5];
        for (int i = 0; i < monsterHouse.length; i++) {
            monsterHouse[i] = new MonsterHouse();
        }
        magicHouse = new MagicHouse[5];
        for (int i = 0; i < magicHouse.length; i++) {
            magicHouse[i] = new MagicHouse();
        }
        field = new MagicHouse();
    }

    public MagicHouse getFieldHouse() {
        return field;
    }
}
