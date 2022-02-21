package Model;

// Intro
import java.util.*;

import Controller.GameLoop;
import Util.Global;
import Util.LineClear;
import Util.Sec;
public class Intro 
{
    // classes
    Scanner sc = new Scanner(System.in);
    FindPosition pos = new FindPosition(37, 15);
    Inventory inven = new Inventory();
    
    // Main Slow
    public Intro()
    {
        // Line clear
        LineClear.ClearW();
        
        // Text 
        Global.view.printText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Global.view.printText("            A Dwarf's Adventure           ");
        Global.view.printText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Sec.delaySec((long) 2);
        Global.view.printText("                                          ");
        Global.view.printText("                                          ");
        Global.view.printText("                   Play                   ");
        Global.view.printText("                 Continue                 ");
        Global.view.printText("               Instructions               ");
        Global.view.printText("                  Credit                  ");
        Global.view.printText("                   Quit                   ");
        Global.view.printText("                                          ");
        Global.view.printText("                                          ");
        Sec.delaySec((long) 1);
        
        // Selection
        String selec = Global.view.getInput();

        // Play 
        if (selec.equalsIgnoreCase("play"))
        {
            Sec.delaySec((long) 1);
            CutScene.Sc1();
            GameLoop game1 = new GameLoop(37, 15, 20, 1, 0, 0, false);
        }

        // Continue
        else if (selec.equalsIgnoreCase("continue")) 
        {
            ExitAndContinue.Continue();
        }
        
        // Instructions 
        else if (selec.equalsIgnoreCase("Instructions"))
        {
            Sec.delaySec((long) 1);
            InstruCreds instruc = new InstruCreds(1); 
        }
        
        
        // Credits
        else if (selec.equalsIgnoreCase("Credits"))
        {
            Sec.delaySec((long) 1);
            InstruCreds instruc = new InstruCreds(3);

        }
        else if (selec.equalsIgnoreCase("Quit"))
        {
            System.exit(1);
        }
        
        // Refresh 
        else 
        {
            Sec.delaySec((long) 1);
            Global.view.printText("That is not an option please choose again.");
            // Sleep 
            Intro starter = new Intro(1);
        }

    }
    
    // Main Quick
    public Intro(int choice)
    {
        // Line Clear 
        LineClear.ClearNW();
        
        // Text 
        Global.view.printText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Global.view.printText("            A Dwarf's Adventure           ");
        Global.view.printText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Global.view.printText("                                          ");
        Global.view.printText("                                          ");
        Global.view.printText("                   Play                   ");
        Global.view.printText("                 Continue                 ");
        Global.view.printText("               Instructions               ");
        Global.view.printText("                  Credit                  ");
        Global.view.printText("                   Quit                   ");
        Global.view.printText("                                          ");
        Global.view.printText("                                          ");
        
        // Selection
        String selec = Global.view.getInput();

        // Play
        if (selec.equalsIgnoreCase("play"))
        {
            Sec.delaySec((long) 1);
            GameLoop game1 = new GameLoop(37, 15, 20, 1, 0, 0, false);
            
        }

        // Continue
        else if (selec.equalsIgnoreCase("continue"))
        {
            ExitAndContinue.Continue();
        }
        
        // Quick Intro
        else if (selec.equalsIgnoreCase("Instructions"))
        {
            Sec.delaySec((long) 1);
            InstruCreds instruc = new InstruCreds(2); 
        }
        
        // Quick Credits 
        else if (selec.equalsIgnoreCase("Credits"))
        {
            Sec.delaySec((long) 1);
            InstruCreds instruc = new InstruCreds(4);
        }
        else if (selec.equalsIgnoreCase("Quit"))
        {
            System.exit(1);
        }
        
        // Refresh
        else 
        {
            Global.view.printText("That is not an option please choose again.");
            Sec.delaySec((long) 1);
            Intro starter = new Intro(1);
        }
    }

}