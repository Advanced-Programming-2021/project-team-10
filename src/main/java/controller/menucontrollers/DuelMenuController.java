package controller.menucontrollers;

import model.enums.Error;
import model.enums.GameEnums.PlayerTurn;
import model.enums.MenusMassages.Duel;
import model.gameprop.Game;
import model.gameprop.GameInProcess;
import model.gameprop.Player;
import model.userProp.LoginUser;
import model.userProp.User;
import model.userProp.UserInfoType;
import viewer.RockPaperScissorGame;
import viewer.game.GameViewer;
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
        } else if (User.getUserByUserInfo(secondPlayer, UserInfoType.USERNAME) == LoginUser.getUser()) {
            DuelMenuDisplay.display(Duel.CANT_PLAY_WITH_YOURSELF);
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
            Game game = null;
            PlayerTurn firstPlayer = RockPaperScissorGame.run(LoginUser.getUser().getNickname() ,
                    Objects.requireNonNull(User.getUserByUserInfo(secondPlayer, UserInfoType.USERNAME)).getNickname());
            switch (firstPlayer) {
                case PLAYER_ONE: {
                    game = new Game(loggedInPlayer, opponentPlayer);
                    break;
                }
                case PLAYER_TWO: {
                    game = new Game(opponentPlayer, loggedInPlayer);
                }
            }
            GameInProcess.setGame(game);
            GameViewer.run();
        }
    }
}
