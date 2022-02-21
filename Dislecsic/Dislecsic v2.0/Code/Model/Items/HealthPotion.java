package Model.Items;

import Model.Entity;
import Model.Potion;

public class HealthPotion extends Entity implements Potion {

    public HealthPotion(String name, String inspect) {
        super(name, inspect);
        //TODO Auto-generated constructor stub
    }

    public HealthPotion(String name, String[] listOfInspect) {
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
