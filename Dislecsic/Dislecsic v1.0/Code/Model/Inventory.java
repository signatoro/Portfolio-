package Model;


import java.util.*;

import Util.Global;
import Util.Sec;

public class Inventory
{
    public static List<String> inven = new ArrayList<>();
    
    public Inventory()
    {
    }


    public void addItem(String Name)
    {
        String lowerCaseName = Name.toLowerCase();
        inven.add(lowerCaseName);
    }

    public void removeItem(String Name)
    {
        String lowerCaseName = Name.toLowerCase();
        inven.remove(lowerCaseName);
    }
    public void getInventory()
    {
        if (inven.size() == 0)
        {
            Global.view.printText("There is nothing in your inventory.");
        }
        else 
        {
            Global.view.printText("Your Inventory: ");
            Sec.delaySec(1);
            for (int x = 0; x < inven.size(); x++) 
            {
                Global.view.printText("\t" + inven.get(x));
                Sec.delayMil(15);
            }
        }
    }
    public boolean checkInventory(String item)
    {
        for (int x = 0; x < inven.size(); x++) 
        {
            if (item.equalsIgnoreCase(inven.get(x)))
            {
                return true;
            }
        }
        return false;
    }
}