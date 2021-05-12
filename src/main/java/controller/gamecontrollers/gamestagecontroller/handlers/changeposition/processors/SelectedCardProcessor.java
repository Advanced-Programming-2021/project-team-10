package controller.gamecontrollers.gamestagecontroller.handlers.changeposition.processors;

import controller.gamecontrollers.gamestagecontroller.handlers.changeposition.ChangePosProcessor;
import model.enums.GameEnums.CardLocation;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.WantedPos;
import model.gameprop.SelectedCardProp;

public class SelectedCardProcessor extends ChangePosProcessor {

    public SelectedCardProcessor(ChangePosProcessor processor) {
        super(processor);
    }

    public MainPhase process(SelectedCardProp cardProp, WantedPos pos) {
        if (cardProp == null) return MainPhase.NO_CARD_SELECTED_YET;
        if (!cardProp.getLocation().equals(CardLocation.PLAYER_HAND))
            return MainPhase.WRONG_LOCATION_FOR_CHANGE;

        return super.process(cardProp, pos);
    }
}
