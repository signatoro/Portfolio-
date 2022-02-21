package Model;
/*
import java.util.*;

import Model.Depreciated.Enemies;
import Util.Global;
import Util.LineClear;
import Util.Sec;
import Util.StringCleaner;

public class Combat
{
    private static Enemies enemies = new Enemies();
    private static Scanner sc = new Scanner(System.in);

    public static double CombatLoop(double TplayerHealth, double TmaxPlayerHealth, int TLevel, double posId, Inventory inventory)
    {
        String enemyName ="";
        double playerHealth = TplayerHealth;
        double playerMaxHealth = TmaxPlayerHealth;

        double enemyHealth = 0;
        double enemyMultiplier = 0;

        int playerMagicUse = 0;
        int level = TLevel;

        boolean bossBattle;
        boolean Troll = false;
        boolean Minotaur = false;

        
        enemyName = enemies.EnemyFinder(posId);
        
        if (posId >= .56)
        {
            bossBattle = true;
            if (posId == .56)
            {
                enemyHealth = 30 + (3.5 * level);
                enemyMultiplier = 4.5;
                Troll = true;
            }
            else if (posId == .57)
            {
                enemyHealth = 60 + (3.5 * level);
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
            enemyHealth = 7 * level +(enemyMultiplier * level);
            CutScene.Sc6_Enemy_Encounter(enemyName);
        }

        

        while (enemyHealth > 0)
        {

            double playerDamage = 0;
            double enemyDamage = 0 ;
            double[] Damage_Health = new double[2];

            playerHealth = Math.round(playerHealth * 10) / 10.0;

            
            String choice = StringCleaner.cleanString(Global.view.getInput());
            

            Sec.delaySec(1);


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
                CutScene.enemiesKilled += (int)(enemyMultiplier);
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
                if (Minotaur || Troll) {
                    CutScene.Sc001_Killed(enemyName);
                }
                else {
                    CutScene.Sc000_Killed(enemyName);
                    return 5;
                }
            }

        }
        CutScene.enemiesKilled += (int)(enemyMultiplier);
        return playerHealth;
    }
}
*/