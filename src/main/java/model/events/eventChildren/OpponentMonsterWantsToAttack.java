package model.events.eventChildren;

import model.events.Event;

public class OpponentMonsterWantsToAttack extends Event {
    public static OpponentMonsterWantsToAttack instance;

    public static OpponentMonsterWantsToAttack getInstance() {
        if (instance == null) {
            instance = new OpponentMonsterWantsToAttack();
        }
        return instance;
    }
}
