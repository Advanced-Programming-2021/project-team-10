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

    public MonsterCard getEquipedMonster() {
        return equipedMonster;
    }

    @Override
    public void active() {
        equipedMonster = ActionOfMagic.equipAMonsterWithSpell(this);

        int attack = equipedMonster.getAttack();
        attack += changeAttack * addOrMinus;
        equipedMonster.setAttack(attack);
        isActivatedBefore = true;
    }
}
