package model.cards.cardsActions.magicActionChildren;

import controller.gamecontrollers.GeneralController;
import controller.gamecontrollers.GetStringInputFromView;
import exceptions.CardNotFoundException;
import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.RequestingInput;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;

public class SummonMonsterFromOwnGraveYardAction extends ActionOfMagic {
    {
        name = this.getClass().getSimpleName();
    }

    @Override
    public void active() {
        PlayerBoard currentPlayerboard = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT).getBoard();
        GeneralController.getInstance().showGraveYard(GameInProcess.getGame(), "--current");
        String cardToSummon = GetStringInputFromView.getInputFromController(RequestingInput.FROM_GRAVEYARD);
        MonsterCard summonedMonster;
        try {
            summonedMonster = currentPlayerboard.getGraveYard().getMonsterCardFromGraveyardByName(cardToSummon);
            currentPlayerboard.summonMonster(summonedMonster);
            currentPlayerboard.getGraveYard().removeCardFromGraveYard(summonedMonster);
        } catch (CardNotFoundException e) {
            e.printStackTrace();
            active();
        }
        isActivatedBefore = true;
    }
}
