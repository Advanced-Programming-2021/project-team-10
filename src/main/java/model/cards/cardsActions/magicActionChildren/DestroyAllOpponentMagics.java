package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.gamemodel.Game;

public class DestroyAllOpponentMagics extends ActionOfMagic {
    {
        name = this.getClass().getSimpleName();
    }

    @Override
    public void active(Game game) {
        PlayerBoard opponentBoard = game.getPlayer(SideOfFeature.OPPONENT).getBoard();
        for (MagicHouse magicHouse : opponentBoard.getMagicHouse()) {
            if (magicHouse.getMagicCard() != null) {
                opponentBoard.getGraveYard().addCardToGraveYard(magicHouse.getMagicCard());
                magicHouse.setMagicCard(null);
            }
        }
        isActivatedBefore = true;
    }
}
