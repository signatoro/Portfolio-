package Model.Depreciated;
import Util.Global;

public class Open 
{
    // Classes
    Items its = new Items();
    // Variables 
    private double posId;
    private double newId;


    public Open()
    {

    }

    public double OpenChest(double pos)
    {
        posId = pos;
        Global.view.printText("You open the chest and inside is a " + its.ItemFinder(posId));
        
        newId = Math.round((posId + .3) * 100);
        
        return (newId / 100);
    }
}

/*
 * .60 = Stick 
 * .61 = Rusty Dagger 
 * .62 = Cloth Robes 
 * .63 = Health Potions 
 * .64 = Boots 
 * .65 = Wand
*/