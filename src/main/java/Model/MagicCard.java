package Model;

import Model.MagicEnum.MagicFamily;
import Model.MagicEnum.MagicSpeed;
import Model.MagicEnum.MagicType;

import java.util.ArrayList;

import static Model.MagicEnum.MagicFamily.setFamily;

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

    public MagicCard(String name, String typeOfMagic, String magicFamily, String description, String speed, String price) {
        super(name, description, price);
        setTypeOfMagic(typeOfMagic);
        setMagicFamily(magicFamily);
        setMagicSpeed(speed);
        magicCards.add(this);
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
