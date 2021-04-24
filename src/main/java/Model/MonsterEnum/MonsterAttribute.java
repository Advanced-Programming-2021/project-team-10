package Model.MonsterEnum;

public enum MonsterAttribute {
    DARK,
    EARTH,
    FIRE,
    LIGHT,
    WATER,
    WIND;

    public static MonsterAttribute assignAttribute(String attribute) {
        switch (attribute) {
            case "DARK": {
                return MonsterAttribute.DARK;
            }
            case "EARTH": {
                return MonsterAttribute.EARTH;
            }
            case "FIRE": {
                return MonsterAttribute.FIRE;
            }
            case "LIGHT": {
                return MonsterAttribute.LIGHT;
            }
            case "WATER": {
                return MonsterAttribute.WATER;
            }
            case "WIND": {
                return MonsterAttribute.WIND;
            }
            default: {
                return null;
            }
        }
    }
}
