package model.events.eventChildren;

import model.events.Event;

public class SpecialMonsterSummon extends Event {
    private static SpecialMonsterSummon instance;

    public static SpecialMonsterSummon getInstance() {
        if (instance == null) {
            instance = new SpecialMonsterSummon();
        }
        return instance;
    }
}
