package Viewer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Regex {
    public static String menuEnter = "menu enter (.+)";
    public static String createUser = "user create --[npu].+";
    public static String username = ".+(?<= )--username (\\S+)(?= --nickname.*| --password.*|$).*$";
    public static String nickname = ".+(?<= )--nickname (\\S+)(?= --username.*| --password.*|$).*$";
    public static String password = ".+(?<= )--password (\\S+)(?= --nickname.*| --username.*|$).*$";
    public static String profileChange = "profile change (.*)";
    public static String changeNickname = "profile change --nickname (.*)";
    public static String changePassword = ".+(?<= |^)--password(?= --current.*| --new.*|$).*$";
    public static String currentPassword = ".+(?<= |^)--current (\\S+)(?= --password| --new.*|$).*$";
    public static String newPassword = ".+(?<= |^)--new (\\S+)(?= --password| --current.*|$).*$";


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
