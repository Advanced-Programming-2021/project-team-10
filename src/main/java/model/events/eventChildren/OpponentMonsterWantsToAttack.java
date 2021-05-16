package model.events.eventChildren;

import model.enums.GameEnums.SideOfFeature;
import model.events.Event;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.gamemodel.Game;

public class OpponentMonsterWantsToAttack extends Event {
    private static OpponentMonsterWantsToAttack instance;

    private OpponentMonsterWantsToAttack() {
    }

    public static OpponentMonsterWantsToAttack getInstance() {
        if (instance == null) {
            instance = new OpponentMonsterWantsToAttack();
        }
        return instance;
    }

    @Override
    public void activeEffects(Game game) {
        PlayerBoard currentPlayerBoard = game.getPlayer(SideOfFeature.CURRENT).getBoard();
        for (MagicHouse magicHouse : currentPlayerBoard.getMagicHouse()) {
            magicHouse.getMagicCard().activeEffectsByEvent(this, game);
        }
    }
}
