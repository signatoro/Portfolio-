package Model;
import Util.Global;
import Util.RNG;
import Util.Sec;

public class CombatActions
{
    public static boolean Can_Attack = true;
    public static boolean Run_Away = false;


    public static double[] Player_Action(Inventory inventory, int Ilevel, int IplayerMagicUse, double IplayerHealth, double IplayerMaxHealth, boolean isBossBattle, String IEnemyName, String choice)
    {
        Can_Attack = true;
        Run_Away = false;

        int level = Ilevel;
        int playerMagicUse = IplayerMagicUse;

        double PlayerHealth = IplayerHealth;
        double PlayerMaxHealth = IplayerMaxHealth;

        double[] Damage_Health = new double[2];

        // boolean isBossBattle = IisBossBattle;

        String enemyName = IEnemyName;

        double playerDamage = 0;

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
            
            Can_Attack = false;
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
                Can_Attack = false;
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
                        playerDamage = RNG.rangeDouble(7, 9) + (level / 2);
                        

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
                        playerDamage = RNG.rangeDouble(8, 11) + (level / 2);
                        

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
                    Can_Attack = false;
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
                Can_Attack = false;
            }
            else 
            {
                Global.view.printText("You can not use " + item + " in combat");
                Can_Attack = false;
            }
        }
        // Check health
        else if (choice.contains("check"))
        {
            String check = choice.substring(6);

            if (check.equalsIgnoreCase("Health"))
            {
                Global.view.printText(PlayerHealth);
                Can_Attack = false;
            }
            else if (check.equalsIgnoreCase("inventory"))
            {
                inventory.getInventory();
                Can_Attack = false;
            }
            else
            {
                Global.view.printText("You can not check " + check);
                Global.view.printText("In combat you can only check your health");
                Can_Attack = false;
            }
        }
        // Run
        else if (choice.contains("run"))
        {
            double runPercent = RNG.setDouble(); 

            // Boost
            if (inventory.checkInventory("Boots"))
            {
                runPercent += 2;
            }

            // Checking
            if (isBossBattle)
            {
                CutScene.Sc17_Running_Fail(enemyName);
            }
            else 
            {                
                if (runPercent >= 7.5)
                {
                    CutScene.Sc16_Running_Success(enemyName);
                    Run_Away = true;
                }
                else
                {
                    CutScene.Sc17_Running_Fail(enemyName);
                }

            }
        }
        
        
        else
        {
            Global.view.printText("You can not do that.");
            Global.view.printText("If you don't know what to do type \"Help\".");
            Can_Attack = false;
        }

        Damage_Health[0] = playerDamage;
        Damage_Health[1] = PlayerHealth;

        return Damage_Health;

    }

    // Normal Enemy Attack
    public static double Normal_Enemy_Attack(double enemyMultiplier, String enemyName)
    {
        double hitPercent = RNG.setDouble();
        double enemyDamage = 0;

        if (hitPercent + (enemyMultiplier - 1.5) <= 6.5)
        {
            enemyDamage = Math.round((RNG.rangeDouble(1, 4) * enemyMultiplier)* 10) /10.0;


            CutScene.Sc12_Enemy_Hit(enemyName, enemyDamage);
        }
        else 
        {
            CutScene.Sc13_Enemy_Miss(enemyName);
        }

        return enemyDamage;
    }

    public static double Troll_Attack()
    {
        double BossOption = RNG.rangeInt(1, 2);
        double BossDamage = 0;

        // Bite
        if (BossOption == 1)
        {
            double BossHitPercent = RNG.setDouble();
            
            if (BossHitPercent <= 7.5)
            {
                BossDamage = RNG.rangeDouble(3, 6);
                CutScene.Sc_Troll_Bite_Hit(BossDamage);
            }
            else
            {
                CutScene.Sc_Troll_Bite_Miss();
            }
        }

        // Claw
        else if (BossOption == 2)
        {
            double BossHitPercent = RNG.setDouble();

            if (BossHitPercent <= 6.5)
            {
                BossDamage = RNG.rangeDouble(7, 10);
                CutScene.Sc_Troll_Claw_Hit(BossDamage);
            }
            else 
            {
                CutScene.Sc_Troll_Claw_Miss();
            }
        }
        return BossDamage;
    }

    // Minotuar 
    public static double Minotaur_Attack()
    {
        double BossOption = RNG.rangeInt(1, 3);
        double BossDamage = 0;

        // Charge
        if (BossOption == 1)
        {
            double BossHitPercent = RNG.setDouble();
            
            if (BossHitPercent <= 8.5)
            {
                BossDamage = RNG.rangeDouble(7, 10);

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

            CutScene.Sc26_Shout(BossDamage);
        }

        return BossDamage;
    }

}