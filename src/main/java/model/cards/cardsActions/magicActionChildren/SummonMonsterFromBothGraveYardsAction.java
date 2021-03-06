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
        PlayerBoard currentPlayerBoard = game.getPlayer(SideOfFeature.CURRENT).getBoard();
        PlayerBoard opponentPlayerBoard = game.getPlayer(SideOfFeature.OPPONENT).getBoard();

        String graveYardViewer = "Your GraveYard\n" +
                GeneralController.getInstance().showGraveYard(game, "--current") +
                "\n------------------------------------\nYour Enemy GraveYard\n" +
                GeneralController.getInstance().showGraveYard(game, "--opponent");
        System.out.println(graveYardViewer);

        String cardToSummon = GetStringInputFromView.getInputFromView(RequestingInput.FROM_GRAVEYARD);
        MonsterCard summonedMonster;
        try {
            summonedMonster = opponentPlayerBoard.getGraveYard().getMonsterCardFromGraveyardByName(cardToSummon);
            currentPlayerBoard.summonMonster(summonedMonster);
            opponentPlayerBoard.getGraveYard().removeCardFromGraveYard(summonedMonster);
        } catch (CardNotFoundException e) {
            try {
                summonedMonster = currentPlayerBoard.getGraveYard().getMonsterCardFromGraveyardByName(cardToSummon);
                currentPlayerBoard.summonMonster(summonedMonster);
                currentPlayerBoard.getGraveYard().removeCardFromGraveYard(summonedMonster);
            } catch (CardNotFoundException cardNotFoundException) {
                System.out.println(cardNotFoundException.getMessage());
                active(game);
            }
        }
        isActivatedBefore = true;
    }
}
