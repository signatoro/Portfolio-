package Controller;

// Imports
import java.util.*;

import Model.BossBattle;
import Model.Combat;
import Model.CutScene;
import Model.ExitAndContinue;
import Model.FindPosition;
import Model.Grab;
import Model.InstruCreds;
import Model.Intro;
import Model.Inventory;
import Model.Items;
import Model.Move;
import Model.Open;
import Util.GameState;
import Util.Global;
import Util.LineClear;
import Util.Sec;
import Util.FileMan.SaveFile;

public class GameLoop
{
    // Class 
    /*
     * Find Postion 
     * Pick Up 
     * Move 
     * Invetory
     */
    Scanner sc = new Scanner(System.in);
    Move move = new Move();
    Items items = new Items();
    Open op = new Open();
    Grab grab = new Grab();
    BossBattle boss = new BossBattle();
    Inventory inventory = new Inventory();
    FindPosition pos = new FindPosition(37, 15);


    
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

    // First Call
    public GameLoop(int SX, int SY, double SHealth, int SLevel, int SrestCounter, int enemiesKilled, boolean Cave)
    {
        x = SX;
        y = SY;
        health = SHealth;
        level = SLevel;
        healthMax = (20 + (5.25 * (level - 1)));
        restCounter = SrestCounter;
        CutScene.enemiesKilled = enemiesKilled;
        cave = Cave;
        CutScene.Sc1();

        while (Loop != 1)
        {
            String choice;
            health = Math.round(health * 10) / 10.0;

            cho = Global.view.getInput();


            String tempChoice = "";
            int change = 0;
            for (int i = cho.length() - 1; i > 0; i--) 
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
                String direction = choice.substring(3);

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
                }

            }

            // GRAB
            else if (choice.contains("grab"))
            {
                if (pos.CheckPos(x, y) >= .60 && pos.CheckPos(x, y) <= .66)
                {
                    item = choice.substring(5);
                    if (item.equalsIgnoreCase(items.ItemFinder(pos.CheckPos(x, y))))
                    {
                        Global.view.printText("You grab the " + items.ItemFinder(pos.CheckPos(x, y)) + " and put it in your inventory." );
                        
                        inventory.addItem(items.ItemFinder(pos.CheckPos(x, y)));
                        
                        pos.ChangeId(x, y, .10);
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
            */

            // CHECK
            else if (choice.contains("check"))
            {
                String checkWhat = choice.substring(6);

                if (checkWhat.equalsIgnoreCase("Inventory"))
                {
                    inventory.getInventory();
                }
                else if (checkWhat.equalsIgnoreCase("Health"))
                {
                    Global.view.printText("You have " + health + " Hp");
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
                String openWhat = choice.substring(5);
                if (openWhat.equalsIgnoreCase("Chest"))
                {
                    if (pos.CheckPos(x, y) >= .30 && pos.CheckPos(x, y) <= .36)
                    {
                        pos.ChangeId(x, y, op.OpenChest(pos.CheckPos(x, y)));
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
                String inspectItem = choice.substring(8);

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
            else if (choice.equals("exit"))
            {
                String FileName = ExitAndContinue.ExitSave();

                SaveFile.Saving_Game_Files(x, y, health, level, restCounter, enemiesKilled, cave, FileName);

                Intro starter = new Intro();
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
                pos.ChangeId(x, y, newPosId);
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
            }

            // ITEM ON GROUND
            else if (pos.CheckPos(x, y) >= .60 && pos.CheckPos(x, y) <= .66)
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
                boss.MinotaurCombatLoop(health, healthMax, level, inventory);
            }

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