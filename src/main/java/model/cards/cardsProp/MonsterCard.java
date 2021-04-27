package model.cards.cardsProp;

import model.cards.cardsEnum.Monster.MonsterAttribute;
import model.cards.cardsEnum.Monster.MonsterRace;
import model.cards.cardsEnum.Monster.MonsterType;

import java.util.ArrayList;
import java.util.List;

public class MonsterCard extends Card {
    protected static List<MonsterCard> monsterCards;

    static {
        monsterCards = new ArrayList<>();
    }

    protected int attack;
    protected int defence;
    protected int level;
    protected MonsterType type;
    protected MonsterRace race;
    protected MonsterAttribute attribute;

    public MonsterCard(String name, String level, String attribute, String race, String type,
                       String attack, String defence, String description, String price) {
        super(name, description, price);
        setAttack(Integer.parseInt(attack));
        setDefence(Integer.parseInt(defence));
        setLevel(Integer.parseInt(level));
        setType(MonsterType.assignType(type));
        setRace(MonsterRace.assignRace(race));
        setAttribute(MonsterAttribute.assignAttribute(attribute));
        monsterCards.add(this);
    }

    public MonsterCard(){
    }

    @Override
    public String toString() {
        return super.toString() +
                ", attack=" + attack +
                ", defence=" + defence +
                ", level=" + level +
                ", type=" + type +
                ", race=" + race +
                ", attribute=" + attribute +
                '}';
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public MonsterType getType() {
        return type;
    }

    public void setType(MonsterType type) {
        this.type = type;
    }

    public MonsterRace getRace() {
        return race;
    }

    public void setRace(MonsterRace race) {
        this.race = race;
    }

    public MonsterAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(MonsterAttribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public Card getCopy() {
        MonsterCard copy = new MonsterCard();

        // duplicate block:
        copy.name = this.name;
        copy.description = this.description;
        copy.price = this.price;
        //

        copy.attack = this.attack;
        copy.defence = this.defence;
        copy.type = this.type;
        copy.attribute = this.attribute;
        copy.level = this.level;
        copy.race = this.race;

        return copy;
    }
}
