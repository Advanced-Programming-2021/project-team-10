package model.gameprop;

import model.cards.cardsProp.Card;
import model.enums.GameEnums.CardLocation;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.PlayerBoard;

public class SelectedCardProp {
    int cardAddress;
    CardLocation location;
    SideOfFeature side;


    public SelectedCardProp(int cardAddress, CardLocation location, SideOfFeature side) {
        this.cardAddress = cardAddress;
        this.location = location;
        this.side = side;
    }

    public Card getCard() {
        Player player;

        if (side == SideOfFeature.OPPONENT)
            player = GameInProcess.getGame().getPlayer(SideOfFeature.OPPONENT);
        else
            player = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT);

        switch (location) {
            case FIELD_HOUSE:
                return player.getBoard().getFieldHouse().getMagicCard();
            case MAGIC_HOUSE:
                return player.getBoard().getMagicHouse()[cardAddress].getMagicCard();
            case MONSTER_HOUSE:
                return player.getBoard().getMonsterHouse()[cardAddress].getMonsterCard();
            case PLAYER_HAND:
                return player.getBoard().getPlayerHand().get(cardAddress);
            default:
                return null;
        }
    }


    public SideOfFeature getSide() {
        return side;
    }

    public CardLocation getLocation() {
        return location;
    }

    public Object getCardPlace() {

        PlayerBoard board = GameInProcess.getGame().getPlayer(side).getBoard();
        if (location.equals(CardLocation.MAGIC_HOUSE)) {
            return board.getMagicHouse()[cardAddress];
        } else if (location.equals(CardLocation.MONSTER_HOUSE)) {
            return board.getMonsterHouse()[cardAddress];
        } else if (location.equals(CardLocation.FIELD_HOUSE)) {
            return board.getFieldHouse();
        }
        return null;
    }

}
