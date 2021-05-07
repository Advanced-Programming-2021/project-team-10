package model.gameprop;

import model.cards.cardsProp.Card;
import model.enums.GameEnums.CardLocation;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.GameHouse;
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

        return player.getBoard().getCard(cardAddress, location);
    }


    public SideOfFeature getSide() {
        return side;
    }

    public CardLocation getLocation() {
        return location;
    }

    public GameHouse getCardPlace() {

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
