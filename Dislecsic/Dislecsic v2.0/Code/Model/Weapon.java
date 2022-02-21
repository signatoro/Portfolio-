package Model;

import Util.Rarity;
import Util.Rng;

public class Weapon extends Entity {

    protected Rarity rarity;
    protected int bonusToHit;

    // Arrays
    protected int[] damageRange;
    protected String[] hitResponces;
    protected String[] missResponces;

    public Weapon(String name, String inspect, Rarity rarity, int bonusToHit, int[] damageRange, String[] hitResponces, String[] missReponces) throws IllegalArgumentException {
        super(name, inspect);
        if (damageRange.length != 2) {
            throw new IllegalArgumentException("Damage Array is not the correct Size.");
        }
        

        this.rarity = rarity;
        this.bonusToHit = bonusToHit;
        this.damageRange = damageRange;
        this.hitResponces = hitResponces;
        this.missResponces = missReponces;
    }

    public Weapon(String name, String[] listOfInspect, Rarity rarity, int bonusToHit, int[] damageRange, String[] hitResponces, String[] missReponces) {
        super(name, listOfInspect);
        if (damageRange.length != 2) {
            throw new IllegalArgumentException("Damage Array is not the correct Size.");
        }

        this.rarity = rarity;
        this.bonusToHit = bonusToHit;
        this.damageRange = damageRange;
        this.hitResponces = hitResponces;
        this.missResponces = missReponces;
    }


    public Rarity getRarity() {
        return this.rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }


    public int getBonusToHit() {
        return this.bonusToHit;
    }

    public void setBonusToHit(int bonusToHit) {
        this.bonusToHit = bonusToHit;
    }


    public int[] getDamageRange() {
        return this.damageRange;
    }

    public void setDamageRange(int[] damageRange) throws IllegalArgumentException {
        if (damageRange.length != 2) {
            throw new IllegalArgumentException("Damage Array is not the correct Size.");
        }

        this.damageRange = damageRange;
    }

    
    public String[] getHitResponces() {
        return this.hitResponces;
    }

    public void setHitResponces(String[] hitResponces) {
        this.hitResponces = hitResponces;
    }

    
    public String[] getMissResponces() {
        return this.hitResponces;
    }

    public void setMissResponces(String[] hitResponces) {
        this.hitResponces = hitResponces;
    }


    



    public int attack() {
        int damage = 0;

        damage += Rng.rangeInt(damageRange[0], damageRange[1]);

        return damage;
    }


    public void upgrade(int bonusDifference, int[] damageDifference) {
        this.setBonusToHit(this.bonusToHit + bonusDifference);
        int[] temp = new int[2];
        temp[0] = this.damageRange[0] + damageDifference[0];
        temp[1] =  this.damageRange[1] + damageDifference[1];
        this.setDamageRange(temp);

    }

    public String printHitMessage() {
        return super.getRandomString(hitResponces);
    }

    public String printMissMessage() {
        return super.getRandomString(missResponces);
    }
}
