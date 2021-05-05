package controller.gamecontrollers;

import controller.enums.GameEnums.CardLocation;
import controller.enums.GameEnums.GameError;
import controller.enums.GameEnums.GamePhaseEnums.GeneralMessage;
import controller.enums.GameEnums.SideOfFeature;
import controller.enums.rockpaperscissor.RockPaperScissorMessage;
import model.cards.cardsProp.Card;
import model.gameprop.BoardProp.GraveYard;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.Game;
import model.gameprop.GameInProcess;
import model.gameprop.Player;
import model.gameprop.SelectedCardProp;
import model.gameprop.cardvisibility.MagicHouseVisibilityState;
import model.gameprop.cardvisibility.MonsterHouseVisibilityState;
import viewer.game.GameDisplay;

public abstract class GeneralCommands {

    public static void showGraveYard(SideOfFeature side) {
        Player player;
        Game game = GameInProcess.getGame();
        if (side.equals(SideOfFeature.OPPONENT)) {
            player = game.getPlayer(SideOfFeature.OPPONENT);
        } else {
            player = game.getPlayer(SideOfFeature.CURRENT);
        }

        StringBuilder graveYardDisplay = new StringBuilder();

        GraveYard graveYard = player.getBoard().getGraveYard();

        if (graveYard.getDestroyedCards().size() == 0) {
            graveYardDisplay.append("graveyard empty");
        } else {
            for (Card destroyedCard : graveYard.getDestroyedCards()) {
                graveYardDisplay.append(destroyedCard.getName()).append(":").
                        append(destroyedCard.getDescription()).append("\n");
            }
            graveYardDisplay.deleteCharAt(graveYardDisplay.length() - 1);
        }
        GameDisplay.display(graveYardDisplay.toString());
    }

    public void selectCard(SideOfFeature side, Card card, CardLocation location) {
        Game game = GameInProcess.getGame();
        SelectedCardProp cardProp = new SelectedCardProp(card, location, side);
        game.setCardProp(cardProp);
        GameDisplay.display(GeneralMessage.SELECT_CARD_MESSAGE);
    }

    public void deSelectCard() {
        Game game = GameInProcess.getGame();
        if (game.getCardProp() != null) {
            game.setCardProp(null);
            GameDisplay.display(GeneralMessage.DESELECT_CARD_MESSAGE);
        } else {
            GameDisplay.display(GameError.INVALID_DESELECT_CARD_REQUEST);
        }
    }

    public void showSelectedCard() {
        Game game = GameInProcess.getGame();
        Player player;
        SelectedCardProp cardProp = game.getCardProp();
        if (cardProp.getSide().equals(SideOfFeature.OPPONENT)) {
            if (cardProp.getLocation().equals(CardLocation.MAGIC_HOUSE)) {
                MagicHouse magicHouse = (MagicHouse) cardProp.getCardPlace();
                if (magicHouse.getState().equals(MagicHouseVisibilityState.HIDDEN)) {
                    GameDisplay.display(GameError.INVALID_SHOW_CARD_REQUEST);
                } else {
                    GameDisplay.display(cardProp.getCard().getCardDetail());
                }
            } else {
                MonsterHouse monsterHouse = (MonsterHouse) cardProp.getCardPlace();
                if (monsterHouse.getState().equals(MonsterHouseVisibilityState.DEFENSIVE_HIDDEN)) {
                    GameDisplay.display(GameError.INVALID_SHOW_CARD_REQUEST);
                } else {
                    GameDisplay.display(cardProp.getCard().getCardDetail());
                }
            }
        } else {
            GameDisplay.display(cardProp.getCard().getCardDetail());
        }
    }
}
