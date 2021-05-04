package viewer.menudisplay;

import controller.enums.Error;
import controller.enums.MenusMassages.Scoreboard;

public class ScoreboardMenuDisplay {
    public static void display(Scoreboard message) {
            System.out.println(message.getMessage());

    }

    public static void display(Error message) {
            System.out.println(message.getMassage());

    }

    public static void toString(String nickname, int score, int rank) {
        System.out.println(rank + "- " + nickname + ": " + score);
    }
}
