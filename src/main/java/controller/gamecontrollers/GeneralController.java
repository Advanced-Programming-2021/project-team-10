package controller.gamecontrollers;

import com.sanityinc.jargs.CmdLineParser;
import model.cards.cardsProp.Card;
import model.enums.GameEnums.CardLocation;
import model.enums.GameEnums.GameError;
import model.enums.GameEnums.GamePhaseEnums.GeneralMessage;
import model.enums.GameEnums.SideOfFeature;
import model.enums.GameEnums.cardvisibility.MagicHouseVisibilityState;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;
import model.enums.GameEnums.gamestage.GameSideStage;
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
        game.setGameSideStage(GameSideStage.WAIT_STAGE);
    }

    public void selectCard(String command) throws CmdLineParser.OptionException {
        Game game = GameInProcess.getGame();
        if (game.getSelectedCardProp() != null) {
            GameDisplay.display(GameError.CARD_SELECTED_BEFORE);
            return;
        }
        CmdLineParser parser = new CmdLineParser();
        CmdLineParser.Option<Boolean> isOpponent = parser.addBooleanOption('o', "opponent");
        CmdLineParser.Option<Boolean> field = parser.addBooleanOption('f', "field");
        CmdLineParser.Option<Integer> monster = parser.addIntegerOption('m', "monster");
        CmdLineParser.Option<Integer> spell = parser.addIntegerOption('s', "spell");
        CmdLineParser.Option<Integer> hand = parser.addIntegerOption('h', "hand");
        String[] splitCommand = command.split(" ");
        parser.parse(splitCommand);


        boolean opponentSide = parser.getOptionValue(isOpponent, false);
        SideOfFeature side = SideOfFeature.CURRENT;
        Player player = game.getPlayer(SideOfFeature.CURRENT);
        if (opponentSide) {
            side = SideOfFeature.OPPONENT;
            player = game.getPlayer(SideOfFeature.OPPONENT);
        }

        Integer cardAddress;
        CardLocation location;

        if ((cardAddress = parser.getOptionValue(monster)) != null) {
            if (cardAddress > 5 || cardAddress < 1) {
                GameDisplay.display(GameError.INVALID_SELECTION);
                return;
            }
            location = CardLocation.MONSTER_HOUSE;
        } else if ((cardAddress = parser.getOptionValue(spell)) != null) {
            if (cardAddress > 5 || cardAddress < 1) {
                GameDisplay.display(GameError.INVALID_SELECTION);
                return;
            }
            location = CardLocation.MAGIC_HOUSE;
        } else if (parser.getOptionValue(field, false)) {
            location = CardLocation.FIELD_HOUSE;
        } else {
            cardAddress = parser.getOptionValue(hand);
            if (cardAddress > player.getBoard().getPlayerHand().size()) {
                GameDisplay.display(GameError.INVALID_SELECTION);
                return;
            }
            location = CardLocation.PLAYER_HAND;
        }

        if (player.getBoard().getCard(cardAddress, location) != null) {
            SelectedCardProp selectedCardProp = new SelectedCardProp(cardAddress, location, side);
            game.setCardProp(selectedCardProp);
            game.setGameSideStage(GameSideStage.WAIT_STAGE);
        } else {
            GameDisplay.display(GameError.EMPTY_SELECTION);
        }

    }

    public void deSelectCard() {
        Game game = GameInProcess.getGame();
        if (game.getCardProp() != null) {
            game.setCardProp(null);
            GameDisplay.display(GeneralMessage.DESELECT_CARD_MESSAGE);
            game.setGameSideStage(GameSideStage.WAIT_STAGE);
        } else {
            GameDisplay.display(GameError.INVALID_DESELECT_CARD_REQUEST);
        }
    }

    public void showSelectedCard() {
        Game game = GameInProcess.getGame();
        SelectedCardProp cardProp = game.getCardProp();
        if (cardProp.getSide().equals(SideOfFeature.OPPONENT)) {
            if (cardProp.getLocation().equals(CardLocation.MAGIC_HOUSE)) {
                MagicHouse magicHouse = (MagicHouse) cardProp.getCardPlace();
                if (magicHouse.getState().equals(MagicHouseVisibilityState.H)) {
                    GameDisplay.display(GameError.INVALID_SHOW_CARD_REQUEST);
                } else {
                    GameDisplay.display(cardProp.getCard().getCardDetail());
                    game.setGameSideStage(GameSideStage.WAIT_STAGE);
                }
            } else {
                MonsterHouse monsterHouse = (MonsterHouse) cardProp.getCardPlace();
                if (monsterHouse.getState().equals(MonsterHouseVisibilityState.DH)) {
                    GameDisplay.display(GameError.INVALID_SHOW_CARD_REQUEST);
                } else {
                    GameDisplay.display(cardProp.getCard().getCardDetail());
                    game.setGameSideStage(GameSideStage.WAIT_STAGE);
                }
            }
        } else {
            GameDisplay.display(cardProp.getCard().getCardDetail());
            game.setGameSideStage(GameSideStage.WAIT_STAGE);
        }
    }

    public void nextPhase() {
        Game game = GameInProcess.getGame();
        game.goToNextPhase();
        GameDisplay.display(GeneralMessage.NEXT_PHASE_MESSAGE, game.getGameMainStage().getPhaseName());
    }

    public void surrender() {
        Game game = GameInProcess.getGame();
        GameInProcess.getGame().finishGame(GameInProcess.getGame().getTurn());
        GameDisplay.display(game.getPlayer(SideOfFeature.CURRENT).getUser().getNickname() +
                " won the game and the score is: 1-0");
    }

    public abstract void run(String command) throws CmdLineParser.OptionException;

    public boolean isCommandGeneral(String command) throws CmdLineParser.OptionException {
        if (command.startsWith("select -d")) {
            deSelectCard();
            return true;
            // d selecting card
        } else if (command.startsWith("show graveyard")) {
            showGraveYard(command);
            // show grave yard (current / opponent)
        } else if (command.startsWith("select")) {
            selectCard(command);
            return true;
            // select a card from (monster / spell / hand )
        } else if (command.startsWith("card show")) {
            showSelectedCard();
            return true;
            // show card detail
        } else if (command.equals("surrender")) {
            surrender();
            return true;
        } else if (command.equals("next phase")) {
            nextPhase();
            return true;
        }
        return false;
    }
}
