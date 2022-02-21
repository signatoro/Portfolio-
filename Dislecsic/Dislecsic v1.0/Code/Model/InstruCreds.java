package Model;

// Imports 
import java.util.*;

import Util.Global;
import Util.LineClear;
import Util.Sec;

public class InstruCreds
{
    // Classes 
    Scanner sc = new Scanner(System.in);

    public InstruCreds(int selection)
    {
        // Instruction Slow
        if (selection == 1)
        {
            // Line clearer
            LineClear.ClearW();
            
            Global.view.printText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Global.view.printText("         Instruction and Commands         ");
            Global.view.printText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Global.view.printText();
            Global.view.printText();
            Sec.delaySec((long) 2);

           
            // Commands during Exploration 
            Global.view.printText("Commands While Exploring                    ");
            Global.view.printText();
            Sec.delaySec((long) 1);
            // Move
            Global.view.printText("To Move you would type \"Go\" then North, East, South or West");
            Global.view.printText("    To go North you would type \"Go North\"");
            Global.view.printText();
            Sec.delaySec(5);
            // Pick up
            Global.view.printText("To Pick stuff up you would type \"Grab\" then the name of the item");
            Global.view.printText("    To pick up a stick you would time \"Grab Stick\"");
            Global.view.printText();
            Sec.delaySec(5);
            // Say
            Global.view.printText("To Say something you would type \"Say\" then what you want to say");
            Global.view.printText("    To say hello you would type \"Say Hello\"");
            Global.view.printText();
            Sec.delaySec(5);
            // Check
            Global.view.printText("To Check your Inventory, Health, Level, or Xp you would type \"Check\" then what you want to check");
            Global.view.printText("    To check your health you would type \"Check health\"");
            Global.view.printText();
            Sec.delaySec(5);
            // Open 
            Global.view.printText("To Open something you would type \"Open\" then what you want to open");
            Global.view.printText("    To open a chest you would type \"Open Chest\"");
            Global.view.printText();
            Sec.delaySec(5);
            // Inspect 
            Global.view.printText("To Inspect an item you would type \"Inspect\" then type the item name");
            Global.view.printText("    To inspect a stick you would type \"Inspect Stick\"");
            Global.view.printText();
            Global.view.printText();
            Global.view.printText();
            Sec.delaySec((long) 2);
            
            
            
            // Commands During Combat
            Global.view.printText("Commands During Combat");
            Global.view.printText();
            Sec.delaySec(5);
            // Sword
            Global.view.printText("To Attck with an weapon you would type \"Attack with\" then the name of the weapon");
            Global.view.printText("    To attck with a sword you would type \"Attack with sword\"");
            Global.view.printText();
            Sec.delaySec(5);
            // Magic 
            Global.view.printText("To cast a spell you would type \"Cast spell with\" then the item that can cast magic");
            Global.view.printText("    To cast a spell you would type  \"Cast spell with wand\"");
            Global.view.printText();
            Sec.delaySec(5);
            // Potion
            Global.view.printText("To drink a potion you would type \"Use\" then the name of the potion");
            Global.view.printText("    To drink a health potion you would type  \"Use health potion\"");
            Global.view.printText();
            Sec.delaySec(5);
            // Run
            Global.view.printText("To run away you would type \"Run\" then North, East, South or West");
            Global.view.printText("    To run North you would type  \"Run North\"");
            Global.view.printText();
            Global.view.printText();
            Global.view.printText();
            Sec.delaySec((long) 2);



            //General Command & Infor
            Global.view.printText("General Commands & Information");
            Global.view.printText();
            Sec.delaySec((long) 1);

            // Rest
            Global.view.printText("In order to restore Hp you can Rest, but you can only rest 3 times.");
            Global.view.printText("    To rest type \"Rest\"");
            Global.view.printText();
            Sec.delaySec(5);
            // Help
            Global.view.printText("If you for get the Commands you can type \"Help\" and it will bring up this list");
            Global.view.printText();
            Sec.delaySec(3);
            
            // Case
            Global.view.printText("The commands are not case sensitve");
            Global.view.printText();
            Global.view.printText();
            Global.view.printText();
            Sec.delaySec((long) 3);

            //Input!!!!!!!!!!!!!!!      !
            String back = Global.view.getInput("Are you done?");

            if(back.equalsIgnoreCase("Yes"))
            {
                Sec.delaySec((long) 1);
                Intro starter = new Intro(1);
            }
            else
            {
                Sec.delaySec((long) 1);
                InstruCreds restart = new InstruCreds(2);
            }
        }
        
        // Instructions Quick
        if (selection == 2)
        {
            // Line clearer
            LineClear.ClearNW();

            Global.view.printText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Global.view.printText("         Instruction and Commands         ");
            Global.view.printText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Global.view.printText();
            Global.view.printText();

           
           
            // Commands during Exploration 
            Global.view.printText("Commands While Exploring                    ");
            Global.view.printText();
            // Move
            Global.view.printText("To Move you would type \"Go\" then North, East, South or West");
            Global.view.printText("    To go North you would type \"Go North\"");
            Global.view.printText();
            // Pick up
            Global.view.printText("To Pick stuff up you would type \"Grab\" then the name of the item");
            Global.view.printText("    To pick up a stick you would time \"Grab Stick\"");
            Global.view.printText();
            // Say
            Global.view.printText("To Say something you would type \"Say\" then what you want to say");
            Global.view.printText("    To say hello you would type \"Say Hello\"");
            Global.view.printText();
            // Check
            Global.view.printText("To check your Inventory, Health or Mana you would type \"Check\" then what you want to check");
            Global.view.printText("    To check your health you would type \"Check health\"");
            Global.view.printText();
            // Inspect 
            Global.view.printText("To Inspect an item you would type \"Inspect\" then type the item name");
            Global.view.printText("    To inspect a stick you would type \"Inspect Stick\"");
            Global.view.printText();
            Global.view.printText();
            Global.view.printText();
            
            
            // Combat 
            Global.view.printText("Commands During Combat");
            Global.view.printText();
            
            
            // Sword
            Global.view.printText("To Attck with an weapon you would type \"Attack with\" then the name of the weapon");
            Global.view.printText("    To attck with a sword you would type \"Attack with sword\"");
            Global.view.printText();
            // Magic 
            Global.view.printText("To cast a spell you would type \"Cast spell with\" then the item that can cast magic");
            Global.view.printText("    To cast a spell you would type  \"Cast spell with wand\"");
            Global.view.printText();
            // Potion
            Global.view.printText("To drink a potion you would type \"Use\" then the name of the potion");
            Global.view.printText("    To drink a health potion you would type  \"Use health potion\"");
            Global.view.printText();
            // Run
            Global.view.printText("To run away you would type \"Run\" then North, East, South or West");
            Global.view.printText("    To run North you would type  \"Run North\"");
            Global.view.printText();
            Global.view.printText();
            Global.view.printText();



            //General Command & Infor
            Global.view.printText("General Commands & Information");
            Global.view.printText();

            // Rest
            Global.view.printText("In order to restore Hp you can Rest, but you can only rest 3 times.");
            Global.view.printText("    To rest type \"Rest\"");
            Global.view.printText();
            // Help
            Global.view.printText("If you for get the Commands you can type \"Help\" and it will bring up this list");
            Global.view.printText();

            // Case
            Global.view.printText("The commands are not case sensitve");
            Global.view.printText();
            Global.view.printText();
            Global.view.printText();

            //Input!!!!!!!!!!!!!!!      !
            String back = Global.view.getInput("Are you done?");

            if(back.equalsIgnoreCase("Yes"))
            {
                Sec.delaySec((long) 1);
                Intro starter = new Intro(1);
            }
            else
            {
                Sec.delaySec((long) 1);
                InstruCreds restart = new InstruCreds(2);
            }
        }

        // Credits Slow 
        if (selection == 3)
        {
            // Line Clear
            LineClear.ClearW();

            // Text 
            Global.view.printText("CREDITS");
            Global.view.printText();
            Sec.delayMil((long) 5);

            Global.view.printText("This games was thought of and programed by Scott Pignataro");
            Global.view.printText();
            Global.view.printText();
            Sec.delaySec((long) 2);

            //Input!!!!!!!!!!!!!!!      !
            String back = Global.view.getInput("Are you done?");

            if(back.equalsIgnoreCase("Yes"))
            {
                Sec.delaySec((long) 1);
                Intro starter = new Intro(1);
            }
            else
            {
                Sec.delaySec((long) 1);
                InstruCreds restart = new InstruCreds(4);
            }
        }

        // Credits Quick
        if (selection == 4) 
        {
            // Line Clear
            LineClear.ClearNW();

            // Text
            Global.view.printText("CREDITS");
            Global.view.printText();

            Global.view.printText("This games was thought of and programed by Scott Pignataro");
            Global.view.printText();
            Global.view.printText();

            //Input!!!!!!!!!!!!!!!      !
            String back = Global.view.getInput("Are you done?");

            if (back.equalsIgnoreCase("Yes")) {
                Sec.delaySec((long) 1);
                Intro starter = new Intro(1);
            } else {
                Sec.delaySec((long) 1);
                InstruCreds restart = new InstruCreds(4);
            }
        }

        // During Game Commands
        if (selection == 5) {
            // Line clearer
            LineClear.ClearW();

            Global.view.printText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Global.view.printText("         Instruction and Commands         ");
            Global.view.printText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Global.view.printText();
            Global.view.printText();

            // Commands during Exploration
            Global.view.printText("Commands While Exploring                    ");
            Global.view.printText();
            // Move
            Global.view.printText("To Move you would type \"Go\" then North, East, South or West");
            Global.view.printText("    To go North you would type \"Go North\"");
            Global.view.printText();
            // Pick up
            Global.view.printText("To Pick stuff up you would type \"Grab\" then the name of the item");
            Global.view.printText("    To pick up a stick you would time \"Grab Stick\"");
            Global.view.printText();
            // Say
            Global.view.printText("To Say something you would type \"Say\" then what you want to say");
            Global.view.printText("    To say hello you would type \"Say Hello\"");
            Global.view.printText();
            // Check
            Global.view.printText("To Check your Inventory or Health you would type \"Check\" then what you want to check");
            Global.view.printText("    To check your health you would type \"Check health\"");
            Global.view.printText();
            // Open
            Global.view.printText("To Open something you would type \"Open\" then what you want to open");
            Global.view.printText("    To open a chest you would type \"Open Chest\"");
            Global.view.printText();
            // Inspect
            Global.view.printText("To Inspect an item you would type \"Inspect\" then type the item name");
            Global.view.printText("    To inspect a stick you would type \"Inspect Stick\"");
            Global.view.printText();
            Global.view.printText();
            Global.view.printText();

            // Commands During Combat
            Global.view.printText("Commands During Combat");
            Global.view.printText();
            // Sword
            Global.view.printText("To Attack with an weapon you would type \"Attack with\" then the name of the weapon");
            Global.view.printText("    To attack with a sword you would type \"Attack with sword\"");
            Global.view.printText();
            // Magic
            Global.view.printText("To cast a spell you would type \"Cast spell with\" then the item that can cast magic");
            Global.view.printText("    To cast a spell you would type  \"Cast spell with wand\"");
            Global.view.printText();
            // Use
            Global.view.printText("To drink a potion you would type \"Use\" then the name of the potion");
            Global.view.printText("    To drink a health potion you would type  \"Use health potion\"");
            Global.view.printText();
            // Run
            Global.view.printText("To run away you would type \"Run\" then North, East, South or West");
            Global.view.printText("    To run North you would type  \"Run North\"");
            Global.view.printText();
            Global.view.printText();
            Global.view.printText();

            // General Command & Infor
            Global.view.printText("General Commands & Information");
            Global.view.printText();

            // Rest
            Global.view.printText("In order to restore Hp you can Rest, but you can only rest 3 times.");
            Global.view.printText("    To rest type \"Rest\"");
            Global.view.printText();
            // Help
            Global.view.printText("If you for get the Commands you can type \"Help\" and it will bring up this list");
            Global.view.printText();
            // Case
            Global.view.printText("The commands are not case sensitve");
            Global.view.printText();
            Global.view.printText();
            Global.view.printText();

            Sec.delaySec(3);

        }

    }
}


