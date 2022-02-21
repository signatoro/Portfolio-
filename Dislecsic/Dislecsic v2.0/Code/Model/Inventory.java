package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Inventory {


    // List
    private final int size;
    private HashMap<String, Entity> listOfEntity; 

    public Inventory(int size) {
        this.listOfEntity = new HashMap<String, Entity>();
        this.size = size;

    }

    public int getSize() {
        return size;
    }


    public Entity getEntity(String entityName) throws Exception {
        if (this.listOfEntity.get(entityName) != null){
            return this.listOfEntity.get(entityName);
        }
        else {
            throw new Exception("Inventory:getEntity: That is not the name of an entity in this inventory.");
        }
    }

    public Entity getEntity(int index) throws Exception{
        int counter = 0;
        for (Map.Entry<String, Entity> entry : listOfEntity.entrySet()) {
            if(counter == index-1) {
                System.out.println(entry.getKey() + " " + entry.getValue());
                return entry.getValue();
            }
        }
        throw new Exception("Entity:getEntity: Out of index");
    }


    
    public void addEntity(Entity entity) throws Exception {
        if (listOfEntity.size() != size) {
            this.listOfEntity.put(entity.getName(), entity);
            return;
        } 
        else {
            throw new Exception("Inventory:addEntity: Inventory is full");
        }
        
        
    }

    public void addInventory(Inventory secondInventory) {
        for (Map.Entry<String, Entity> entry : secondInventory.getInventory().entrySet()) {
            this.listOfEntity.put(entry.getKey(), entry.getValue());
        }
    }

    public void removeEntity(String entityName) {
        this.listOfEntity.remove(entityName);
    }


    public boolean contains(String entityName) {
        return listOfEntity.get(entityName) != null;
    }


    private HashMap<String, Entity> getInventory() {
        return listOfEntity;
    }



    public String inventoryToString() {
        String text = "";
        int counter = 1;
        
        for (Map.Entry<String, Entity> entry : listOfEntity.entrySet()) {
           text += counter + ". " +entry.getKey() + "\n";
        }

        return text;
    }
    
}
