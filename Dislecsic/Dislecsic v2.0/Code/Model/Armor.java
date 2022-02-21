package Model;

import Util.Rarity;

public class Armor extends Entity {

    protected int reductionValue;
    protected Rarity rarity;

    public Armor(String name, String inspect, int armorValue, Rarity rarity) {
        super(name, inspect);
        this.reductionValue = armorValue;
        this.rarity = rarity;

    }

    public Armor(String name, String[] listOfInspect, int reductionValue, Rarity rarity) {
        super(name, listOfInspect);
        this.reductionValue = reductionValue;
        this.rarity = rarity;
    }

    public int getReductionValue() {
        return this.reductionValue;
    }

    public void setReductionValue(int reductionValue) {
        this.reductionValue = reductionValue;
    }
    

    public Rarity getRarity() {
        return this.rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    
}
