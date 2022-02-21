package Model;



public class Container extends Entity {

    private Inventory inventory;
    

    public Container (String name, String inspect, int size) {
        super(name, inspect);
        this.inventory = new Inventory(size);
    }

    public Container (String name, String[] listOfInspect, int size) {
        super(name, listOfInspect);
        this.inventory = new Inventory(size);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addEntity(Entity entity) throws Exception {
        if (entity instanceof Container) {
            throw new Exception("Container:addEntity: Container can't contain Container");
        }
        else {
            inventory.addEntity(entity);
        }
    }

    public Entity getEntity(String name) throws Exception {
        return inventory.getEntity(name);
    }
    
    public Entity getEntity(int index) throws Exception {
        return inventory.getEntity(index);
    }

    

    public String open() {
        String text = "";

        /*******
         * 
         * 
         * Finish Later
         */


        return text;
    }

    public String printContainer() {
        String text = "";

        text += super.name + ":\n";

        text += inventory.inventoryToString();

        return text;
    }
}
