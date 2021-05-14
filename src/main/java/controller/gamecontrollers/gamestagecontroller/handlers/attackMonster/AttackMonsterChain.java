package controller.gamecontrollers.gamestagecontroller.handlers.attackMonster;

import controller.gamecontrollers.gamestagecontroller.handlers.attackMonster.processors.AttackProcessor;
import controller.gamecontrollers.gamestagecontroller.handlers.attackMonster.processors.SelectedCardProcessor;
import model.cards.cardsProp.MonsterCard;
import model.enums.GameEnums.GamePhaseEnums.MainPhase;
import model.gameprop.BoardProp.MonsterHouse;
import model.gameprop.SelectedCardProp;
import model.gameprop.gamemodel.Game;

public class AttackMonsterChain {
    AttackMonsterProcessor processor;

    public AttackMonsterChain() {
        buildChain();
    }

    private void buildChain() {
        processor = new SelectedCardProcessor(new AttackProcessor(null));
    }

    public String request(SelectedCardProp cardProp, MonsterHouse monsterHouse, Game game) {
        String message = processor.process(cardProp, monsterHouse, game).toString();
        MonsterCard offensiveCard = (MonsterCard) cardProp.getCard();
        message = modifier(monsterHouse, message, offensiveCard);
        return message;
    }

    private String modifier(MonsterHouse monsterHouse, String message, MonsterCard offensiveCard) {
        int damage;
        if (message.contains("OO_DEFEAT")) {
            damage = monsterHouse.getMonsterCard().getAttack() - offensiveCard.getAttack();
            message = message.replace("OO_DEFEAT",
                    String.valueOf(damage));
        } else if (message.contains("D_DEFEAT")) {
            damage = monsterHouse.getMonsterCard().getDefence() - offensiveCard.getAttack();
            message = message.replace("D_DEFEAT", String.valueOf(damage));
        } else if (message.contains("OO_WIN")) {
            damage = offensiveCard.getAttack() - monsterHouse.getMonsterCard().getAttack();
            message = message.replace("OO_WIN", String.valueOf(damage));
        }
        return message;
    }

}
