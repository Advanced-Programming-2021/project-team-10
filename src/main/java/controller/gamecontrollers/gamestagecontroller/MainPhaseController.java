package controller.gamecontrollers.gamestagecontroller;

import com.sanityinc.jargs.CmdLineParser;
import controller.gamecontrollers.GeneralController;
import controller.gamecontrollers.gamestagecontroller.handlers.changeposition.ChangePosChain;
import controller.gamecontrollers.gamestagecontroller.handlers.flipsummon.FlipSummonChain;
import controller.gamecontrollers.gamestagecontroller.handlers.hiremonster.HireMonsterChain;
import model.cards.cardsProp.MagicCard;
import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.enums.GameEnums.SideOfFeature;
import model.enums.GameEnums.TypeOfHire;
import model.enums.GameEnums.WantedPos;
import model.enums.GameEnums.cardvisibility.MagicHouseVisibilityState;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;
import model.enums.GameEnums.gamestage.GameMainStage;
import model.enums.GameEnums.gamestage.GameSideStage;
import model.gameprop.BoardProp.MagicHouse;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.GameInProcess;
import model.gameprop.SelectedCardProp;
import model.gameprop.gamemodel.Game;

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
        if (game.getGameSideStage().equals(GameSideStage.NONE)) {
            if (game.getGameMainStage().equals(GameMainStage.FIRST_MAIN_PHASE) ||
                    game.getGameMainStage().equals(GameMainStage.SECOND_MAIN_PHASE)) {
                if (command.equals("summon")) {
                    return hireMonster(game, TypeOfHire.SUMMON);
                } else if (command.equals("set")) {
                    return hireMonster(game, TypeOfHire.SET);
                } else if (command.startsWith("set --position")) {
                    MonsterHouse hiredMonsterHouse = game.getHiredMonster();
                    return changePosition(game.getCardProp(), command, hiredMonsterHouse);
                } else if (command.equals("flip-summon")) {
                    return flipSummon(game);
                }
            } else {
                return "you can’t do this action in this phase";
            }
        } else return "back to game first";
        return null;
    }

    private String hireMonster(Game game, TypeOfHire type) {
        SelectedCardProp cardProp = game.getCardProp();
        HireMonsterChain chain = new HireMonsterChain();
        MainPhase error;
        if ((error = chain.request(game)) != null) {
            return error.toString();
        }


        if (cardProp.getCard() instanceof MonsterCard) {
            MonsterCard monsterCard = (MonsterCard) cardProp.getCard();
            if (monsterCard.getLevel() < 5) {
                for (MonsterHouse monsterHouse : game.getPlayer(SideOfFeature.CURRENT).getBoard().getMonsterHouse()) {
                    if (monsterHouse.getMonsterCard() == null) {
                        monsterHouse.setMonsterCard(monsterCard);
                        if (type.equals(TypeOfHire.SUMMON)) monsterHouse.setState(MonsterHouseVisibilityState.OO);
                        else monsterHouse.setState(MonsterHouseVisibilityState.DH);
                        game.setHiredMonster(monsterHouse);
                        game.setCardProp(null);
                        game.getPlayer(SideOfFeature.CURRENT).getBoard().getPlayerHand().remove(monsterCard);
                        if (type.equals(TypeOfHire.SUMMON)) return MainPhase.SUMMONED_SUCCESSFULLY.toString();
                        else return MainPhase.SET_SUCCESSFULLY.toString();
                    }
                }
            } else {
                game.setTypeOfMonsterHire(type);
                if (monsterCard.getLevel() < 7) {
                    if (game.getPlayer(SideOfFeature.CURRENT).getBoard().numberOfFullHouse("monster") < 1)
                        return MainPhase.TRIBUTE_NOT_POSSIBLE.toString();
                    game.setTributeSize(1);
                    game.setGameSideStage(GameSideStage.TRIBUTE);
                    return MainPhase.ONE_TRIBUTE_NEED.toString();
                } else {
                    if (game.getPlayer(SideOfFeature.CURRENT).getBoard().numberOfFullHouse("monster") < 2)
                        return MainPhase.TRIBUTE_NOT_POSSIBLE.toString();
                    game.setTributeSize(2);
                    game.setGameSideStage(GameSideStage.TRIBUTE);
                    return MainPhase.TW0_TRIBUTE_NEED.toString();
                }
            }
        } else if (cardProp.getCard() instanceof MagicCard) {
            MagicCard magicCard =(MagicCard) cardProp.getCard();
            if (type.equals(TypeOfHire.SUMMON)) {
                return MainPhase.CANT_SUMMON_MAGIC.toString();
            } else {
                for (MagicHouse magicHouse : game.getPlayer(SideOfFeature.CURRENT).getBoard().getMagicHouse()) {
                    if (magicHouse.getMagicCard() == null) {
                        magicHouse.setMagicCard(magicCard);
                        magicHouse.setState(MagicHouseVisibilityState.H);
                        game.setCardProp(null);
                        game.getPlayer(SideOfFeature.CURRENT).getBoard().getPlayerHand().remove(magicCard);
                        return MainPhase.SET_SUCCESSFULLY.toString();
                    }
                }
            }
        }

        return null;
    }

    private String changePosition(SelectedCardProp cardProp, String command, MonsterHouse hiredMonsterHouse) {
        ChangePosChain chain = new ChangePosChain();
        if (command.contains("attack")) {
            return chain.request(cardProp, WantedPos.ATTACK, hiredMonsterHouse).toString();
        } else {
            return chain.request(cardProp, WantedPos.DEFENCE, hiredMonsterHouse).toString();
        }
    }

    private String flipSummon(Game game) {
        FlipSummonChain chain = new FlipSummonChain();
        return chain.request(game.getCardProp(), game).toString();
    }

}
