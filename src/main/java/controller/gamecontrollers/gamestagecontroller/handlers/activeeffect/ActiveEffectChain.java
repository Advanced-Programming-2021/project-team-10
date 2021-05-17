package controller.gamecontrollers.gamestagecontroller.handlers.activeeffect;

import model.gameprop.gamemodel.Game;

public class ActiveEffectChain {
    ActiveEffectProcessor processor;

    public ActiveEffectChain() {
        buildChain();
    }

    private void buildChain() {

    }

    public String request(Game game) {
        return processor.process(game);
    }
}
