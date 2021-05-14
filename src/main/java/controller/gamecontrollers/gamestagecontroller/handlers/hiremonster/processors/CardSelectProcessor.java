package controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.processors;

import controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.MonsterProcessor;
import model.cards.cardsProp.Card;
import model.cards.cardsProp.MagicCard;
import model.enums.GameEnums.CardLocation;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.gamemodel.Game;
import model.gameprop.SelectedCardProp;

public class CardSelectProcessor extends MonsterProcessor {

    public CardSelectProcessor(MonsterProcessor processor) {
        super(processor);
    }

    public MainPhase process(Game game) {
        SelectedCardProp cardProp = game.getCardProp();
        if (cardProp == null) return MainPhase.NO_CARD_SELECTED_YET;

        Card card = cardProp.getCard();
        CardLocation location = cardProp.getLocation();
        SideOfFeature side = cardProp.getSide();
        if (card instanceof MagicCard
                || location.equals(CardLocation.MONSTER_ZONE)
                || side.equals(SideOfFeature.OPPONENT))
            return MainPhase.CANT_SUMMON_CARD;


        return super.process(game);
    }
}
