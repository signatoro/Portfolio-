package Model;

import java.util.*;

import Util.Global;
import Util.LineClear;
import Util.Sec;

public class Combat
{
    private static Enemies enemies = new Enemies();
    private static Scanner sc = new Scanner(System.in);

    public static double CombatLoop(double TplayerHealth, double TmaxPlayerHealth, int TLevel, double posId, Inventory inventory)
    {
        double playerHealth = TplayerHealth;
        double playerMaxHealth = TmaxPlayerHealth;

        double enemyHealth = 0;
        double enemyMultiplier = 0;

        int playerMagicUse = 0;
        int level = TLevel;

        boolean bossBattle;
        boolean Troll = false;
        boolean Minotaur = false;

        
        String enemyName = enemies.EnemyFinder(posId);
        
        if (posId >= .56)
        {
            bossBattle = true;
            if (posId == .56)
            {
                enemyHealth = 100 + (3.5 * level);
                enemyMultiplier = 4.5;
                Troll = true;
            }
            else if (posId == .57)
            {
                enemyHealth = 200 + (3.5 * level);
                enemyMultiplier = 4.5;
                Minotaur = true;
            }
            else 
            {
                Global.view.printText();
                Global.view.printText("ERROR ERROR ERROR ERROR");
                Global.view.printText();
                Sec.delaySec(10);
            }

        }
        else 
        {
            bossBattle = false;
            enemyMultiplier = enemies.EnemyMultiplierFinder(posId);
            enemyHealth = 5 * enemyMultiplier;
        }

        CutScene.Sc6_Enemy_Encounter(enemyName);

        while (enemyHealth > 0)
        {

            double playerDamage = 0;
            double enemyDamage = 0 ;
            double[] Damage_Health = new double[2];

            String choice;

            playerHealth = Math.round(playerHealth * 10) / 10.0;

            
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


            // Player Action
            Damage_Health = CombatActions.Player_Action(inventory, level, playerMagicUse, playerHealth, playerMaxHealth, bossBattle, enemyName, choice);
            
            playerDamage = Damage_Health[0];
            playerHealth = Damage_Health[1];

            // Dealing Damage
            enemyHealth -= playerDamage;

            // Check if enemy dead or ran away 
            if(enemyHealth <= 0 || CombatActions.Run_Away)
            {
                if(Minotaur)
                {
                    CutScene.Sc100_Victory();
                }
                else if (CombatActions.Run_Away)
                {
                    return playerHealth;
                }
                else 
                {
                    CutScene.Sc14_Enemy_Killed(enemyName);
                }
                return playerHealth;
            }

            // Enemy Attack 
            if(CombatActions.Can_Attack)
            {
                // Non-Boss Attack
                if (!(bossBattle))
                {
                    enemyDamage = CombatActions.Normal_Enemy_Attack(enemyMultiplier, enemyName);
                }
                else if (bossBattle && Troll)
                {
                    enemyDamage = CombatActions.Troll_Attack();
                }
                else if (bossBattle && Minotaur)
                {
                    enemyDamage = CombatActions.Minotaur_Attack();
                }
                else 
                {
                    Global.view.printText();
                    Global.view.printText("ERROR ERROR ERROR ERROR");
                    Global.view.printText();
                    Sec.delaySec(10);
                }
            }

            playerHealth -= enemyDamage;
   
            // Check is dead
            if (playerHealth <= 0)
            {
                CutScene.Sc000_Killed(enemyName);
            }

            Global.view.printText();
            Global.view.printText();
        }
        return 9999999.9999999;

    }
}