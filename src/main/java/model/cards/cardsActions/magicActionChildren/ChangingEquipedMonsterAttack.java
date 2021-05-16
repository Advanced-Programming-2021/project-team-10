package model.cards.cardsActions.magicActionChildren;

import controller.gamecontrollers.GetStringInputFromView;
import exceptions.CardNotFoundException;
import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsProp.MagicCard;
import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.RequestingInput;
import model.enums.GameEnums.SideOfFeature;
import model.gameprop.BoardProp.PlayerBoard;
import model.gameprop.GameInProcess;

public class ChangingEquipedMonsterAttack extends ActionOfMagic {
    private MonsterCard equipedMonster;
    private final int changeAttack;
    private final int addOrMinus;

    {
        name = this.getClass().getSimpleName();
        equipedMonster = null;
        isActivatedBefore = false;
    }

    public ChangingEquipedMonsterAttack(int changeAttack, int addOrMinus) {
        this.addOrMinus = addOrMinus;
        this.changeAttack = changeAttack;
    }

    @Override
    public void active() {
        if (equipedMonster == null) {
            String nameOfMonster = GetStringInputFromView.getInputFromView(RequestingInput.SET_EQUIPED_MONSTER);
            PlayerBoard currentPlayerboard = GameInProcess.getGame().getPlayer(SideOfFeature.CURRENT).getBoard();
            try {
                equipedMonster = currentPlayerboard.getMonsterCardByName(nameOfMonster);
                equipedMonster.setEquippedWith((MagicCard) GameInProcess.getGame().getCardProp().getCard());
            } catch (CardNotFoundException e) {
                active();
            }
        }
        int attack = equipedMonster.getAttack();
        attack += changeAttack * addOrMinus;
        equipedMonster.setAttack(attack);
        isActivatedBefore = true;
    }
}
