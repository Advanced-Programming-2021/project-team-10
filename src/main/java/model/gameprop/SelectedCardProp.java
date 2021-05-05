package model.gameprop;

import controller.enums.GameEnums.CardLocation;
import controller.enums.GameEnums.SideOfFeature;
import model.cards.cardsProp.Card;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.BoardProp.MonsterHouse;

public class SelectedCardProp {
    Card card;
    CardLocation location;
    SideOfFeature side;


    public SelectedCardProp(Card card, CardLocation location, SideOfFeature side) {
        this.card = card;
        this.location = location;
        this.side = side;
    }

    public Card getCard() {
        return card;
    }

    public SideOfFeature getSide() {
        return side;
    }

    public CardLocation getLocation() {
        return location;
    }

    public Object getCardPlace() {
        Game game = GameInProcess.getGame();
        Player player = game.getPlayer(side);
        if (location.equals(CardLocation.MAGIC_HOUSE)) {
            for (MagicHouse magicHouse : player.getBoard().getMagicHouse()) {
                if (magicHouse.getMagicCard() == card)
                    return magicHouse;
            }
        } else if (location.equals(CardLocation.MONSTER_HOUSE)) {
            for (MonsterHouse monsterHouse : player.getBoard().getMonsterHouse()) {
                if (monsterHouse.getMonsterCard() == card)
                    return monsterHouse;
            }
        }
        return null;
    }

}
