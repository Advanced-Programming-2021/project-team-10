package viewer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Regex {
    public static String menuEnter = "menu enter (.+)";
    public static String createUser = "user create --[npu].+";
    public static String username = ".+(?<= )--username (\\S+)(?= --nickname.*| --password.*|$).*$";
    public static String nickname = ".+(?<= )--nickname (\\S+)(?= --username.*| --password.*|$).*$";
    public static String password = ".+(?<= )--password (\\S+)(?= --nickname.*| --username.*|$).*$";
    public static String profileChange = "profile Change (.*)";
    public static String changeNickname = "profile Change --nickname (.*)";
    public static String changePassword = ".+(?<= |^)--password(?= --current.*| --new.*|$).*$";
    public static String currentPassword = ".+(?<= |^)--current (\\S+)(?= --password| --new.*|$).*$";
    public static String newPassword = ".+(?<= |^)--new (\\S+)(?= --password| --current.*|$).*$";
    public static String showGraveYard = "show graveyard(?: --opponent)?$";
    public static String duel = "duel (.+)";
    public static String secondPlayer = ".+(?<= |^)--second-player (\\S+)(?= --new| --rounds.*|$).*$";
    public static String rounds = ".+(?<= |^)--rounds (\\S+)(?= --new| --second-player.*|$).*$";
    public static String duelNew = ".+(?<= |^)--new(?= --second-player.*| --rounds.*|$).*$";

    // DeckMenu Commands:
    public static String createDeck = "deck create (?<deckName>.+)";
    public static String deleteDeck = "deck delete (?<deckName>.+)";
    public static String activateDeck = "deck set-active (?<deckName>.+)";

        // adding card commands:
        public static String[] addCardToMainDeck = new String[]{
            "^deck add-card --card (?<cardName>.+) --deck (?<deckName>.+)$",
            "^deck add-card --deck (?<deckName>.+) --card (?<cardName>.+)$"
        };
        public static String[] addCardToSideDeck = new String[] {
            // --side at end:
            "^deck add-card --card (?<cardName>.+) --deck (?<deckName>.+?) --side$",
            "^deck add-card --deck (?<deckName>.+?) --card (?<cardName>.+) --side$",
            // --side at middle:
            "^deck add-card --deck (?<deckName>.+) --side --card (?<cardName>.+)$",
            "^deck add-card --card (?<cardName>.+) --side --deck (?<deckName>.+)$",
            // --side at first:
            "^deck add-card --side --deck (?<deckName>.+) --card (?<cardName>.+)$",
            "^deck add-card --side --card (?<cardName>.+) --deck (?<deckName>.+)$"
        };

        // removing cards from deck commands:
        public static String[] removeCardFromMainDeck = new String[] {
            "^deck rm-card --card (?<cardName>.+) --deck (?<deckName>.+)$",
            "^deck rm-card --deck (?<deckName>.+) --card (?<cardName>.+)$",
        };
        public static String[] removeCardFromSideDeck = new String[] {
            // --side at end:
            "^deck rm-card --card (?<cardName>.+) --deck (?<deckName>.+?) --side$",
            "^deck rm-card --deck (?<deckName>.+?) --card (?<cardName>.+) --side$",
            // --side at middle:
            "^deck rm-card --deck (?<deckName>.+) --side --card (?<cardName>.+)$",
            "^deck rm-card --card (?<cardName>.+) --side --deck (?<deckName>.+)$",
            // --side at first:
            "^deck rm-card --side --deck (?<deckName>.+) --card (?<cardName>.+)$",
            "^deck rm-card --side --card (?<cardName>.+) --deck (?<deckName>.+)$"
        };
        // show Deck (main/side):
        public static String showOneMainDeck = "^deck show --deck-name (?<deckName>.+)$";
        public static String[] showOneSideDeck = new String[] {
            "^deck show --deck-name (?<deckName>.+) --side$",
            "^deck show --side --deck-name (?<deckName>.+)$"
        };

    public static String showAllCards = "^deck show --cards$";
    // <- end of DeckMenu commands;


    public static Matcher getMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }

    public static boolean doubleFlagUsing(String command, String word) {
        int counter = 0;
        Matcher matcher = getMatcher(command, word);
        while (matcher.find()) {
            counter++;
        }
        return counter != 1;
    }
}