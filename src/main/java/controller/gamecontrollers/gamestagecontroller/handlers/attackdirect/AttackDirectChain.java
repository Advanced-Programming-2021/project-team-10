package controller.gamecontrollers.gamestagecontroller.handlers.attackdirect;

import controller.gamecontrollers.gamestagecontroller.handlers.attackdirect.processors.AttackProcessor;
import controller.gamecontrollers.gamestagecontroller.handlers.attackdirect.processors.SelectedCardProcessor;
import model.enums.GameEnums.gamestage.GameMainStage;
import model.gameprop.Player;
import model.gameprop.SelectedCardProp;
import model.gameprop.gamemodel.Game;

public class AttackDirectChain {
    AttackDirectProcessor processor;
    public AttackDirectChain(){
        buildChain();
    }

    private void buildChain (){
        processor = new SelectedCardProcessor(new AttackProcessor(null));
    }

    public String request(Game game){
       return processor.process(game);
    }
}
