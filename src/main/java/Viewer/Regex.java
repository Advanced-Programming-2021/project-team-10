package Viewer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Regex {
    public static String menuEnter = "menu enter (.+)";
    public static String createUser = "user create --[npu].+";
    public static String username = ".+(?<= )--username (\\S+).*$";
    public static String nickname = ".+(?<= )--nickname (\\S+).*$";
    public static String password = ".+(?<= )--password (\\S+).*$";


    public static Matcher getMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }
}
