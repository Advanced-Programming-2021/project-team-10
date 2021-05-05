package model.events.childEvents;

import model.cards.cardsEffect.EffectOfMagic;
import model.cards.cardsEffect.childMagicEfects.destroyAllOpponentAttackingMonsters;
import model.events.Event;

import java.util.ArrayList;

public class OpponentMonsterWantsToAttack extends Event {
    public static OpponentMonsterWantsToAttack instance;

    {
        effectsActiveWithEvent = new ArrayList<>();
    }

    public static OpponentMonsterWantsToAttack getInstance() {
        if (instance == null) {
            instance = new OpponentMonsterWantsToAttack();
        }
        return instance;
    }

    @Override
    public void activeEffects() {
        effectsActiveWithEvent.add(destroyAllOpponentAttackingMonsters.getInstance());
        for (EffectOfMagic effect : effectsActiveWithEvent) {
            effect.active();
        }
    }
}
