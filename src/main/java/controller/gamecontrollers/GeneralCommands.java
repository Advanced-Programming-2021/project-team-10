package controller.gamecontrollers;

import controller.enums.GameEnums.SideOfFeature;
import model.cards.cardsProp.Card;
import model.gameprop.BoardProp.GraveYard;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.Game;
import model.gameprop.Player;
import viewer.menudisplay.GamePlayDisplay;

public class GeneralCommands {

    public static void showGraveYard(SideOfFeature side, Game game) {
        Player player;
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
        GamePlayDisplay.displayInfo(graveYardDisplay.toString());
    }

    public static void selectCard(Game game, SideOfFeature side, MagicHouse house) {
        Player selectedPlayer;
        if (side.equals(SideOfFeature.OPPONENT)) {
            selectedPlayer = game.getPlayer(SideOfFeature.OPPONENT);
        } else {
            selectedPlayer = game.getPlayer(SideOfFeature.CURRENT);
        }
    }

    public static void showSelectedCard(Game game) {

    }
}
