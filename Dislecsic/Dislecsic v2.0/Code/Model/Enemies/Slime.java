package Model.Enemies;

import Model.Body;
import Model.Enemy;

public class Slime extends Body implements Enemy{

    public Slime(String name, int x, int y, int hp) {
        super(name, x, y, hp);
        
    }

    @Override 
    public String getName() {
        return super.name;
    }

    @Override
    public void attack() {
        
        
    }


    
    @Override
    public Enemy clone() {
        return new Slime(name, x, y, hp);
    }

    @Override
    public Enemy clone(int x, int y) {
        return new Slime(name, x, y, hp);
    }
    
}
