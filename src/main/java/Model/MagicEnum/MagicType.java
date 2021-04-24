package Model.MagicEnum;

public enum MagicType {
    SPELL(),
    TRAP();


    MagicType() {
    }

    public static MagicType setType(String typeOfMagic) {

        switch (typeOfMagic) {
            case "Spell": {
                return MagicType.SPELL;
            }
            case "Trap": {
                return MagicType.TRAP;
            }
            default:
                return null;
        }

    }
}
