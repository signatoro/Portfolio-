package Model.Depreciated;
import Util.Global;

public class Grab
{
    Items it = new Items();
    private String name;
    
    public Grab()
    {

    }
    public String pickUp(String Uname, double Upos)
    {
        name = Uname;
                
        if (name.equalsIgnoreCase(it.ItemFinder(Upos)))
        {
            Global.view.printText("You picked up the " + it.ItemFinder(Upos));
            return it.ItemFinder(Upos);
        }
        else
        {
            return "There is nothing to pick up.";
        }

    }
}