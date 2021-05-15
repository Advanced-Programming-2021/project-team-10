package model.cards.cardsActions.magicActionChildren;

import controller.gamecontrollers.GetStringInputFromView;
import exceptions.CardNotFoundException;
import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsProp.MagicCard;
import model.enums.GameEnums.RequestingInput;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;

public class DestroyAMagicCard extends ActionOfMagic {
    {
        name = this.getClass().getSimpleName();
    }

    @Override
    public void active() {
        PlayerBoard opponentBoard = GameInProcess.getGame().getPlayer(SideOfFeature.OPPONENT).getBoard();
        PlayerBoard currentBoard = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT).getBoard();
        String magicToDestroy = GetStringInputFromView.getInputFromView(RequestingInput.MAGIC_CARD_TO_DESTROY);
        try {
            MagicCard cardToDestroy = opponentBoard.getMagicCardByName(magicToDestroy);
            opponentBoard.getGraveYard().addCardToGraveYard(cardToDestroy);
            for (MagicHouse magicHouse : opponentBoard.getMagicHouse()) {
                if (magicHouse.getMagicCard().getName().equals(magicToDestroy)) {
                    magicHouse.setMagicCard(null);
                }
            }
        }
        catch (CardNotFoundException e) {
            try {
                MagicCard cardToDestroy = currentBoard.getMagicCardByName(magicToDestroy);
                currentBoard.getGraveYard().addCardToGraveYard(cardToDestroy);
                for (MagicHouse magicHouse : currentBoard.getMagicHouse()) {
                    if (magicHouse.getMagicCard().getName().equals(magicToDestroy)) {
                        magicHouse.setMagicCard(null);
                    }
                }
            } catch (CardNotFoundException cardNotFoundException) {
                cardNotFoundException.printStackTrace();
                active();
            }
        }
    }
}
