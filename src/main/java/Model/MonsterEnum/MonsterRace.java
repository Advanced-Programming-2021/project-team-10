package Model.MonsterEnum;

public enum MonsterRace {
    BEAST_WARRIOR,
    WARRIOR,
    AQUA,
    FIEND,
    BEAST,
    PYRO,
    SPELLCASTER,
    THUNDER,
    DRAGON,
    MACHINE,
    ROCK,
    INSECT,
    CYBERSE,
    FAIRY,
    SEA_SERPENT;

    public static MonsterRace assignRace(String race) {
        switch (race) {
            case "Beast-Warrior": {
                return MonsterRace.BEAST_WARRIOR;
            }
            case "Warrior": {
                return MonsterRace.WARRIOR;
            }
            case "Aqua": {
                return MonsterRace.AQUA;
            }
            case "Fiend": {
                return MonsterRace.FIEND;
            }
            case "Beast": {
                return MonsterRace.BEAST;
            }
            case "Pyro": {
                return MonsterRace.PYRO;
            }
            case "Spellcaster": {
                return MonsterRace.SPELLCASTER;
            }
            case "Thunder": {
                return MonsterRace.THUNDER;
            }
            case "Dragon": {
                return MonsterRace.DRAGON;
            }
            case "Machine": {
                return MonsterRace.MACHINE;
            }
            case "Rock": {
                return MonsterRace.ROCK;
            }
            case "Insect": {
                return MonsterRace.INSECT;
            }
            case "Cyberse": {
                return MonsterRace.CYBERSE;
            }
            case "Fairy": {
                return MonsterRace.FAIRY;
            }
            case "Sea Serpent": {
                return MonsterRace.SEA_SERPENT;
            }
            default: {
                return null;
            }
        }
    }



}
