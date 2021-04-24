package Model.MonsterEnum;

public enum MonsterType {
    NORMAL,
    EFFECT,
    RITUAL;

    public static MonsterType assignType(String type) {
        switch (type)  {
            case "Normal": {
                return MonsterType.NORMAL;
            }
            case "Effect": {
                return MonsterType.EFFECT;
            }
            case "RITUAL": {
                return MonsterType.RITUAL;
            }
            default: {
                return null;
            }
        }
    }
}
