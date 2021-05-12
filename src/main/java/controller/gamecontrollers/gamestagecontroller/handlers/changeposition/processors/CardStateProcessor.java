package controller.gamecontrollers.gamestagecontroller.handlers.changeposition.processors;

import controller.gamecontrollers.gamestagecontroller.handlers.changeposition.ChangePosProcessor;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.WantedPos;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.SelectedCardProp;

public class CardStateProcessor extends ChangePosProcessor {

    public CardStateProcessor(ChangePosProcessor processor) {
        super(processor);
    }

    public MainPhase process(SelectedCardProp cardProp, WantedPos pos) {
        MonsterHouse monsterHouse;
        monsterHouse = (MonsterHouse) cardProp.getCardPlace();
        if ((monsterHouse.getState().equals(MonsterHouseVisibilityState.DO) && pos.equals(WantedPos.DEFENCE)) ||
                monsterHouse.getState().equals(MonsterHouseVisibilityState.OO) && pos.equals(WantedPos.ATTACK)) {
            return MainPhase.ALREADY_IN_WANTED_POS;
        }
        if ((monsterHouse.getState().equals(MonsterHouseVisibilityState.DH)))
            return MainPhase.FLIP_NEEDED;
        return super.process(cardProp, pos);
    }
}
