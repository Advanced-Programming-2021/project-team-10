package controller.gamecontrollers;

import com.sanityinc.jargs.CmdLineParser;
import model.cards.cardsProp.Card;
import model.enums.GameEnums.CardLocation;
import model.enums.GameEnums.GameError;
import model.enums.GameEnums.GamePhaseEnums.GeneralMessage;
import model.enums.GameEnums.SideOfFeature;
import model.enums.GameEnums.cardvisibility.MagicHouseVisibilityState;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;
import model.gameprop.BoardProp.GraveYard;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.Game;
import model.gameprop.GameInProcess;
import model.gameprop.Player;
import model.gameprop.SelectedCardProp;
import viewer.game.GameDisplay;

public abstract class GeneralController {

    public static void showGraveYard(String command) {
        Player player;
        Game game = GameInProcess.getGame();
        if (command.contains("--opponent")) {
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

    public void selectCard(String command) throws CmdLineParser.OptionException {
        CmdLineParser parser = new CmdLineParser();
        CmdLineParser.Option<Boolean> isOpponent = parser.addBooleanOption('o', "opponent");
        CmdLineParser.Option<Boolean> field = parser.addBooleanOption('f', "field");
        CmdLineParser.Option<Integer> monster = parser.addIntegerOption('m', "monster");
        CmdLineParser.Option<Integer> spell = parser.addIntegerOption('s', "spell");
        CmdLineParser.Option<Integer> hand = parser.addIntegerOption('h', "hand");
        String[] splitCommand = command.split(" ");
        parser.parse(splitCommand);

        boolean opponentSide = parser.getOptionValue(isOpponent,false);
        SideOfFeature side = SideOfFeature.CURRENT;
        if (opponentSide) side = SideOfFeature.OPPONENT;

        int cardAddress = 0;
        CardLocation location;

        if (parser.getOptionValue(monster) != null) {
            cardAddress = parser.getOptionValue(monster);
            location = CardLocation.MONSTER_HOUSE;
        } else if (parser.getOptionValue(spell) != null) {
            cardAddress = parser.getOptionValue(spell);
            location = CardLocation.MAGIC_HOUSE;
        } else if (parser.getOptionValue(field, false)) {
            location = CardLocation.FIELD_HOUSE;
        } else {
            cardAddress = parser.getOptionValue(hand);
            location = CardLocation.PLAYER_HAND;
        }

        SelectedCardProp selectedCardProp = new SelectedCardProp(cardAddress, location, side);
        GameInProcess.getGame().setCardProp(selectedCardProp);
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
                if (magicHouse.getState().equals(MagicHouseVisibilityState.H)) {
                    GameDisplay.display(GameError.INVALID_SHOW_CARD_REQUEST);
                } else {
                    GameDisplay.display(cardProp.getCard().getCardDetail());
                }
            } else {
                MonsterHouse monsterHouse = (MonsterHouse) cardProp.getCardPlace();
                if (monsterHouse.getState().equals(MonsterHouseVisibilityState.DH)) {
                    GameDisplay.display(GameError.INVALID_SHOW_CARD_REQUEST);
                } else {
                    GameDisplay.display(cardProp.getCard().getCardDetail());
                }
            }
        } else {
            GameDisplay.display(cardProp.getCard().getCardDetail());
        }
    }

    public void nextPhase() {
        GameInProcess.getGame().goToNextPhase();
    }

    public abstract void run(String command) throws CmdLineParser.OptionException;
}
