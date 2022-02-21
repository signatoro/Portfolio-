package Model;


import java.util.*;

import Util.Global;
import Util.LineClear;
import Util.RNG;
import Util.Sec;

public class BossBattle
{
    Scanner sc = new Scanner(System.in);
    
    public BossBattle ()
    {

    }

    public void MinotaurCombatLoop(double TplayerHealth, double TmaxPlayerHealth, int TLevel, Inventory inventory)
    {
        double PlayerHealth = TplayerHealth;
        double PlayerMaxHealth = TmaxPlayerHealth;

        int playerMagicUse = 0;
        int level = TLevel;


        String BossName = "Minotaur";
        double BossHealth = 100 + (3.5 * level);
        double enemyMultiplier = 4.5;
        int BossOption;

        


        
        while (BossHealth > 0) 
        {
            double playerDamage;
            double BossDamage;
            int BossAttack = 0;
            String choice;

            PlayerHealth = Math.round(PlayerHealth * 10) / 10.0;

            
            //Global.view.printText("What would you like to do?");
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
            // ****************************

            // HELP
            else if (choice.equalsIgnoreCase("help"))
            {
                InstruCreds instruc = new InstruCreds(5);

                Sec.delaySec(1);
                
                BossAttack = 1;
            }

            // Attack
            else if (choice.contains("attack with"))
            {
                String weapon = choice.substring(12);
                double hitPercent = RNG.setDouble();


                if (weapon.equalsIgnoreCase("hands"))
                {
                    if (hitPercent <= 7.5)
                    {

                        playerDamage = RNG.rangeDouble(0, 1.5) + level;

                        BossHealth = BossHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(BossName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(BossName, weapon);
                    }
                }
                else if (weapon.equalsIgnoreCase("Stick") && inventory.checkInventory(weapon))
                {
                    if (hitPercent <= 5.0)
                    {
                        playerDamage = RNG.rangeDouble(1, 3.5) + level;
                        BossHealth = BossHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(BossName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(BossName, weapon);
                    }
                }
                else if (weapon.equalsIgnoreCase("Rusty Dagger") && inventory.checkInventory(weapon))
                {
                    if (hitPercent <= 6.5)
                    {
                        playerDamage = RNG.rangeDouble(6, 8) + level;
                        BossHealth = BossHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(BossName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(BossName, weapon);
                    }
                }
                else if (weapon.equalsIgnoreCase("Rusty Sword") && inventory.checkInventory(weapon))
                {
                    if (hitPercent <= 8.5)
                    {
                        playerDamage = RNG.rangeDouble(9, 11) + level;
                        BossHealth = BossHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(BossName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(BossName, weapon);
                    }
                }
                else
                {
                    Global.view.printText("You can not attack with " + weapon);
                    BossAttack = 1;
                }            
            }

            // Cast Magic
            else if (choice.contains("cast spell with"))
            {
                String weapon = choice.substring(16);

                if (playerMagicUse <= 5)
                {
                    double hitPercent = RNG.setDouble();

                    // Stick
                    if (weapon.equalsIgnoreCase("Stick") && inventory.checkInventory(weapon))
                    {
                        if (hitPercent <= 4.5)
                        {
                            playerDamage = RNG.rangeDouble(4, 6) + (level / 2);
                            BossHealth = BossHealth - playerDamage;

                            CutScene.Sc9_Player_Magic_Hit(BossName, weapon, playerDamage);
                        }
                        else 
                        {
                            CutScene.Sc10_Player_Magic_Miss(BossName, weapon);

                        }
                        playerMagicUse = playerMagicUse + 1;
                    }
                    // Wood Wand
                    else if (weapon.equalsIgnoreCase("Wand") && inventory.checkInventory(weapon)) 
                    {
                        if (hitPercent <= 6.5) 
                        {
                            playerDamage = RNG.rangeDouble(7, 9) + (level / 2);
                            BossHealth = BossHealth - playerDamage;

                            CutScene.Sc9_Player_Magic_Hit(BossName, weapon, playerDamage);
                        } 
                        else 
                        {
                            CutScene.Sc10_Player_Magic_Miss(BossName, weapon);
                        }
                        playerMagicUse = playerMagicUse + 1;
                    }
                    // Elder Wand
                    else if (weapon.equalsIgnoreCase("Elder Wand") && inventory.checkInventory(weapon))
                    {
                        if (hitPercent <= 8.5) 
                        {
                            playerDamage = RNG.rangeDouble(8, 11) + (level / 2);
                            BossHealth = BossHealth - playerDamage;

                            CutScene.Sc9_Player_Magic_Hit(BossName, weapon, playerDamage);
                        } 
                        else 
                        {
                            CutScene.Sc10_Player_Magic_Miss(BossName, weapon);
                        }
                        playerMagicUse = playerMagicUse + 1;
                    }
                    else 
                    {
                        Global.view.printText("You can not cast magic with " + weapon);
                        BossAttack = 1;
                    }
                }
                else 
                {
                    CutScene.Sc11_Player_Out_Magic(BossName, weapon);
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
                    BossAttack = 1;
                }
                else 
                {
                    Global.view.printText("You can not use " + item + " in combat");
                    BossAttack = 1;
                }
            }
            // Check health
            else if (choice.contains("check"))
            {
                String check = choice.substring(6);

                if (check.equalsIgnoreCase("Health"))
                {
                    Global.view.printText("" + PlayerHealth);
                    BossAttack = 1;
                }
                else if (check.equalsIgnoreCase("inventory"))
                {
                    inventory.getInventory();
                    BossAttack = 1;
                }
                else
                {
                    Global.view.printText("You can not check " + check);
                    Global.view.printText("In combat you can only check your health");
                    BossAttack = 1;
                }
            }

            // Run
            else if (choice.contains("run"))
            {
                CutScene.Sc17_Running_Fail(BossName);
            }
            
            else
            {
                Global.view.printText("You can not do that.");
                Global.view.printText("If you don't know what to do type \"Help\".");
                BossAttack = 1;
            }
            

            // Check if Boss is Dead
            if (BossHealth <= 0)
            {
                break;
            }

            // Boss Attack
            if (BossAttack == 0)
            {
                BossOption = RNG.rangeInt(1, 3);

                // Charge
                if (BossOption == 1)
                {
                    double BossHitPercent = RNG.setDouble();
                    
                    if (BossHitPercent <= 8.5)
                    {
                        BossDamage = RNG.rangeDouble(7, 10);

                        PlayerHealth = PlayerHealth - BossDamage;

                        CutScene.Sc22_Charge_Hit(BossDamage);
                    }
                    else
                    {
                        CutScene.Sc23_Charge_Miss();
                    }
                }
                // Mace Attack 
                else if (BossOption == 2)
                {
                    double BossHitPercent = RNG.setDouble();

                    if (BossHitPercent <= 6.5)
                    {
                        BossDamage = RNG.rangeDouble(9, 12);

                        PlayerHealth = PlayerHealth - BossDamage;

                        CutScene.Sc24_Mace_Hit(BossDamage);
                    }
                    else 
                    {
                        CutScene.Sc25_Mace_Miss();
                    }
                }
                // Shout
                else if (BossOption == 3)
                {
                    BossDamage = RNG.rangeDouble(5, 6);

                    PlayerHealth = PlayerHealth - BossDamage;

                    CutScene.Sc26_Shout(BossDamage);
                }
            }

            // Check is dead
            if (PlayerHealth <= 0)
            {
                CutScene.Sc000_Killed(BossName);
            }

            BossAttack = 0;
            Global.view.printText();
            Global.view.printText();

        }

        CutScene.Sc100_Victory();
    }



    public void TrollCombatLoop(double TplayerHealth, double TmaxPlayerHealth, int TLevel, Inventory inventory)
    {
        double PlayerHealth = TplayerHealth;
        double PlayerMaxHealth = TmaxPlayerHealth;

        int playerMagicUse = 0;
        int level = TLevel;

        String BossName = "Troll";
        double BossHealth = 100 + (3.5 * level);
        double enemyMultiplier = 4.5;
        int BossOption;

        while (BossHealth > 0)
        {
            double playerDamage;
            double BossDamage;
            int BossAttack = 0;
            String choice;

            PlayerHealth = Math.round(PlayerHealth * 10) / 10.0;

            
            Global.view.printText("What would you like to do?");
            String cho = sc.nextLine();
            
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


            // SKIP
            if (choice.equalsIgnoreCase("skip")) 
            {
                Global.view.printText("You do nothing");
            }

            // HELP
            else if (choice.equalsIgnoreCase("help"))
            {
                InstruCreds instruc = new InstruCreds(5);

                Sec.delaySec(1);
                
                BossAttack = 1;
            }

            // Attack
            else if (choice.contains("attack with"))
            {
                String weapon = choice.substring(12);
                double hitPercent = RNG.setDouble();


                if (weapon.equalsIgnoreCase("hands"))
                {
                    if (hitPercent <= 7.5)
                    {

                        playerDamage = RNG.rangeDouble(0, 1.5) + level;

                        BossHealth = BossHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(BossName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(BossName, weapon);
                    }
                }
                else if (weapon.equalsIgnoreCase("Stick") && inventory.checkInventory(weapon))
                {
                    if (hitPercent <= 5.0)
                    {
                        playerDamage = RNG.rangeDouble(1, 3.5) + level;
                        BossHealth = BossHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(BossName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(BossName, weapon);
                    }
                }
                else if (weapon.equalsIgnoreCase("Rusty Dagger") && inventory.checkInventory(weapon))
                {
                    if (hitPercent <= 6.5)
                    {
                        playerDamage = RNG.rangeDouble(6, 8) + level;
                        BossHealth = BossHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(BossName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(BossName, weapon);
                    }
                }
                else if (weapon.equalsIgnoreCase("Rusty Sword") && inventory.checkInventory(weapon))
                {
                    if (hitPercent <= 8.5)
                    {
                        playerDamage = RNG.rangeDouble(9, 11) + level;
                        BossHealth = BossHealth - playerDamage;

                        CutScene.Sc7_Player_Melee_Hit(BossName, weapon, playerDamage);
                    }
                    else 
                    {
                        CutScene.Sc8_Player_Melee_Miss(BossName, weapon);
                    }
                }
                else
                {
                    Global.view.printText("You can not attack with " + weapon);
                    BossAttack = 1;
                }            
            }

            // Cast Magic
            else if (choice.contains("cast spell with"))
            {
                String weapon = choice.substring(16);

                if (playerMagicUse <= 5)
                {
                    double hitPercent = RNG.setDouble();

                    // Stick
                    if (weapon.equalsIgnoreCase("Stick") && inventory.checkInventory(weapon))
                    {
                        if (hitPercent <= 4.5)
                        {
                            playerDamage = RNG.rangeDouble(4, 6) + (level / 2);
                            BossHealth = BossHealth - playerDamage;

                            CutScene.Sc9_Player_Magic_Hit(BossName, weapon, playerDamage);
                        }
                        else 
                        {
                            CutScene.Sc10_Player_Magic_Miss(BossName, weapon);

                        }
                        playerMagicUse = playerMagicUse + 1;
                    }
                    // Wood Wand
                    else if (weapon.equalsIgnoreCase("Wand") && inventory.checkInventory(weapon)) 
                    {
                        if (hitPercent <= 6.5) 
                        {
                            playerDamage = RNG.rangeDouble(7, 9) + (level / 2);
                            BossHealth = BossHealth - playerDamage;

                            CutScene.Sc9_Player_Magic_Hit(BossName, weapon, playerDamage);
                        } 
                        else 
                        {
                            CutScene.Sc10_Player_Magic_Miss(BossName, weapon);
                        }
                        playerMagicUse = playerMagicUse + 1;
                    }
                    // Elder Wand
                    else if (weapon.equalsIgnoreCase("Elder Wand") && inventory.checkInventory(weapon))
                    {
                        if (hitPercent <= 8.5) 
                        {
                            playerDamage = RNG.rangeDouble(8, 11) + (level / 2);
                            BossHealth = BossHealth - playerDamage;

                            CutScene.Sc9_Player_Magic_Hit(BossName, weapon, playerDamage);
                        } 
                        else 
                        {
                            CutScene.Sc10_Player_Magic_Miss(BossName, weapon);
                        }
                        playerMagicUse = playerMagicUse + 1;
                    }
                    else 
                    {
                        Global.view.printText("You can not cast magic with " + weapon);
                        BossAttack = 1;
                    }
                }
                else 
                {
                    CutScene.Sc11_Player_Out_Magic(BossName, weapon);
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
                    BossAttack = 1;
                }
                else 
                {
                    Global.view.printText("You can not use " + item + " in combat");
                    BossAttack = 1;
                }
            }
            // Check health
            else if (choice.contains("check"))
            {
                String check = choice.substring(6);

                if (check.equalsIgnoreCase("Health"))
                {
                    Global.view.printText(PlayerHealth);
                    BossAttack = 1;
                }
                else if (check.equalsIgnoreCase("inventory"))
                {
                    inventory.getInventory();
                    BossAttack = 1;
                }
                else
                {
                    Global.view.printText("You can not check " + check);
                    Global.view.printText("In combat you can only check your health");
                    BossAttack = 1;
                }
            }
            // Run
            else if (choice.contains("run"))
            {
                CutScene.Sc17_Running_Fail(BossName);
            }
            else
            {
                Global.view.printText("You can not do that.");
                Global.view.printText("If you don't know what to do type \"Help\".");
                BossAttack = 1;
            }

            // Check if Boss is Dead
            if (BossHealth <= 0)
            {
                break;
            }
            
            // Boss Attack


        }
        
        
    }

}