package Util.FileMan;


import java.io.*;
import java.util.ArrayList;

import Model.FindPosition;
import Model.Inventory;
import Util.Global;

public class SaveFile
{
    public static void Saving_Game_Files(int x, int y, double health, int level, int restCounter, int enemiesKilled, boolean cave, String FileName)
    {
        try
        {
            FileOutputStream saveFile = new FileOutputStream(FileName + ".sav");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            save.writeObject(x);
            save.writeObject(y);
            save.writeObject(health);
            save.writeObject(level);
            save.writeObject(restCounter);
            save.writeObject(enemiesKilled);
            save.writeObject(cave);
            save.writeObject(Inventory.inven);
            save.writeObject(FindPosition.forest);




            save.close();
        }
        catch(Exception exc)
        {
            exc.printStackTrace();
            Global.view.printError(exc.getMessage());
        }
    }

}