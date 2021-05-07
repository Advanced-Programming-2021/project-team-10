package model.gameprop.BoardProp;

import model.cards.cardsProp.Card;
import model.enums.GameEnums.CardLocation;

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

    public Card getCard(int address, CardLocation location) {
        switch (location) {
            case PLAYER_HAND:
                return playerHand.get(address - 1);
            case FIELD_HOUSE:
                return field.getMagicCard();
            case MAGIC_HOUSE:
                return magicHouse[address - 1].getMagicCard();
            case MONSTER_HOUSE:
                return monsterHouse[address - 1].getMonsterCard();
            default:
                return null;
        }
    }
}
