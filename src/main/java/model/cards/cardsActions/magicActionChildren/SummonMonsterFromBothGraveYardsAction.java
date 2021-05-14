package model.cards.cardsActions.magicActionChildren;

import controller.gamecontrollers.GeneralController;
import controller.gamecontrollers.GetStringInputFromView;
import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.RequestingInput;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;

public class SummonMonsterFromBothGraveYardsAction extends ActionOfMagic {
    {
        name = this.getClass().getSimpleName();
    }

    @Override
    public void active() {
        PlayerBoard currentPlayerboard = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT).getBoard();
        PlayerBoard opponentPlayerboard = GameInProcess.getGame().getPlayer(SideOfFeature.OPPONENT).getBoard();
        GeneralController.getInstance().showGraveYard(GameInProcess.getGame(), "--current");
        GeneralController.getInstance().showGraveYard(GameInProcess.getGame(), "--opponent");
        String cardToSummon = GetStringInputFromView.getInputFromView(RequestingInput.FROM_GRAVEYARD);
        if (opponentPlayerboard.getGraveYard().getMonsterCardFromGraveyardByName(cardToSummon) != null) {
            MonsterCard summonedMonster = opponentPlayerboard.getGraveYard().getMonsterCardFromGraveyardByName(cardToSummon);
            opponentPlayerboard.summonMonster(summonedMonster);
            opponentPlayerboard.getGraveYard().removeCardFromGraveYard(summonedMonster);
        } else {
            MonsterCard summonedMonster = currentPlayerboard.getGraveYard().getMonsterCardFromGraveyardByName(cardToSummon);
            currentPlayerboard.summonMonster(summonedMonster);
            currentPlayerboard.getGraveYard().removeCardFromGraveYard(summonedMonster);
        }
    }
}
