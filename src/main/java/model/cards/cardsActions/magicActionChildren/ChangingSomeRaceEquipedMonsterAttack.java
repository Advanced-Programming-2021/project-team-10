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

import java.util.ArrayList;

public class ChangingSomeRaceEquipedMonsterAttack extends ActionOfMagic {
    private final ArrayList<String> typesToChangeAttack;
    private final int changeAttack;
    private final int addOrMinus;
    private MonsterCard equipedMonster;

    {
        name = this.getClass().getSimpleName();
    }

    public ChangingSomeRaceEquipedMonsterAttack(int changeAttack, int addOrMinus, ArrayList<String> typesToChangeAttack) {
        this.changeAttack = changeAttack;
        this.addOrMinus = addOrMinus;
        this.typesToChangeAttack = typesToChangeAttack;
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
        if (typesToChangeAttack.contains(equipedMonster.getRace().toString())) {
            int attack = equipedMonster.getAttack();
            attack += changeAttack * addOrMinus;
            equipedMonster.setAttack(attack);
            isActivatedBefore = true;
        }
        isActivatedBefore = true;
    }
}
