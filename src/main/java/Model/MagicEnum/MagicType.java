package Model.MagicEnum;

public enum MagicType {
    SPELL(),
    TRAP();


    MagicType() {
    }

    public static MagicType setType(String typeOfMagic) {

        switch (typeOfMagic) {
            case "Spell": {
                return SPELL;
            }
            case "Trap": {
                return TRAP;
            }
            default:
                return null;
        }

    }
}
