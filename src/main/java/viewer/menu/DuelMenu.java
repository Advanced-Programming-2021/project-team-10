package viewer.menu;

import controller.ImportScanner;
import model.enums.MenusMassages.Duel;
import controller.menucontrollers.DuelMenuController;
import viewer.Regex;
import viewer.menudisplay.DuelMenuDisplay;

import java.util.regex.Matcher;

public class DuelMenu {
    private static DuelMenu duelMenu;

    public static DuelMenu getInstance() {
        if (duelMenu == null) {
            duelMenu = new DuelMenu();
        }
        return duelMenu;
    }

    public void run() {
        String command;
        while (true) {
            command = ImportScanner.getInput();
            if (command.equals("menu exit")) {
                break;
            }
            recognizeCommand(command);
        }
        DuelMenuDisplay.display(Duel.SUCCESSFULLY_EXIT_MENU);
    }

    private void recognizeCommand(String command) {
        Matcher matcher = Regex.getMatcher(command, Regex.duel), matcherNew =
                Regex.getMatcher(command, Regex.duelNew), matcherRound =
                Regex.getMatcher(command, Regex.rounds), matcherSecondPlayer =
                Regex.getMatcher(command, Regex.secondPlayer);
        if (command.equals("menu show-current")) {
            DuelMenuController.showCurrentMenu();
        } else if (matcher.matches() && matcherNew.matches() && matcherRound.matches() && matcherSecondPlayer.matches()) {
            String secondPlayer = matcherSecondPlayer.group(1);
            String rounds = matcherRound.group(1);
            DuelMenuController.makeNewDuel(rounds, secondPlayer);
        } else {
            DuelMenuController.invalidCommand();
        }
    }
}
