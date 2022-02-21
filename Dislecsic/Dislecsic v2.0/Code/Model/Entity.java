package Model;

import Util.Rng;

public class Entity {



    //Variable
    protected String name;
    protected String inspect;

    protected int indexLastPicked = 0;
    
    //Lists
    protected String[] listOfInspect;

    public Entity(String name, String inspect) {
        this.name = name;
        this.inspect = inspect;
        this.listOfInspect = null;
    }

    public Entity (String name, String[] listOfInspect) {
        this.name = name;
        this.inspect = null;
        this.listOfInspect = listOfInspect;
        
    }


    protected String getRandomString(String[] listOf) {
        int num = Rng.rangeInt(0, (listOf.length - 1));
        if (num != indexLastPicked){
            this.indexLastPicked = num;
            return listOf[num];
        }
        else if (num == (listOf.length - 1)) {
            num--;
            this.indexLastPicked = num;
            return listOf[num];
        }
        else {
            num++;
            this.indexLastPicked = num;
            return listOf[num];
        }
    }

    public Entity clone() {
        if (listOfInspect != null) {
            return new Entity(name, listOfInspect);
        }
        else {
            return new Entity(name, inspect);
        }
    }

    
    public String getName() {
        return name;
    }

    public String printInspect() throws Exception {
        if (inspect != null) {
            return inspect;
        }
        else if (listOfInspect != null) {
            return getRandomString(listOfInspect);
        }
        else {
            throw new Exception("Entity:printInspect: Both are null. not good");
        }
    }
}
