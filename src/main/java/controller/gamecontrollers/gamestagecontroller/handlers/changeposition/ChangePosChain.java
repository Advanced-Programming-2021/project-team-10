package controller.gamecontrollers.gamestagecontroller.handlers.changeposition;

import controller.gamecontrollers.gamestagecontroller.handlers.changeposition.processors.CardStateProcessor;
import controller.gamecontrollers.gamestagecontroller.handlers.changeposition.processors.ChangeRequestProcessor;
import controller.gamecontrollers.gamestagecontroller.handlers.changeposition.processors.SelectedCardProcessor;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.WantedPos;
import model.gameprop.SelectedCardProp;

public class ChangePosChain {
    ChangePosProcessor processor;

    public ChangePosChain() {
        buildChain();
    }

    private void buildChain() {
        processor = new SelectedCardProcessor(new CardStateProcessor(new ChangeRequestProcessor(null)));
    }

    public MainPhase request(SelectedCardProp cardProp, WantedPos pos) {
        return processor.process(cardProp, pos);
    }
}
