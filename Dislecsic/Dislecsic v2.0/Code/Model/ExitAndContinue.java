package Model;

import java.io.*;
import java.util.*;

import Util.GameState;
import Util.Global;
import Util.LineClear;
import Util.Sec;
import Util.StringCleaner;
import Util.FileMan.ReadFile;

public class ExitAndContinue
{
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> FileList = new ArrayList<String>();
    private static int x = 0;


    public static void getFile()
    {
        try
        {
            FileInputStream saveFile = new FileInputStream("FileNameList.sav");
            ObjectInputStream save = new ObjectInputStream(saveFile);


            FileList = (ArrayList)save.readObject();
            x = 1;
        }
        catch(Exception ex)
        {
            Global.view.printError(ex.getMessage());
        }
    }
    
    public static void Continue()
    {
        LineClear.ClearW(5);
    
        // Checks if list is empty
        if (FileList.size() == 0)
        {
            Global.view.printText();
            Global.view.printText();
            Global.view.printText("You have no saved files");
            Global.view.printText();
            Sec.delaySec(2);

            Global.lastGameState = Global.gamestate;
            Global.gamestate = GameState.MENU;
            Global.view.panelSwitcher(Global.gamestate);
        }

        // Prints file name
        Global.view.printText("Files:");
        Sec.delaySec(1);
        for (int i = 0; i < FileList.size(); i++)
        {
            Global.view.printText("\t" + (i + 1) + ". " + FileList.get(i));

        }
        Global.view.printText("You can type \"play\" or \"remove\" and then the # of the file you want to open, or \"exit\"");
        Sec.delaySec(2);
        Global.view.printText();
        Global.view.printText();
        // User Input
        Global.view.printText("What would you like to do?");
        String cho = sc.nextLine();



        // Remove Spaces and Lower Case
        String choice;
        String tempChoice = "";
        int change = 0;
        for (int i = cho.length(); i > 0; i--) 
        {
            if (cho.substring(i - 1, i).equals(" ")) 
            {
                change = change + 1;
            }
            else
            {
                break;
            }
        }
        tempChoice = cho.substring(0, cho.length() - change);
        choice = tempChoice.toLowerCase();



        // Play
        if (choice.contains("play"))
        {
            // Variables
            String NumAsString = choice.substring(5);
            Global.view.printText(NumAsString);
            
            // String to number 
            int number = Integer.parseInt(NumAsString);

            // Play or Repeat
            if(number <= FileList.size())
            {
                LineClear.ClearNW(50);
                ReadFile.Reading(FileList.get((number -1)));
            }
            else 
            {
                Global.view.printText("There is no file numbered " + number);
                Sec.delaySec(2);
                LineClear.ClearNW(10);
                ExitAndContinue.Continue();
            }
            
        }

        // REMOVE
        else if (choice.contains("remove"))
        {
            // Variables
            String NumAsString = choice.substring(7);
            int number = 0;

            // String to number
            number = Integer.parseInt(NumAsString);

            // Remove 
            if(number <= FileList.size())
            {
                Sec.delaySec(1);
                LineClear.ClearNW(5);
                Global.view.printText(FileList.get((number - 1)) + " has been removed.");
                Sec.delaySec(2);
                FileList.remove(FileList.get((number - 1)));
            }
            else 
            {
                Global.view.printText("There is no file numbered " + number);
                Sec.delaySec(2);
                LineClear.ClearNW(10);
                ExitAndContinue.Continue();
            }
            ExitAndContinue.Continue();
        }
        else if (choice.equalsIgnoreCase("exit"))
        {
            Global.lastGameState = Global.gamestate;
            Global.gamestate = GameState.MENU;
            Global.view.panelSwitcher(Global.gamestate);
           
        }
        else 
        {
            Global.view.printText("You can not do that.");
            Sec.delaySec(2);
            LineClear.ClearNW(10);
            ExitAndContinue.Continue();
        }

    }



    public static String ExitSave()
    {

        Global.view.printText("You would you like to save your game?");
        String YesOrNo = StringCleaner.cleanString(Global.view.getInput());

        if (YesOrNo.equals("yes"))
        {
            Global.view.printText("What do you want to name your file?");
            String fileName = StringCleaner.cleanString(Global.view.getInput());



            // Adds filename to list
            if (!(FileList.contains(fileName)))
            {
                FileList.add(fileName);
            }


            // Save file name to file
            try
            {

                FileOutputStream saveFile = new FileOutputStream("FileNameList.sav");
                ObjectOutputStream save = new ObjectOutputStream(saveFile);

                save.writeObject(FileList);

                save.close();

                return fileName;
            }
            catch (Exception ex)
            {
                Global.view.printText("Error");
                return null;
            }
        }
        else if (YesOrNo.equals("no"))
        {
            Global.lastGameState = Global.gamestate;
            Global.gamestate = GameState.MENU;
            Global.view.panelSwitcher(Global.gamestate);
            return null;

        }
        else 
        {
            Global.view.printText("That is not an option?");
            Sec.delaySec(2);
            ExitAndContinue.ExitSave();
            return null;
        }
    }


}