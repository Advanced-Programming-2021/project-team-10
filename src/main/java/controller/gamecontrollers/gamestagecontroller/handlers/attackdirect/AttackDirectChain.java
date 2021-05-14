package controller.gamecontrollers.gamestagecontroller.handlers.attackdirect;

import controller.gamecontrollers.gamestagecontroller.handlers.attackdirect.processors.AttackProcessor;
import controller.gamecontrollers.gamestagecontroller.handlers.attackdirect.processors.SelectedCardProcessor;
import model.gameprop.Player;
import model.gameprop.SelectedCardProp;

public class AttackDirectChain {
    AttackDirectProcessor processor;
    public AttackDirectChain(){
        buildChain();
    }

    private void buildChain (){
        processor = new SelectedCardProcessor(new AttackProcessor(null));
    }

    public String request(SelectedCardProp cardProp , Player target){
       return processor.process(cardProp , target);
    }
}
