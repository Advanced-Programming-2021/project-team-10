package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsProp.Card;
import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.RequestingInput;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;
import model.gameprop.Player;
import model.gameprop.gamemodel.Game;
import model.gameprop.turnBasedObserver.ChangeTeamForOneTurn;
import viewer.game.GetStringInput;

public class ChangeTeamOfMonsterCard extends ActionOfMagic {
    {
        name = this.getClass().getSimpleName();
    }

    @Override
    public void active() {
        Player currentPlayer = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT);
        Player opponentPlayer = GameInProcess.getGame().getPlayer(SideOfFeature.OPPONENT);

        PlayerBoard oppoBoard = opponentPlayer.getBoard();
        if (oppoBoard.numberOfFullHouse("monster") == 0) {

        } else {

            MonsterHouse[] oppoPlayerMonsterHouses = oppoBoard.getMonsterHouse();
            MonsterHouse[] currPlayerMonsterHouses = currentPlayer.getBoard().getMonsterHouse();
            String selectedCardName = "";

            while(selectedCardName.length() == 0) { // inputting selected card
                selectedCardName = GetStringInput.getInput(RequestingInput.CHOOSE_FROM_OPPO_MONSTER_HOUSES);
                // TODO: output properly!!!
            }

            for (int i = 0; i < oppoPlayerMonsterHouses.length; i++) { // seeking for the selected card...
                Card card = oppoPlayerMonsterHouses[i].getMonsterCard();

                if (card.getName().equals(selectedCardName)) { // found the wanted Card!
                    oppoPlayerMonsterHouses[i].setMonsterCard(null); // emptying monster house
                    for (MonsterHouse monsterHouse : currPlayerMonsterHouses) { // setting the card at the first empty monsterHouse
                        if (monsterHouse.getMonsterCard() == null) {
                            monsterHouse.setMonsterCard((MonsterCard) card);
                        }
                    }

                    //Now we should make an observer for this action!
                    new ChangeTeamForOneTurn(card, currentPlayer, opponentPlayer);
                    break;
                }
            }

        }


    }
}
