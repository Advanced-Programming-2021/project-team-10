package model.cards.cardsEffect.magicEffectChildren;

import controller.enums.GameEnums.SideOfFeature;
import model.cards.cardsEffect.EffectOfMagic;
import model.events.eventChildren.OpponentMonsterWantsToAttack;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;
import model.gameprop.cardvisibility.MonsterHouseVisibilityState;

import java.util.ArrayList;

public class destroyAllOpponentAttackingMonsters extends EffectOfMagic {
    private static destroyAllOpponentAttackingMonsters instance;

    {
        eventsActivateEffect = new ArrayList<>();
        eventsActivateEffect.add(OpponentMonsterWantsToAttack.getInstance());
    }

    public static destroyAllOpponentAttackingMonsters getInstance() {
        if (instance == null) {
            instance = new destroyAllOpponentAttackingMonsters();
        }
        return instance;
    }

    @Override
    public void active() {
        PlayerBoard opponentBoard = GameInProcess.getGame().getPlayer(SideOfFeature.OPPONENT).getBoard();
        MonsterHouse[] opponentMonsterHouse = opponentBoard.getMonsterHouse();
        for (MonsterHouse monsterHouse : opponentMonsterHouse) {
            if (monsterHouse.getMonsterCard() != null) {
                opponentBoard.getGraveYard().addCardToGraveYard(monsterHouse.getMonsterCard());
                monsterHouse.setMonsterCard(null);
                monsterHouse.setState(MonsterHouseVisibilityState.EMPTY);
            }
        }
    }
}
