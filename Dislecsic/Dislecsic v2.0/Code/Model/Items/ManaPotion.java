package Model.Items;

import Model.Entity;
import Model.Potion;
import Model.Depreciated.Enemies;

public class ManaPotion extends Entity implements Potion {

    public ManaPotion(String name, String inspect) {
        super(name, inspect);
    }

    public ManaPotion(String name, String[] listOfInspect) {
        super(name, listOfInspect);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int use() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Entity clone() {
        if (super.listOfInspect != null) {
            return new HealthPotion(name, super.listOfInspect);
        }
        else {
            return new HealthPotion(name, inspect);
        }
    }

    
}
