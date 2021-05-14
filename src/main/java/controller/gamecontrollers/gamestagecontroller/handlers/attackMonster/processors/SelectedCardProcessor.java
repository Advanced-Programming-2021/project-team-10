package controller.gamecontrollers.gamestagecontroller.handlers.attackMonster.processors;

import controller.gamecontrollers.gamestagecontroller.handlers.attackMonster.AttackMonsterProcessor;
import model.enums.GameEnums.CardLocation;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.SelectedCardProp;
import model.gameprop.gamemodel.Game;

public class SelectedCardProcessor extends AttackMonsterProcessor {
    public SelectedCardProcessor(AttackMonsterProcessor processor) {
        super(processor);
    }

    public MainPhase process(SelectedCardProp offensive, MonsterHouse target, Game game) {
        if (offensive == null)
            return MainPhase.NO_CARD_SELECTED_YET;
        if (!offensive.getLocation().equals(CardLocation.MONSTER_ZONE)) {
            return MainPhase.CANT_ATTACK_WRONG_lOC;
        }
        MonsterHouse offensiveCardPlace = (MonsterHouse) offensive.getCardPlace();
        if (offensiveCardPlace.isMonsterAttacked()) {
            return MainPhase.ALREADY_ATTACK;
        }

        if (target.getState().equals(MonsterHouseVisibilityState.E))
            return MainPhase.EMPTY_LOC_TO_ATTACK;

        return super.process(offensive, target, game);

    }
}
