package controller.menucontrollers;

import controller.enums.Error;
import controller.enums.MenusMassages.Duel;
import controller.enums.GameEnums.PlayerTurn;
import model.gameprop.Game;
import model.gameprop.Player;
import model.userProp.LoginUser;
import model.userProp.User;
import model.userProp.UserInfoType;
import viewer.game.GameViewer;
import viewer.RockPaperScissorGame;
import viewer.menudisplay.DuelMenuDisplay;

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
        } else if (Objects.requireNonNull(User.getUserByUserInfo(secondPlayer, UserInfoType.USERNAME)).
                getActiveDeck() == null) {
            DuelMenuDisplay.display(Duel.NO_ACTIVE_DECK, secondPlayer);
        } else if (!LoginUser.getUser().getActiveDeck().getValidity()) {
            DuelMenuDisplay.display(Duel.INVALID_ACTIVE_DECK, LoginUser.getUser().getUsername());
        } else if (!Objects.requireNonNull(User.getUserByUserInfo(secondPlayer, UserInfoType.USERNAME)).
                getActiveDeck().getValidity()) {
            DuelMenuDisplay.display(Duel.INVALID_ACTIVE_DECK, secondPlayer);
        } else if (!rounds.equals("1") && !rounds.equals("3")) {
            DuelMenuDisplay.display(Duel.INVALID_NUMBER_OF_ROUNDS);
        } else {
            Player loggedInPlayer = new Player(LoginUser.getUser());
            Player opponentPlayer = new Player(User.getUserByUserInfo(secondPlayer, UserInfoType.USERNAME));
            Game game = new Game();
            PlayerTurn firstPlayer = RockPaperScissorGame.run();
            switch (firstPlayer) {
                case PLAYER_ONE: {
                    game.setFirstPlayer(loggedInPlayer);
                    game.setSecondPlayer(opponentPlayer);
                    break;
                }
                case PLAYER_TWO: {
                    game.setFirstPlayer(opponentPlayer);
                    game.setSecondPlayer(loggedInPlayer);
                }
            }
            GameViewer.run(game);
        }
    }
}
