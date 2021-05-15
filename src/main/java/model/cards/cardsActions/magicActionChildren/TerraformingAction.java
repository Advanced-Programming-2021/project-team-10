package model.cards.cardsActions.magicActionChildren;

import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsEnum.Magic.MagicAttribute;
import model.cards.cardsProp.Card;
import model.cards.cardsProp.MagicCard;
import model.enums.GameEnums.RequestingInput;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.GameInProcess;
import model.gameprop.Player;
import viewer.game.GetStringInput;

import java.util.ArrayList;

public class TerraformingAction extends ActionOfMagic {

    {
        name = this.getClass().getSimpleName();
    }

    @Override
    public void active() {
        Player player = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT);
        ArrayList<Card> mainDeck = player.getDeck().getMainDeck();
        ArrayList<Card> toShowCards = new ArrayList<>();

        ArrayList<Card> hand = player.getBoard().getPlayerHand();
        if (hand.size() > 6) {
            // TODO: output error!!!
        } else {
            for (Card card : mainDeck) { // seeking "FIELD" spells in deck...
                if (card instanceof MagicCard) {
                    if ( ((MagicCard) card).getMagicAttribute() == MagicAttribute.FIELD) {
                        toShowCards.add(card);
                    }
                }
            }

            // TODO: showing cards to player in CLI!!!

            String selectedName = "";
            while (selectedName.length() == 0) { // I/O dialog...
                selectedName = GetStringInput.getInput(RequestingInput.CHOOSE_FIELD_CARD); // INCOMPLETE output!
            }

            for (Card card : mainDeck) { // actual process of Action...
                if (card.getName().equals(selectedName)) {
                    GameInProcess.getGame().moveCardFromHandToDeck(card);
                }
            }
        }


    }
}
