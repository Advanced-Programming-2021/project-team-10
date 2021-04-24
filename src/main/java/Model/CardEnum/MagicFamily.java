package Model.CardEnum;

public enum MagicFamily {
    RITUAL(),
    QUICK_PLAY(),
    FIELD(),
    EQUIP(),
    CONTINUOUS(),
    COUNTER(),
    ANTI_TRAP(),
    NORMAL();

    MagicFamily() {
    }

    public static MagicFamily setFamily(String familyType) {
        switch (familyType) {
            case "Ritual": {
                return RITUAL;
            }
            case "Quick-Play": {
                return QUICK_PLAY;
            }
            case "Field": {
                return FIELD;
            }
            case "Continuous": {
                return CONTINUOUS;
            }
            case "Counter": {
                return COUNTER;
            }
            case "Anti-Trap": {
                return ANTI_TRAP;
            }
            case "Normal": {
                return NORMAL;
            }
            case "Equip": {
                return EQUIP;
            }
            default:
                return null;
        }
    }
}
