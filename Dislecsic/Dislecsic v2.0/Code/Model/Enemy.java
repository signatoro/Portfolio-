package Model;

import Model.Enemies.Skeleton;
import Model.Enemies.Slime;
import Model.Enemies.Spider;

public interface Enemy {
    
    public static Enemy slime = new Slime("Slime", 0, 0, 5);

    public static Enemy spider = new Spider("Spider", 0, 0, 15);

    public static Enemy skeleton = new Skeleton("Skeleton", 0, 0, 25);
    
    public String getName();

    public void attack();

    
    public Enemy clone();

    public Enemy clone(int x, int y);


    
}
