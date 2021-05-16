package model.cards.cardsActions.magicActionChildren;

import controller.gamecontrollers.gamestagecontroller.DrawPhaseController;
import model.cards.cardsActions.ActionOfMagic;
import model.gameprop.gamemodel.Game;

public class DrawCardFromTopOfDeck extends ActionOfMagic {
    int numOfDraws;

    {
        name = this.getClass().getSimpleName();
    }

    public DrawCardFromTopOfDeck(int numOfDraws){
        this.numOfDraws = numOfDraws;
    }

    @Override
    public void active(Game game) {
        for (int i = 0; i < numOfDraws; i++) {
            (DrawPhaseController.getInstance()).draw();
        }
    }
}
