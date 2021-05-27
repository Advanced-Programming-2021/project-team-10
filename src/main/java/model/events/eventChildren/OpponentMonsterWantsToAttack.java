package model.events.eventChildren;

import model.events.Event;

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
}
