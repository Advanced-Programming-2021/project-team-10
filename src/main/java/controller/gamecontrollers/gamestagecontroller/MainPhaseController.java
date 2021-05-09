package controller.gamecontrollers.gamestagecontroller;

import com.sanityinc.jargs.CmdLineParser;
import controller.gamecontrollers.GeneralController;
import model.cards.cardsProp.MagicCard;
import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.CardLocation;
import model.enums.GameEnums.GameError;
import model.enums.GameEnums.SideOfFeature;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.Game;
import model.gameprop.GameInProcess;
import model.gameprop.SelectedCardProp;
import viewer.game.GameDisplay;

public class MainPhaseController extends GeneralController {
    public void run(String command) throws CmdLineParser.OptionException {
        if (!isCommandGeneral(command)) {
            if (command.equals("summon")) {
                summonMonster();
            }
        }
    }

    private void summonMonster() {
        Game game = GameInProcess.getGame();
        SelectedCardProp cardProp = game.getCardProp();
        if (cardProp.getCard() == null) {
            GameDisplay.display(GameError.INVALID_DESELECT_CARD_REQUEST);
        } else if (cardProp.getCard() instanceof MagicCard ||
                cardProp.getLocation().equals(CardLocation.MONSTER_HOUSE)) {
            GameDisplay.display(GameError.CANT_SUMMON);
        } else if (cardProp.getSide().equals(SideOfFeature.OPPONENT)) {
            GameDisplay.display(GameError.OPPONENT_SUMMON_REQUEST);
        } else if (isMonsterHouseFull(game
                .getPlayer(SideOfFeature.CURRENT).getBoard())) {
            GameDisplay.display(GameError.NO_EMPTY_MONSTER_HOUSE);
        } else if (game.isPlayerHireMonster()) {
            GameDisplay.display(GameError.MONSTER_HIRED_BEFORE);
        } else {
            MonsterCard monsterCard = (MonsterCard) cardProp.getCard();
            if (monsterCard.getLevel() < 5) {
                for (MonsterHouse monsterHouse : game.getPlayer(SideOfFeature.CURRENT).getBoard().getMonsterHouse()) {
                    if (monsterHouse.getMonsterCard() == null) {
                        monsterHouse.setMonsterCard(monsterCard);
                        monsterHouse.setState(MonsterHouseVisibilityState.OO);
                    }
                }
            } else {
                System.out.println("higher than level 4 ");
            }
        }
    }

    private boolean isMonsterHouseFull(PlayerBoard board) {
        for (MonsterHouse monsterHouse : board.getMonsterHouse()) {
            if (monsterHouse.getMonsterCard() == null)
                return false;
        }
        return true;
    }
}
