package model.enums.GameEnums.GamePhaseEnums;

public enum MainPhase {
    DEFEAT_ATTACK_OO_TARGET("Your monster card is destroyed and you received OO_DEFEAT battle\n" +
            "damage"),
    DEFEAT_ATTACK_ON_DEFENCE_UNKNOWN("no card is destroyed and you received D_DEFEAT battle damage"),
    SUCCESSFUL_ATTACK_DEFENCE_KNOWN_TARGET("the defense position monster is destroyed"),
    SUCCESSFUL_ATTACK_OFFENSIVE_TARGET("your opponent’s monster is destroyed and your opponent receives\n" +
            "OO_WIN battle damage"),
    NO_CARD_ELIMINATE("no card is destroyed"),
    BOTH_CARD_ELIMINATE("both you and your opponent monster cards are destroyed and no\n" +
            "one receives damage"),
    SUMMONED_SUCCESSFULLY("summon successfully"),
    EMPTY_LOC_TO_ATTACK("there is no card in this position"),
    ALREADY_ATTACK("this card already attacked"),
    CANT_ATTACK_WRONG_lOC("can't attack with this card"),
    CARD_FLIP_SUCCESSFULLY("flip summoned successfully"),
    CANT_FLIP_SUMMON_THIS_CARD("can't flip summon this card"),
    CANT_CHANGE_POS_OF_HIRED_CARD("can't change the position of summoned card"),
    FLIP_NEEDED("you must flip this card"),
    SET_SUCCESSFULLY("set successfully"),
    CANT_SUMMON_CARD("cant summon this card"),
    HIRE_MONSTER_BEFORE("you already summoned/set on this turn"),
    BOARD_IS_FULL("player board is full"),
    TRIBUTE_NOT_POSSIBLE("dont have enough card for tribute"),
    ONE_TRIBUTE_NEED("you need to tribute 1 monster" +
            "\n (type the address in this format : (T:<cardAddress>)"),
    TW0_TRIBUTE_NEED("you need to tribute 2 monster" +
            "\n (type the address in this format : (T1:<cardAddress> T2:<cardAddress>)"),
    NO_CARD_SELECTED_YET("no card selected yet"),
    ALREADY_IN_WANTED_POS("already in wanted position"),
    POS_CHANGE_BEFORE("position of this monster  change before "),
    MONSTER_CHANGE_POS("monster card position changed successfully"),
    WRONG_LOCATION_FOR_CHANGE("you can't change this card position");
    String messageToString;

    MainPhase(String messageToString) {
        this.messageToString = messageToString;
    }

    public String toString() {
        return messageToString;
    }

}
