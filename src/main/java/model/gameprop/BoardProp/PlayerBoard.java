package model.gameprop.BoardProp;

import model.cards.cardsProp.Card;
import model.enums.GameEnums.CardLocation;
import model.enums.GameEnums.cardvisibility.MagicHouseVisibilityState;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;

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

    public Card getCard(Integer address, CardLocation location) {
        switch (location) {
            case PLAYER_HAND:
                return playerHand.get(address);
            case FIELD_ZONE:
                return field.getMagicCard();
            case SPELL_ZONE:
                return magicHouse[address].getMagicCard();
            case MONSTER_ZONE:
                return monsterHouse[address].getMonsterCard();
            default:
                return null;
        }
    }

    public void moveCardToGraveYard( int address , CardLocation location){
        if (location.equals(CardLocation.MONSTER_ZONE)){
            Card card =  monsterHouse[address].getMonsterCard();
            monsterHouse[address].setMonsterCard(null);
            graveYard.addCardToGraveYard(card);
        }
    }

    public int numberOfFullHouse(String typeOfHouse){
        int counter = 0;
        if (typeOfHouse.equals("monster")){
            for (MonsterHouse house : monsterHouse) {
                if (!house.getState().equals(MonsterHouseVisibilityState.E)){
                    counter++;
                }
            }
        }else{
            for (MagicHouse house : magicHouse) {
                if (!house.getState().equals(MagicHouseVisibilityState.E)){
                    counter++;
                }
            }
        }
        return counter;
    }
}
