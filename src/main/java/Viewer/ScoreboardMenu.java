package Viewer;

import Controller.Enums.MenusMassages.Scoreboard;
import Controller.ImportScanner;
import Controller.ScoreboardMenuController;

public class ScoreboardMenu {
    private static ScoreboardMenu scoreboardMenu;

    public void run() {
        String command;
        while (true) {
            command = ImportScanner.getInput();
            if (command.equals("menu exit")) {
                break;
            }
            recognizeCommand(command);
        }
        ScoreboardMenuDisplay.display(Scoreboard.SUCCESSFULLY_EXIT_MENU);
    }

    public static ScoreboardMenu getInstance() {
        if (scoreboardMenu == null) {
            scoreboardMenu = new ScoreboardMenu();
        }
        return scoreboardMenu;
    }

    private static void recognizeCommand(String command) {
        if (command.equals("menu show-current")) {
            ScoreboardMenuController.showCurrentMenu();
        }
        else if (command.equals("scoreboard show")) {
            ScoreboardMenuController.showScoreboard();
        }
        else {
            ScoreboardMenuController.invalidCommand();
        }
    }
}
