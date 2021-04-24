package Model;

import Model.CardEnum.MagicFamily;
import Model.CardEnum.MagicSpeed;
import Model.CardEnum.MagicType;

import java.util.ArrayList;

import static Model.CardEnum.MagicFamily.setFamily;

public class MagicCard extends Card {
    private static ArrayList<MagicCard> magicCards;

    static {
        magicCards = new ArrayList<>();
    }

    private MagicSpeed magicSpeed;
    private MagicFamily magicFamily;
    private MagicType typeOfMagic;
    private ArrayList<EffectOfMagic> effectsOfMagic;

    {
        effectsOfMagic = new ArrayList<>();
    }

    public MagicCard(String name, String typeOfMagic, String magicFamily, String description, String speed, int price) {
        setName(name);
        setTypeOfMagic(typeOfMagic);
        setMagicFamily(magicFamily);
        setMagicSpeed(speed);
        setPrice(price);
        setDescription(description);
        magicCards.add(this);
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

    private void setName(String name) {
        this.name = name;
    }

    private void setPrice(int price) {
        this.price = price;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public MagicFamily getMagicFamily() {
        return magicFamily;
    }

    public MagicType getTypeOfMagic() {
        return typeOfMagic;
    }

    public MagicSpeed getMagicSpeed() {
        return magicSpeed;
    }
}
