package Model.Enemies;

import Model.Body;
import Model.Enemy;

public class Skeleton extends Body implements Enemy {

    public Skeleton(String name, int x, int y, int hp) {
        super(name, x, y, hp);
        //TODO Auto-generated constructor stub
    }

    @Override 
    public String getName() {
        return super.name;
    }

    
    @Override
    public void attack() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Enemy clone() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Enemy clone(int x, int y) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
