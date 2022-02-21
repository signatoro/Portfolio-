package Model;

import Model.Items.HealthPotion;
import Model.Items.ManaPotion;

public interface Potion {

    public static Potion healthPotion = new HealthPotion("Health Potion", "A Red Glimery liquid in a glass Bottle");

    public static Potion manaPotion = new ManaPotion("Mana Potion", "A Glass Vile filled with a dark navy liguid.");

    public int use();

    public Entity clone();
    
    
}

