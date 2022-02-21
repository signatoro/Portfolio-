package Model;

import java.util.Scanner;

import Util.Global;
import Util.LineClear;
import Util.RNG;
import Util.Sec;

public class Combats
{
    Enemies enemies = new Enemies();
    Scanner sc = new Scanner (System.in);

    private double PlayerHealth;
    private double PlayerMaxHealth;
    private int level;

    public Combats(double Playerhealth, double PlayerMaxHealth, int level)
    {
        this.PlayerHealth = Playerhealth;
        this.PlayerMaxHealth = PlayerMaxHealth;
        this.level = level;
    }

    public double combatLoop(double posId, Inventory inventory)
    {
        
        String enemyName = enemies.EnemyFinder(posId);
        double enemyMultiplier = enemies.EnemyMultiplierFinder(posId);
        double enemyHealth = 5 * enemyMultiplier;
        double playerMagicUse = 0;

        CutScene.Sc6_Enemy_Encounter(enemyName);
        Global.view.printText();


        while (enemyHealth > 0) 
        {
            double playerDamage;
            double enemyDamage;
            int enemyAttack = 0;
            String choice;
            PlayerHealth = Math.round(PlayerHealth * 10) / 10.0;


            
            String cho = Global.view.getInput();
            
            // Remove Space and lowercase
            String tempChoice = "";
            if (cho.substring(cho.length()-1).equals(" "))
            {
                for(int i = 0; i < cho.length() - 1; i++)
                {
                    tempChoice = tempChoice + cho.substring(i, i + 1);
                }
            }
            else 
            {
                tempChoice = cho;
            }
            choice = tempChoice.toLowerCase();

            Sec.delaySec(1);
            LineClear.ClearW(2);


            // Temporaty For Programmer
            // ********************************************
            
            
            if (choice.equalsIgnoreCase("skip")) 
            {
                Global.view.printText("You do nothing");
            }

            // HELP
            else if (choice.equalsIgnoreCase("help"))
            {
                InstruCreds instruc = new InstruCreds(5);

                Sec.delaySec(1);
                
                enemyAttack = 1;
            }
            else if (choice.contains("attack with"))
            {
                String weapon = choice.substring(12);
                double hitPercent = RNG.setDouble();


                if (weapon.equalsIgnoreCase("hands"))
                {
                    if (hitPercent <= 7.5)
                    {

                        playerDamage = RNG.rangeDouble(0, 1.5) + level;

                        enemyHealth = enemyHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(enemyName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(enemyName, weapon);
                    }
                }
                else if (weapon.equalsIgnoreCase("Stick") && inventory.checkInventory(weapon))
                {
                    if (hitPercent <= 5.0)
                    {
                        playerDamage = RNG.rangeDouble(1, 3.5) + level;
                        enemyHealth = enemyHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(enemyName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(enemyName, weapon);
                    }
                }
                else if (weapon.equalsIgnoreCase("Rusty Dagger") && inventory.checkInventory(weapon))
                {
                    if (hitPercent <= 6.5)
                    {
                        playerDamage = RNG.rangeDouble(6, 8) + level;
                        enemyHealth = enemyHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(enemyName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(enemyName, weapon);
                    }
                }
                else if (weapon.equalsIgnoreCase("Rusty Sword") && inventory.checkInventory(weapon))
                {
                    if (hitPercent <= 8.5)
                    {
                        playerDamage = RNG.rangeDouble(9, 11) + level;
                        enemyHealth = enemyHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(enemyName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(enemyName, weapon);
                    }
                }
                else
                {
                    Global.view.printText("You can not attack with " + weapon);
                    enemyAttack = 1;
                }            
            }

            // Cast Magic
            else if (choice.contains("cast spell with"))
            {
                String weapon = choice.substring(16);

                // Addition Use
                int bonusMagic = 0;
                if (inventory.checkInventory("Cloth Robes"))
                {
                    bonusMagic = 1;
                }

                // Casting
                if (playerMagicUse <= 5 + bonusMagic)
                {
                    double hitPercent = RNG.setDouble();

                    // Stick
                    if (weapon.equalsIgnoreCase("Stick") && inventory.checkInventory(weapon))
                    {
                        if (hitPercent <= 4.5)
                        {
                            playerDamage = RNG.rangeDouble(4, 6);
                            enemyHealth = enemyHealth - playerDamage;

                            CutScene.Sc9_Player_Magic_Hit(enemyName, weapon, playerDamage);
                        }
                        else 
                        {
                            CutScene.Sc10_Player_Magic_Miss(enemyName, weapon);

                        }
                        playerMagicUse = playerMagicUse + 1;
                    }
                    // Wood Wand
                    else if (weapon.equalsIgnoreCase("Wand") && inventory.checkInventory(weapon))
                    {
                        if (hitPercent <= 6.5) 
                        {
                            playerDamage = RNG.rangeDouble(7, 9);
                            enemyHealth = enemyHealth - playerDamage;

                            CutScene.Sc9_Player_Magic_Hit(enemyName, weapon, playerDamage);
                        } 
                        else 
                        {
                            CutScene.Sc10_Player_Magic_Miss(enemyName, weapon);
                        }
                        playerMagicUse = playerMagicUse + 1;
                    }

                    // Elder Wand
                    else if (weapon.equalsIgnoreCase("Elder Wand") && inventory.checkInventory(weapon))
                    {
                        if (hitPercent <= 8.5) 
                        {
                            playerDamage = RNG.rangeDouble(8, 11);
                            enemyHealth = enemyHealth - playerDamage;

                            CutScene.Sc9_Player_Magic_Hit(enemyName, weapon, playerDamage);
                        } 
                        else 
                        {
                            CutScene.Sc10_Player_Magic_Miss(enemyName, weapon);
                        }
                        playerMagicUse = playerMagicUse + 1;
                    }
                    else 
                    {
                        Global.view.printText("You can not cast magic with " + weapon);
                        enemyAttack = 1;
                    }
                }
                else 
                {
                    CutScene.Sc11_Player_Out_Magic(enemyName, weapon);
                }
            }

            // Use
            else if (choice.contains("use"))
            {
                String item = choice.substring(4);

                if (item.equalsIgnoreCase("health potion") && inventory.checkInventory(item))
                {
                    double healthGain = (5 * (level + .5));
                    if ((PlayerHealth + healthGain) <= PlayerMaxHealth)
                    {
                        PlayerHealth = PlayerHealth + healthGain;
                        CutScene.Sc15_Health_Potion(healthGain);
                    }
                    else if ((PlayerHealth + healthGain) > PlayerMaxHealth)
                    {
                        PlayerHealth = PlayerMaxHealth;
                        CutScene.Sc15_Health_Potion(healthGain);
                    }
                    
                    inventory.removeItem(item);
                }
                else if (!(inventory.checkInventory(item)))
                {
                    Global.view.printText("You do not have " + item + " in your inventory.");
                    Global.view.printText();
                    enemyAttack = 1;
                }
                else 
                {
                    Global.view.printText("You can not use " + item + " in combat");
                    enemyAttack = 1;
                }
            }
            // Check health
            else if (choice.contains("check"))
            {
                String check = choice.substring(6);

                if (check.equalsIgnoreCase("Health"))
                {
                    Global.view.printText("" + PlayerHealth);
                    enemyAttack = 1;
                }
                else if (check.equalsIgnoreCase("inventory"))
                {
                    inventory.getInventory();
                    enemyAttack = 1;
                }
                else
                {
                    Global.view.printText("You can not check " + check);
                    Global.view.printText("In combat you can only check your health");
                    enemyAttack = 1;
                }
            }

            // Run
            else if (choice.contains("run"))
            {
                double runPercent = RNG.setDouble();
                
                if (inventory.checkInventory("Boots"))
                {
                    runPercent =+ 2;
                }

                if (runPercent >= 7.5)
                {
                    CutScene.Sc16_Running_Success(enemyName);
                    return PlayerHealth;
                }
                else
                {
                    CutScene.Sc17_Running_Fail(enemyName);
                }
            }
            
            else
            {
                Global.view.printText("You can not do that.");
                Global.view.printText("If you don't know what to do type \"Help\".");
                enemyAttack = 1;
            }
            

            // Check if Enenmy is Dead
            if (enemyHealth <= 0)
            {
                break;
            }

            // Enemy Attack
            if (enemyAttack == 0)
            {
                double hitPercent = RNG.setDouble();


                if (hitPercent + (enemyMultiplier - 1.5) <= 6.5)
                {
                    enemyDamage = Math.round((RNG.rangeDouble(1, 4) * enemyMultiplier)* 10) /10.0;

                    PlayerHealth = PlayerHealth - enemyDamage;

                    CutScene.Sc12_Enemy_Hit(enemyName, enemyDamage);
                }
                else 
                {
                    CutScene.Sc13_Enemy_Miss(enemyName);
                }
            }


            // Check is dead
            if (PlayerHealth <= 0)
            {
                CutScene.Sc000_Killed(enemyName);
                return 1;
            }

            enemyAttack = 0;
            Global.view.printText();
            Global.view.printText();

        }
        
        CutScene.Sc14_Enemy_Killed(enemyName);
        return PlayerHealth;
    }
}
