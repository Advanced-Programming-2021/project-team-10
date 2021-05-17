package controller.gamecontrollers.gamestagecontroller.handlers.activeeffect.processors;

import controller.gamecontrollers.gamestagecontroller.handlers.activeeffect.ActiveEffectProcessor;
import model.cards.cardsEnum.Magic.MagicSpeed;
import model.cards.cardsProp.MagicCard;
import model.enums.GameEnums.CardLocation;
import model.enums.GameEnums.GamePhaseEnums.General;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.SelectedCardProp;
import model.gameprop.gamemodel.Game;

public class ActiveSpellProcessor extends ActiveEffectProcessor {


    public ActiveSpellProcessor(ActiveEffectProcessor processor) {
        super(processor);
    }

    public String process(Game game) {
        SelectedCardProp cardProp = game.getCardProp();
        MagicCard magicCard = (MagicCard) cardProp.getCard();
        if (cardProp.getLocation().equals(CardLocation.PLAYER_HAND)) {
            if (magicCard.getMagicSpeed().equals(MagicSpeed.UNLIMITED))
                return General.MAGIC_SPELL_SPEED_2.toString();
            else {
                if (game.getPlayer(SideOfFeature.CURRENT).getBoard().numberOfFullHouse("spell") == 5) {
                    return General.SPELL_CARD_ZONE_FULL.toString();
                }
            }
        }
        return null;
    }
}
