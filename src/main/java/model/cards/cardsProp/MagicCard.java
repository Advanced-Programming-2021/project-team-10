package model.cards.cardsProp;

import model.cards.cardsEnum.Magic.MagicAttribute;
import model.cards.cardsEnum.Magic.MagicSpeed;
import model.cards.cardsEnum.Magic.MagicType;
import model.cards.cardsEffect.EffectOfMagic;

import java.util.ArrayList;


public class MagicCard extends Card {
    private static final ArrayList<MagicCard> magicCards;

    static {
        magicCards = new ArrayList<>();
    }

    private MagicSpeed magicSpeed;
    private MagicAttribute magicAttribute;
    private MagicType typeOfMagic;
    private final ArrayList<EffectOfMagic> effectsOfMagic;

    {
        effectsOfMagic = new ArrayList<>();
    }

    public MagicCard(String name, String typeOfMagic, String magicAttribute, String description, String speed, String price) {
        super(name, description, price);
        setTypeOfMagic(MagicType.setType(typeOfMagic));
        setMagicAttribute(MagicAttribute.setAttribute(magicAttribute));
        setMagicSpeed(MagicSpeed.setSpeed(speed));
        magicCards.add(this);
    }

    public MagicCard(){
        super();
    }

    @Override
    public String toString() {
        return super.toString() +
                "magicSpeed=" + magicSpeed +
                ", magicFamily=" + magicAttribute +
                ", typeOfMagic=" + typeOfMagic +
                ", effectsOfMagic=" + effectsOfMagic +
                '}';
    }

    public void setMagicSpeed(MagicSpeed magicSpeed) {
        this.magicSpeed = magicSpeed;
    }

    private void setMagicAttribute(MagicAttribute magicAttribute) {
        this.magicAttribute = magicAttribute;
    }

    private void setTypeOfMagic(MagicType typeOfMagic) {
        this.typeOfMagic = typeOfMagic;
    }

    public MagicAttribute getMagicAttribute() {
        return magicAttribute;
    }

    public MagicType getTypeOfMagic() {
        return typeOfMagic;
    }

    public MagicSpeed getMagicSpeed() {
        return magicSpeed;
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
        copy.setMagicSpeed(this.magicSpeed);
        copy.setMagicAttribute(this.magicAttribute);

        return copy;
    }
}
