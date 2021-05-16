package model.cards.cardsActions.magicActionChildren;

import controller.gamecontrollers.GeneralController;
import controller.gamecontrollers.GetStringInputFromView;
import exceptions.CardNotFoundException;
import model.cards.cardsActions.Action;
import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.RequestingInput;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.gamemodel.Game;

public class SummonMonsterFromBothGraveYardsAction extends Action {
    {
        name = this.getClass().getSimpleName();
    }

    @Override
    public void active(Game game) {
        PlayerBoard currentPlayerboard = game.getPlayer(SideOfFeature.CURRENT).getBoard();
        PlayerBoard opponentPlayerboard = game.getPlayer(SideOfFeature.OPPONENT).getBoard();
        GeneralController.getInstance().showGraveYard(game, "--current");
        GeneralController.getInstance().showGraveYard(game, "--opponent");
        String cardToSummon = GetStringInputFromView.getInputFromView(RequestingInput.FROM_GRAVEYARD);
        MonsterCard summonedMonster;
        try {
            summonedMonster = opponentPlayerboard.getGraveYard().getMonsterCardFromGraveyardByName(cardToSummon);
            opponentPlayerboard.summonMonster(summonedMonster);
            opponentPlayerboard.getGraveYard().removeCardFromGraveYard(summonedMonster);
        } catch (CardNotFoundException e) {
            try {
                summonedMonster = currentPlayerboard.getGraveYard().getMonsterCardFromGraveyardByName(cardToSummon);
                currentPlayerboard.summonMonster(summonedMonster);
                currentPlayerboard.getGraveYard().removeCardFromGraveYard(summonedMonster);
            } catch (CardNotFoundException cardNotFoundException) {
                cardNotFoundException.printStackTrace();
                active(game);
            }
        }
        isActivatedBefore = true;
    }
}
