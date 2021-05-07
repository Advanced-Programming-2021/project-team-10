package model.events.eventChildren;

public class OpponentDoesNormalOrFipSummon {
    private static OpponentDoesNormalOrFipSummon instance;

    private OpponentDoesNormalOrFipSummon() {
    }

    public static OpponentDoesNormalOrFipSummon getInstance() {
        if (instance == null) {
            instance = new OpponentDoesNormalOrFipSummon();
        }
        return instance;
    }
}
