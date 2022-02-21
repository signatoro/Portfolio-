package Model;



public class Player extends Body {

    //Variables
    private int level;

    private int maxHp;

    private int xp;
    private int xpAmountNeed;

    private int restCounter;

    /** PLAYTEST DIF INVENTORY SIZES */
    private int inventorySize = 10;

    //Objects
    private Inventory inventory;

    public Player (String name, int x, int y, int level, int hp, int xp) {
        super(name, x, y, hp);
        this.level = level;
        this.maxHp = 20 + (level * 10);
        this.xp = xp;
        this.xpAmountNeed = (int) Math.floor(Math.pow(level, 2));
        this.inventory = new Inventory(inventorySize);
        this.restCounter = 4;

        this.hpCheck();

    }

    private void hpCheck() {
        if (super.hp > maxHp) {
            super.hp = maxHp;
        }
    }

    public int getX() {
        return super.x;
    }
    
    public int getY() {
        return super.y;
    }

    public void setX(int x) {
        super.x = x;
    }

    public void setY(int y) {
        super.y = y;
    }

    public void goNorth() {
        y--;
    }

    public void goEast() {
        x++;
    }

    public void goSouth() {
        y++;
    }

    public void goWest() {
        x--;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUp() {
        level++;

        this.hpCheck();
    }


    public int getXp() {
        return this.xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void addXp(int points) throws Exception {
        this.xp += points;

        if (xp >= xpAmountNeed) {
            throw new Exception("Level Up");
        }
    }


    public double getHp() {
        this.hpCheck();
        return super.hp;
    }

    public void setHp(int hp) {
        super.hp = hp;
        this.hpCheck();
    }

    public int getRestCounter() {
        return restCounter;
    }

    public void setRestCounter(int restCounter) {
        this.restCounter = restCounter;
    }

    public void rest() {
        this.hp = maxHp;
        this.restCounter--;
    }

    public void damage(int damage) throws Exception {
        super.hp = super.hp - damage;

        if (super.hp <= 0) {
            throw new Exception("Player Dead");
        }
        this.hpCheck();
    }

    public void healing(int heal) throws Exception {
        super.hp = super.hp + heal;

        this.hpCheck();
    }



    public Inventory getInvetory() {
        return inventory;
    }

    public void addToInvetory(Entity entity) throws Exception {
        inventory.addEntity(entity);
    }

    public void removeFromInvetory(String name) {
        inventory.removeEntity(name);
    }

}