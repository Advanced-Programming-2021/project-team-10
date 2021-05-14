package model.cards.cardsProp;

import model.cards.cardsActions.ActionOfMagic;
import model.cards.cardsActions.magicActionChildren.*;
import model.cards.cardsEnum.Magic.MagicAttribute;
import model.cards.cardsEnum.Magic.MagicSpeed;
import model.cards.cardsEnum.Magic.MagicType;
import model.events.Event;

import java.util.ArrayList;


public class MagicCard extends Card {
    private static final ArrayList<MagicCard> magicCards;

    static {
        magicCards = new ArrayList<>();
    }

    private final ArrayList<ActionOfMagic> actionsOfMagic;
    private final ArrayList<Event> sideEvents;
    private final ArrayList<Event> triggers;
    private MagicSpeed magicSpeed;
    private MagicAttribute magicAttribute;
    private MagicType typeOfMagic;

    {
        actionsOfMagic = new ArrayList<>();
        sideEvents = new ArrayList<>();
        triggers = new ArrayList<>();
    }

    public MagicCard(String name, String typeOfMagic, String magicAttribute, String description, String speed, String price) {
        super(name, description, price);
        setTypeOfMagic(MagicType.setType(typeOfMagic));
        setMagicAttribute(MagicAttribute.setAttribute(magicAttribute));
        setMagicSpeed(MagicSpeed.setSpeed(speed));
        magicCards.add(this);
        setMagicEffect(name);
    }

    private void setMagicEffect(String name) {
        if (name.equals("Monster Reborn") || name.equals("Call of the Haunted")) actionsOfMagic.add(SummonMonsterFromGraveYardAction.getInstance());
        if (name.equals("Terraforming") || name.equals("Pot of Greed") || name.equals("Supply Squad")) actionsOfMagic.add(AddCardFromDeckTOHand.getInstance());
        if (name.equals("Magic Jammer") || name.equals("Magic Cylinder")) actionsOfMagic.add(StoppingActivationAction.getInstance());
        if (name.equals("Advanced Ritual Art")) actionsOfMagic.add(RitualSummonAction.getInstance());
        if (name.equals("Ring of Defense") || name.equals("Negate Attack")) actionsOfMagic.add(MakeDamageZero.getInstance());
        if (name.equals("Mind Crush")) actionsOfMagic.add(GuessingCardInOpponentHandAction.getInstance());
        if (name.equals("Swords of Revealing Light")) actionsOfMagic.add(FlipCardAction.getInstance());
        if (name.equals("Torrential Tribute") || name.equals("Trap Hole") || name.equals("Mirror Force") || name.equals("Mystical space typhoon") || name.equals("Twin Twisters") || name.equals("Dark Hole") || name.equals("Harpie’s Feather Duster") || name.equals("Raigeki")) actionsOfMagic.add(DestroyACardAction.getInstance());
        if (name.equals("Magnum Shield") || name.equals("United We Stand") || name.equals("Black Pendant") || name.equals("Sword of Dark Destruction") || name.equals("Umiiruka") || name.equals("Closed Forest") || name.equals("Forest") || name.equals("Yami")) actionsOfMagic.add(ChangingMonsterAttackAction.getInstance());
        if (name.equals("Spell Absorption")) actionsOfMagic.add(ChangingLifePointAction.getInstance());
        if (name.equals("Change of Heart")) actionsOfMagic.add(ChangeTeamOfMonsterCard.getInstance());
        if (name.equals("Magnum Shield") || name.equals("United We Stand") || name.equals("Sword of Dark Destruction") || name.equals("Umiiruka") || name.equals("Forest") || name.equals("Yami")) actionsOfMagic.add(ChangeDefenceOfMonsterCard.getInstance());
        if (name.equals("Solemn Warning")) actionsOfMagic.add(CancelSummon.getInstance());
        if (name.equals("Time Seal")) actionsOfMagic.add(AvoidOpponentsCardDraw.getInstance());
        if (name.equals("Messenger of peace")) actionsOfMagic.add(AvoidAttackOfMonsters.getInstance());
        if (name.equals("Negate Attack")) actionsOfMagic.add(EndBattlePhaseAction.getInstance());
    }

    public MagicCard() {
        super();
    }

    @Override
    public String getCardDetail() {
        return
                "Name: " + name +
                        "\n" + typeOfMagic.toString() +
                        "\nType: " + magicAttribute +
                        "\nDescription: " + description;
    }

    public MagicAttribute getMagicAttribute() {
        return magicAttribute;
    }

    private void setMagicAttribute(MagicAttribute magicAttribute) {
        this.magicAttribute = magicAttribute;
    }

    public MagicType getTypeOfMagic() {
        return typeOfMagic;
    }

    private void setTypeOfMagic(MagicType typeOfMagic) {
        this.typeOfMagic = typeOfMagic;
    }

    public MagicSpeed getMagicSpeed() {
        return magicSpeed;
    }

    public void setMagicSpeed(MagicSpeed magicSpeed) {
        this.magicSpeed = magicSpeed;
    }

    @Override
    public Card getCopy() {
        MagicCard copy = new MagicCard();

        // semi duplicate block:
        copy.name = this.name;
        copy.description = this.description;
        copy.price = this.price;
        //

        copy.setMagicSpeed(this.magicSpeed);
        copy.setTypeOfMagic(this.typeOfMagic);
        copy.setMagicAttribute(this.magicAttribute);

        return copy;
    }
}
