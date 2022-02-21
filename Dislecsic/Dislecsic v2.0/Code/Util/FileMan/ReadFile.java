package Util.FileMan;


import java.io.*;
import java.util.ArrayList;

import Model.CutScene;

import Model.Inventory;
import Util.Global;

public class ReadFile
{
    public static void Reading(String FileName)
    {
        try
        {
            FileInputStream saveFile = new FileInputStream(FileName + ".sav");
            ObjectInputStream save = new ObjectInputStream(saveFile);
            
            int x = (int) save.readObject();
            int y = (int) save.readObject();
            double health = (double) save.readObject();
            int level = (int) save.readObject();;
            int restCounter = (int) save.readObject();
            int enemiesKilled = (int) save.readObject();
            boolean cave = (boolean) save.readObject();
            //Inventory.inven = (ArrayList<String>) save.readObject();;
            //FindPosition.forest = (double[][]) save.readObject();

            CutScene.Sc27_Continue(x, y, health, level);
            //new GameLoop(x, y, health, level, restCounter, enemiesKilled, cave);


            save.close();
        }
        catch (Exception exc)
        {
            Global.view.printError(exc.getMessage());
        }

    }
}