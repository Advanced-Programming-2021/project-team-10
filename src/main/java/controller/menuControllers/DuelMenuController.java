package controller.menuControllers;

import controller.enums.Error;
import controller.enums.MenusMassages.Duel;
import model.userProp.LoginUser;
import model.userProp.User;
import model.userProp.UserInfoType;
import viewer.display.DuelMenuDisplay;

import java.util.Objects;

public class DuelMenuController {
    public static void invalidCommand() {
        DuelMenuDisplay.display(Error.INVALID_COMMAND);
    }

    public static void showCurrentMenu() {
        DuelMenuDisplay.display(Duel.CURRENT_MENU);
    }

    public static void makeNewDuel(String rounds, String secondPlayer) {
        if (User.getUserByUserInfo(secondPlayer, UserInfoType.USERNAME) == null) {
            DuelMenuDisplay.display(Duel.INVALID_SECOND_PLAYER);
        } else if (LoginUser.getUser().getActiveDeck() == null) {
            DuelMenuDisplay.display(Duel.NO_ACTIVE_DECK, LoginUser.getUser().getUsername());
        } else if (Objects.requireNonNull(User.getUserByUserInfo(secondPlayer, UserInfoType.USERNAME)).getActiveDeck() == null) {
            DuelMenuDisplay.display(Duel.NO_ACTIVE_DECK, secondPlayer);
        } else if (!LoginUser.getUser().getActiveDeck().getValidity()) {
            DuelMenuDisplay.display(Duel.INVALID_ACTIVE_DECK, LoginUser.getUser().getUsername());
        } else if (!Objects.requireNonNull(User.getUserByUserInfo(secondPlayer, UserInfoType.USERNAME)).getActiveDeck().getValidity()) {
            DuelMenuDisplay.display(Duel.INVALID_ACTIVE_DECK, secondPlayer);
        } else if (!rounds.equals("1") && !rounds.equals("3")) {
            DuelMenuDisplay.display(Duel.INVALID_NUMBER_OF_ROUNDS);
        }
    }
}
