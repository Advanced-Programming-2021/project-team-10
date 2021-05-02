package viewer;

import controller.enums.Error;
import controller.enums.MenusMassages.Scoreboard;

public class ScoreboardMenuDisplay {
    public static void display(Enum message) {
        if (message instanceof Scoreboard) {
            System.out.println(((Scoreboard) message).getMessage());
        } else if (message instanceof Error) {
            System.out.println(((Error) message).getMassage());
        } else {
            System.out.println("invalid enum type");
        }
    }

    public static void toString(String nickname, int score, int rank) {
        System.out.println(rank + "- " + nickname + ": " + score);
    }
}
