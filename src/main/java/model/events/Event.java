package model.events;

import model.enums.GameEnums.SideOfFeature;
import model.events.eventChildren.ManuallyActivation;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;

public class Event {
    public void activeEffects() {
        PlayerBoard currentPlayerBoard = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT).getBoard();
        if (this instanceof ManuallyActivation) {
            GameInProcess.getGame().getCardProp().getCard().activeEffectsByEvent(this);
        } else {
            for (MonsterHouse monsterHouse : currentPlayerBoard.getMonsterHouse()) {
                monsterHouse.getMonsterCard().activeEffectsByEvent(this);
            }
            for (MagicHouse magicHouse : currentPlayerBoard.getMagicHouse()) {
                magicHouse.getMagicCard().activeEffectsByEvent(this);
            }
        }
    }
}
