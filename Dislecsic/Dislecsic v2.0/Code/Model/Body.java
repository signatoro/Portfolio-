package Model;

public class Body {

    //Variables
    protected String name;

    public int x;
    public int y;

    protected int hp;

    public Body(String name, int x, int y, int hp) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }
}
