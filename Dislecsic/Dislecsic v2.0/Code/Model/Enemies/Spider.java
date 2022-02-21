package Model.Enemies;

import Model.Body;
import Model.Enemy;

public class Spider extends Body implements Enemy{

    public Spider(String name, int x, int y, int hp) {
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
        return new Spider(name, x, y, hp);
    }

    @Override
    public Enemy clone(int x, int y) {
        return new Spider(name, x, y, hp);
    }
    
}
