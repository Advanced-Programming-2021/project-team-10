package controller.gamecontrollers.gamestagecontroller;

import controller.gamecontrollers.GeneralController;
import controller.gamecontrollers.gamestagecontroller.handlers.attackMonster.AttackMonsterChain;
import model.enums.GameEnums.SideOfFeature;
import model.enums.GameEnums.cardvisibility.MonsterHouseVisibilityState;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.GameInProcess;
import model.gameprop.gamemodel.Game;

public class BattlePhaseController extends GeneralController {
    private static BattlePhaseController instance;

    public static BattlePhaseController getInstance() {
        if (instance == null) instance = new BattlePhaseController();
        return instance;
    }

    private BattlePhaseController(){
    }
    public String run(String command) {
        Game game = GameInProcess.getGame();
        if (command.equals("attack direct")) {
            return "will write it soon";
        } else if (command.startsWith("attack ")) {
            int address = Character.getNumericValue(command.charAt(7));
            return attackMonsterHouse(game,
                    game.getPlayer(SideOfFeature.OPPONENT).getBoard().getMonsterHouse()[address - 1]);
        }
        return null;
    }


    private String attackMonsterHouse(Game game, MonsterHouse target) {
        AttackMonsterChain chain = new AttackMonsterChain();
        StringBuilder stringBuilder = new StringBuilder();
        if (target.getState().equals(MonsterHouseVisibilityState.DH)) {
            stringBuilder.append("the hidden defence revealed : ").append(target.getMonsterCard().getName()).append("\n");
        }
        stringBuilder.append(chain.request(game.getCardProp(), target, game));
        return stringBuilder.toString();
    }
}
