package model.cards.cardsProp;

import model.cards.cardsEnum.Magic.MagicAttribute;
import model.cards.cardsEnum.Magic.MagicSpeed;
import model.cards.cardsEnum.Magic.MagicType;
import model.cards.cardsEffect.EffectOfMagic;

import java.util.ArrayList;

import static model.cards.cardsEnum.Magic.MagicAttribute.setFamily;

public class MagicCard extends Card {
    private static ArrayList<MagicCard> magicCards;

    static {
        magicCards = new ArrayList<>();
    }

    private MagicSpeed magicSpeed;
    private MagicAttribute magicFamily;
    private MagicType typeOfMagic;
    private ArrayList<EffectOfMagic> effectsOfMagic;

    {
        effectsOfMagic = new ArrayList<>();
    }

    public MagicCard(String name, String typeOfMagic, String magicFamily, String description, String speed, String price) {
        super(name, description, price);
        setTypeOfMagic(typeOfMagic);
        setMagicFamily(magicFamily);
        setMagicSpeed(speed);
        magicCards.add(this);
    }

    public MagicCard(){
        super();
    }

    @Override
    public String toString() {
        return super.toString() +
                "magicSpeed=" + magicSpeed +
                ", magicFamily=" + magicFamily +
                ", typeOfMagic=" + typeOfMagic +
                ", effectsOfMagic=" + effectsOfMagic +
                '}';
    }

    public void setMagicSpeed(String magicSpeed) {
        this.magicSpeed = MagicSpeed.setSpeed(magicSpeed);
    }

    private void setMagicFamily(String magicFamily) {
        this.magicFamily = setFamily(magicFamily);
    }

    private void setTypeOfMagic(String typeOfMagic) {
        this.typeOfMagic = MagicType.setType(typeOfMagic);
    }

    public MagicAttribute getMagicFamily() {
        return magicFamily;
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

        // duplicate block:
        copy.name = this.name;
        copy.description = this.description;
        copy.price = this.price;
        //

        copy.typeOfMagic = this.typeOfMagic;
        copy.magicSpeed = this.magicSpeed;
        copy.magicFamily = this.magicFamily;

        return copy;
    }
}
