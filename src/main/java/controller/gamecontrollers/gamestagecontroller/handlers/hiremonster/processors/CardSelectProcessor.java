package controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.processors;

import controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.MonsterProcessor;
import model.cards.cardsProp.Card;
import model.enums.GameEnums.CardLocation;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.SelectedCardProp;
import model.gameprop.gamemodel.Game;

public class CardSelectProcessor extends MonsterProcessor {

    public CardSelectProcessor(MonsterProcessor processor) {
        super(processor);
    }

    public MainPhase process(Game game) {
        SelectedCardProp cardProp = game.getCardProp();
        if (cardProp == null) return MainPhase.NO_CARD_SELECTED_YET;

        CardLocation location = cardProp.getLocation();
        SideOfFeature side = cardProp.getSide();
        if (location.equals(CardLocation.MONSTER_ZONE)
                || side.equals(SideOfFeature.OPPONENT))
            return MainPhase.CANT_HIRE_CARD;


        return super.process(game);
    }
}
