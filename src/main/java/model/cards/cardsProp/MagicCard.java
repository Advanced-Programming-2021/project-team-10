package model.cards.cardsProp;

import model.cards.cardsActions.ActionOfMagic;
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

    private final ArrayList<ActionOfMagic> effectsOfMagic;
    private final ArrayList<Event> sideEvents;
    private final ArrayList<Event> triggers;
    private MagicSpeed magicSpeed;
    private MagicAttribute magicAttribute;
    private MagicType typeOfMagic;

    {
        effectsOfMagic = new ArrayList<>();
        sideEvents = new ArrayList<>();
        triggers = new ArrayList<>();
    }

    public MagicCard(String name, String typeOfMagic, String magicAttribute, String description, String speed, String price) {
        super(name, description, price);
        setTypeOfMagic(MagicType.setType(typeOfMagic));
        setMagicAttribute(MagicAttribute.setAttribute(magicAttribute));
        setMagicSpeed(MagicSpeed.setSpeed(speed));
        magicCards.add(this);
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
    public void activeEffectsByEvent(Event event) {
        for (Event mainEvent : triggers) {
            if (mainEvent.equals(event)) {

            }
        }
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
