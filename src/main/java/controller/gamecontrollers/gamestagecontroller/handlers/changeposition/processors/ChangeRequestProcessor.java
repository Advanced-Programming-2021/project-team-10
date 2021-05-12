package controller.gamecontrollers.gamestagecontroller.handlers.changeposition.processors;

import controller.gamecontrollers.gamestagecontroller.handlers.changeposition.ChangePosProcessor;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.WantedPos;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.SelectedCardProp;

public class ChangeRequestProcessor extends ChangePosProcessor {
    public ChangeRequestProcessor(ChangePosProcessor processor) {
        super(processor);
    }

    public MainPhase processor(SelectedCardProp cardProp, WantedPos pos) {
        MonsterHouse monsterHouse = (MonsterHouse) cardProp.getCardPlace();
        if (monsterHouse.isPosChange())
            return MainPhase.POS_CHANGE_BEFORE;
        else {
            if (pos.equals(WantedPos.ATTACK)) {
                monsterHouse.changePos();
                monsterHouse.setState(MonsterHouseVisibilityState.OO);
            }else{
                monsterHouse.changePos();
                monsterHouse.setState(MonsterHouseVisibilityState.DO);
            }
            return MainPhase.MONSTER_CHANGE_POS;
        }
    }
}
