package Controller;
/*
// Imports
import java.util.*;

import Model.Combat;
import Model.CutScene;
import Model.ExitAndContinue;
import Model.FindPosition;
import Model.Inventory;
import Model.Depreciated.Grab;
import Model.Depreciated.Items;
import Model.Depreciated.Move;
import Model.Depreciated.Open;
import Util.GameState;
import Util.Global;
import Util.LineClear;
import Util.Sec;
import Util.FileMan.SaveFile;
import Util.StringCleaner;

public class GameLoop
{
    // Class 
    /*
     * Find Postion 
     * Pick Up 
     * Move 
     * Invetory
     
    Scanner sc ;
    Move move;
    Items items;
    Open op;
    Grab grab;
    Inventory inventory;
    FindPosition pos;


    
    // Variables 
    private String cho;
    private String item;
    
    public static boolean cave;
    private int x;
    private int y;
    
    private double health;
    private double healthMax;
    private int restCounter;
   
    private int level;
    private double newPosId;

    private int Loop = 0;
    private int onlyOnce = 0;

    private boolean openedChested;

    // First Call
    public GameLoop(int SX, int SY, double SHealth, int SLevel, int SrestCounter, int enemiesKilled, boolean Cave)
    {
        x = SX;
        y = SY;
        health = SHealth;
        level = SLevel;
        healthMax = (30 + (5.25 * (level - 1)));
        restCounter = SrestCounter;
        CutScene.enemiesKilled = enemiesKilled;

        sc = new Scanner(System.in);
        move = new Move();
        items = new Items();
        op = new Open();
        grab = new Grab();
        //inventory = new Inventory();
        pos = new FindPosition(37, 15);


        cave = Cave;
        
        CutScene.Sc1();

        while (Loop != 1)
        {
            openedChested = false;
            String choice;
            health = Math.round(health * 10) / 10.0;

            choice = StringCleaner.cleanString(Global.view.getInput());

            

            Sec.delaySec(1);

            //***************************************************************
            // PROGRAMMER COMMANDS
            if (choice.equalsIgnoreCase("xy"))
            {
                System.out.println(x);
                System.out.println(y);
            }
            else if (choice.equalsIgnoreCase("check pos"))
            {
                System.out.println(pos.CheckPos(x, y));
            }
            else if (choice.equalsIgnoreCase("bug")) {
                //inventory.addItem("Wand");
                //inventory.addItem("Rusty Sword");
                Global.view.printText("I hope you're not cheating!");
            }
            else if (choice.contains("setpos")) {
                String num = "" + choice.charAt(7) + choice.charAt(8);
                String num2 = "" + choice.charAt(10) + choice.charAt(11);

                x = Integer.parseInt(num);
                y = Integer.parseInt(num2);
                pos.CheckPos(x, y);
                pos.MoveResponce(x, y);
            }
            // ***************************************************************



            // **********
            // COMMANDS
            // **********

            // HELP
            else if (choice.equalsIgnoreCase("Help")) 
            {
                Global.lastGameState = Global.gamestate;
                Global.gamestate = GameState.INSTRUCTIONS;
                Global.view.panelSwitcher(Global.gamestate);

                Sec.delaySec(1);
            }
            
            // REST
            else if (choice.equalsIgnoreCase("Rest"))
            {
                if (this.restCounter < 5)
                {
                    health = healthMax;
                    CutScene.Sc5Sleep();
                    this.restCounter++;
                }
                else
                {
                    Global.view.printText("You lie down and try to fall asleep but you can't.");
                    Sec.delaySec(2);
                    Global.view.printText("the complete silence of the forest is unnerving");
                }
            }

            // GO
            else if (choice.contains("go") && choice.length() > 2)
            {
                String direction = StringCleaner.cleanString(choice.substring(3));

                if (direction.equals("north"))
                {
                    x = move.goNorth(x, y);
                }
                else if (direction.equals("south"))
                {
                    x = move.goSouth(x, y);
                }
                else if (direction.equals("east"))
                {
                    y = move.goEast(x, y);
                }
                else if (direction.equals("west"))
                {
                    y = move.goWest(x, y);
                }
                else 
                {
                    Global.view.printText("You can not go " + direction);
                    System.out.println(choice);
                    System.out.println(direction);
                }

            }

            // GRAB
            else if (choice.contains("grab"))
            {
                if (pos.CheckPos(x, y) >= .60 && pos.CheckPos(x, y) <= .66)
                {
                    item = StringCleaner.cleanString(choice.substring(5));
                    if (item.equalsIgnoreCase(items.ItemFinder(pos.CheckPos(x, y))))
                    {
                        Global.view.printText("You grab the " + items.ItemFinder(pos.CheckPos(x, y)) + " and put it in your inventory." );
                        
                        //inventory.addItem(items.ItemFinder(pos.CheckPos(x, y)));
                        
                        if (x == 34 && y == 15) {
                            pos.ChangeId(x, y, .21);
                        } else {
                            pos.ChangeId(x, y, .10);
                        }
                    }
                    else 
                    {
                        Global.view.printText("There is a " + items.ItemFinder(pos.CheckPos(x, y)) + " on the ground not a " + item);
                    }
                }
                else 
                {
                    Global.view.printText("There is nothing to grab.");
                }
            }

            /*
            // SAY
            else if (choice.contains("say"))
            {
                String speaking = choice.substring(4);
                int secret = 0;

                if (speaking.equalsIgnoreCase("Albus") && secret != 1)
                {
                    CutScene.Sc4Say(speaking);
                    Sec.delaySec(5);
                    LineClear.ClearNW(3);
                    CutScene.Sc1980();

                    inventory.addItem("Elder Wand");
                }
                else 
                {
                    CutScene.Sc4Say(speaking);
                }
            }
            

            // CHECK
            else if (choice.contains("check"))
            {
                String checkWhat = StringCleaner.cleanString(choice.substring(6));

                if (checkWhat.equalsIgnoreCase("Inventory"))
                {
                    //inventory.getInventory();
                }
                else if (checkWhat.equalsIgnoreCase("Health"))
                {
                    Global.view.printText("You have " + health + " Hp out of a total of " + healthMax + " Hp");
                }
                else if (checkWhat.equalsIgnoreCase("Level"))
                {
                    Global.view.printText("You are level " + level + ".");
                }
                else if (checkWhat.equalsIgnoreCase("Xp"))
                {
                    int XpToNextLevel = (level * 2) - CutScene.enemiesKilled ;

                    Global.view.printText("You need to kill " + XpToNextLevel + " more enemies to level up.");
                }
                else
                {
                    Global.view.printText("You can not check " + checkWhat);
                    Global.view.printText("You can check your inventory, health, level, or Xp");
                }
            }

            // OPEN 
            else if (choice.contains("open"))
            {
                String openWhat = StringCleaner.cleanString(choice.substring(5));
                if (openWhat.equalsIgnoreCase("Chest"))
                {
                    if (pos.CheckPos(x, y) >= .30 && pos.CheckPos(x, y) <= .36)
                    {
                        pos.ChangeId(x, y, op.OpenChest(pos.CheckPos(x, y)));
                        openedChested = true;
                    }
                    else
                    {
                        Global.view.printText("There is nothing to open.");
                    }
                }
                else if (choice.substring(5).contains(" "))
                {
                    Global.view.printText("You have to open something.");
                }
                else 
                {
                    Global.view.printText("You can not open " + openWhat);
                }
            }

            // INSPECT 
            else if (choice.contains("inspect"))
            {
                String inspectItem = StringCleaner.cleanString(choice.substring(8));

                /*
                if (inventory.checkInventory(inspectItem))
                {
                    Global.view.printText("There is nothing special about it.");
                }
                else
                {
                    Global.view.printText("You can not inspect " + inspectItem);
                }
                
            }
            // EXIT
            else if (choice.contains("exit"))
            {
                Global.view.printText("Your progress will NOT be save.");
                Global.view.printText("Sorry for the inconvience.");
                Sec.delaySec(3);
                /*
                String FileName = ExitAndContinue.ExitSave();

                SaveFile.Saving_Game_Files(x, y, health, level, restCounter, enemiesKilled, cave, FileName);
                

                String yesno = StringCleaner.cleanString(Global.view.getInput("Are you sure you would like to exit?"));


                if (yesno.equals("yes")) {
                    Global.lastGameState = Global.gamestate;
                    Global.gamestate = GameState.MENU;
                    Global.view.panelSwitcher(Global.gamestate);
                    
                    try {
                        Global.gameThread.isInterrupted();
                    } catch (Exception e) {
                        //System.out.println(e);
                    }
                }

            }
            else
            {
                Global.view.printText("You can not do that.");
                Global.view.printText("If you don't know what to do type \"Help\".");
            }




            //**********
            // SPECIAL
            //**********

            // CROSSROAD
            if (pos.CheckPos(x, y) == .40)
            {
                newPosId = CutScene.Sc2CrossRoads();
                pos.ChangeId(x, y, .60);
            }

            // ENTER CAVE FROM NON-BOSS SIDE
            else if (pos.CheckPos(x, y) == .41)
            {
                cave = true;
                CutScene.Sc_Enter_Cave();
                x = 10;
                y = 34;
            }

            // ENTER CAVE FROM BOSS SIDE
            else if (pos.CheckPos(x, y) == .42)
            {
                cave = true;
                CutScene.Sc_Enter_Cave();
                x = 10;
                y = 2;
            }

            // EXIT CAVE NON-BOSS SIDE
            else if (pos.CheckPos(x, y) == .43)
            {
                cave = false;
                CutScene.Sc_Exit_Cave();
                x = 31;
                y = 7;
            }

            // EXIT CAVE BOSS SIDE
            else if (pos.CheckPos(x, y) == .44)
            {
                cave = false;
                CutScene.Sc_Exit_Cave();
                x = 31;
                y = 3;
            }

            // CHESTS
            else if(pos.CheckPos(x, y) >= .30 && pos.CheckPos(x, y) <= .36)
            {
                CutScene.Sc3Chest();
            }

            // COMBAT
            else if (pos.CheckPos(x, y) >= .50 && pos.CheckPos(x, y) <= .54)
            {
                health = Combat.CombatLoop(health, healthMax, level, pos.CheckPos(x, y), inventory);
                pos.ChangeId(x, y, .10);
                pos.MoveResponce(x, y);
            }

            // ITEM ON GROUND
            else if (pos.CheckPos(x, y) >= .60 && pos.CheckPos(x, y) <= .66 && !openedChested)
            {
                Global.view.printText("There is a " + items.ItemFinder(pos.CheckPos(x, y)) + " on the ground.");
                Sec.delaySec(2);
            }

            // ENTER MINOTUAR AREA
            else if (pos.CheckPos(x, y) == .47)
            {
                CutScene.Sc20_Enter_Area();
                pos.ChangeId(x, y, .10);
            }

            // MINOTUAR BATTLE
            else if (pos.CheckPos(x, y) == .57)
            {
                CutScene.Sc21_Approach_Minotaur();
                health = Combat.CombatLoop(health, healthMax, level, .57, inventory);
            }

            //TROLL APROACH
            else if (pos.CheckPos(x, y) == .46) {
                CutScene.Sc_Troll_Approach();
                pos.ChangeId(x, y, .10);
            }
            //TROLL battle
            else if (pos.CheckPos(x, y) == .56) {
                CutScene.Sc_Troll_Combat();
                health = Combat.CombatLoop(health, healthMax, level, pos.CheckPos(x, y), inventory);
                CutScene.enemiesKilled += 11;

                pos.ChangeId(7, 4, .18);
                for (int i = 0; i < 5; i++) {
                    pos.ChangeId(8+i, 4, .10);
                }
                pos.ChangeId(13, 4, .17);

            }

            /*
            // GET SWORD AT 5 LEVEL
            else if (level == 5 && onlyOnce == 0)
            {
                inventory.addItem("Rusty Sword");
                
                onlyOnce = 1;
            }
            

            // LEVEL UP
            if (CutScene.enemiesKilled >= (level * 2))
            {
                level = level + 1;
                CutScene.enemiesKilled = 0;

                healthMax = (20 + (5.25 * (level - 1)));
                health = healthMax;

                CutScene.Sc19_Level_Up(level);
            }

        }
    }
}
*/