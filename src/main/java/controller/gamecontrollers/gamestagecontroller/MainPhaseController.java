package controller.gamecontrollers.gamestagecontroller;

import com.sanityinc.jargs.CmdLineParser;
import controller.gamecontrollers.GeneralController;
import controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.HireMonsterChain;
import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.SideOfFeature;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.Game;
import model.gameprop.GameInProcess;
import model.gameprop.SelectedCardProp;

public class MainPhaseController extends GeneralController {
    private static MainPhaseController instance;

    private MainPhaseController() {
    }

    public static MainPhaseController getInstance() {
        if (instance == null) instance = new MainPhaseController();
        return instance;
    }

    public String run(String command) throws CmdLineParser.OptionException {
        Game game = GameInProcess.getGame();
        if (command.equals("summon")) {
            return hireMonster(game, HireType.SUMMON);
        } else if (command.equals("set")) {
            return hireMonster(game, HireType.SET);
        }
        return null;
    }

    private String hireMonster(Game game, HireType type) {
        SelectedCardProp cardProp = game.getCardProp();
        HireMonsterChain chain = new HireMonsterChain();
        MainPhase error;
        if ((error = chain.request(game)) != null) {
            return error.toString();
        }

        MonsterCard monsterCard = (MonsterCard) cardProp.getCard();
        if (monsterCard.getLevel() < 5) {
            for (MonsterHouse monsterHouse : game.getPlayer(SideOfFeature.CURRENT).getBoard().getMonsterHouse()) {
                if (monsterHouse.getMonsterCard() == null) {
                    monsterHouse.setMonsterCard(monsterCard);
                    if (type.equals(HireType.SUMMON)) monsterHouse.setState(MonsterHouseVisibilityState.OO);
                    else monsterHouse.setState(MonsterHouseVisibilityState.DH);
                    game.setIsMonsterHired();
                    game.setCardProp(null);
                    game.getPlayer(SideOfFeature.CURRENT).getBoard().getPlayerHand().remove(monsterCard);
                    if (type.equals(HireType.SUMMON)) return MainPhase.SUMMONED_SUCCESSFULLY.toString();
                    else return MainPhase.SET_SUCCESSFULLY.toString();
                }
            }
        } else {
            return "higher than level 4";
        }

        return null;
    }

    enum HireType {
        SUMMON,
        SET
    }

}
