package Model;
import Util.Global;
import Util.LineClear;
import Util.Sec;

public class CutScene
{
    // Variables 

    public static int enemiesKilled;
    private static FindPosition pos = new FindPosition(0, 0);

    public static void Sc1()
    {
        Sec.delaySec(2);

        // Text 
        Global.view.printText("Our storee degins in the small town of Aelwyn, more acuratelee in the forest just north of the town.");
        Sec.delaySec(9);
        Global.view.printText("Yoo often come to the forest to get awa from the kid who pick on you for not being as smart as they are.");
        Sec.delaySec(8);
        Global.view.printText("But who cares if they are better at spelling, your gud at a lot of things they aren’t.");
        Sec.delaySec(10);
        Global.view.printText("You continu to let you’re mind wander had you head deapor and deypur into the forest.");
        Sec.delaySec(7);
        Global.view.printText("As you walk you can feel a slight breaze and smell the intoxicating erthy sent. As your walking something catches you’re i... a building!");
        Sec.delaySec(9);
        Global.view.printText("But its not a cottage or a hut, it's big, like really big it almost looks like a school.");
        Sec.delaySec(7);
        Global.view.printText("As you approach you ce this large gray rectangular building, with a red stripe running around it.");
        Sec.delaySec(8);
        Global.view.printText("You can see faded lettering in the red stryp that reeds  \"Pepper’s Mystical School of the Magic\".");
        Sec.delaySec(7);
        Global.view.printText("You walk up to the grand wooden boors and they open for you, intrigued you go in and as you do the boors close.");
        Sec.delaySec(8);
        Global.view.printText("Looking adout you see a dimley lit hallway with teal coloured lockors that line the walls to your east and west. ");
        Sec.delaySec(7);
        Global.view.printText("The hallway continues north.");
        Sec.delaySec(2);
    }

    
    public static double Sc2CrossRoads()
    {
        Global.view.printText("Yoo approach an intersecsion in the hallway, when you hear a soft pop, as you look over in the birecsion of the noise you see a veree tall and slendor man.");
        Sec.delaySec(8);
        Global.view.printText("He has stone grey skin with brite pink hair that floes down his face. He is bressed in a beautiful teal rowb that matches the lockers perfectly.");
        Sec.delaySec(7);
        Global.view.printText("As you look at him you can’t help but notice his radian bleu eys and the soft inviting smile across his fase.");
        Sec.delaySec(7);
        Global.view.printText("\"Hi, I’m Caduceus, Caduceus Clay that is, and I am, or more accurately was, the headmaster of this school\"");
        Sec.delaySec(8);
        Global.view.printText("His voice is deap and soft and has a soothing qualitee to it.");
        Sec.delaySec(7);
        Global.view.printText("\"I can sense your worry and anxiety, so I will pass on the advice that was once given to me.\"");
        Sec.delaySec(9);
        Global.view.printText("\"Your anxieties and worries do not define you, your strength to overcome them does.\"");
        Sec.delaySec(9);
        Global.view.printText("\"Back in its heyday this school was able to help a lot of people and I have a feeling that it’s not done helping.\"");
        Sec.delaySec(7);
        Global.view.printText("\"Speaking of helping you should grab the stick on the ground you never know how useful it might be.\"");
        Sec.delaySec(5);
        Global.view.printText("\"The three paths in front of you will all lead you to the destination you seek and remember your stronger come from within\"");
        Sec.delaySec(7);
        Global.view.printText("And with the swish of his robes he vanishes leeving pink flowers were he was standing. ");
        Sec.delaySec(6);
        Global.view.printText("There are 3 hallways in front of you, one heeding north, one east, and one west and at your feet is a weird looking stick.");
        Sec.delaySec(6);


        return .60;
    }

    // Openning a Chest
    public static void Sc3Chest()
    {
        Global.view.printText("As you are heeding along the bath your foot hits something hard.");
        Sec.delaySec(2);
        Global.view.printText("You look doun and ce a corner of a Chest Sticking out of the grownd");
        Sec.delaySec(3);
        Global.view.printText("You dig it up");
        Sec.delaySec(1);
    }

    /*
    // Say 
    public static void Sc4Say(String words)
    {
        Global.view.printText("You stand there shouting " + words.toUpperCase() + " at the top of your lung");
        Sec.delaySec(2);
        Global.view.printText("You stop to hear if there is a responce... ");
        Sec.delaySec(4);
        Global.view.printText("There is nothing");
        Sec.delaySec(4);
        Global.view.printText("You slow realise how stupid you are being");
        Sec.delaySec(2);
        Global.view.printText("You are lost in the forest. How is shouting " + words + " going to help you.");
        Sec.delaySec(1);
    }
    */
    // Sleep
    public static void Sc5Sleep()
    {
        Global.view.printText("You lay doun on the hard grownd and brift off to sleap.");
        Sec.delaySec(2);
        for (int i = 0; i < 5; i++)
        {
            System.out.print(". ");
            Sec.delayMil(10);
        }
        Global.view.printText();
        Global.view.printText("You wake up and feal revitalized.");
        Sec.delaySec(3);
    }

    // ********
    // ATTACK 

    // Enemey Encounter
    public static void Sc6_Enemy_Encounter(String enemyName) 
    {
        Global.view.printText("As you are walking along owt of nowhere a " + enemyName + " appears.");
        Sec.delaySec(3);
        Global.view.printText("You get reedy for battle.");
        Sec.delaySec(2);

        LineClear.ClearW(2);
        Global.view.printText("\t \t COMBAT");
    }

    // Player Melee Hit
    public static void Sc7_Player_Melee_Hit(String enemyName, String weapon, double damage)
    {
        Global.view.printText("You swing with you're " + weapon + " and hit the " + enemyName + ".");
        Sec.delaySec(2);
        Global.view.printText("You do " + damage + " points of damage to the " + enemyName + ".");
        Sec.delaySec(2);

        LineClear.ClearW(2);
    }
    // Player Melee Miss
    public static void Sc8_Player_Melee_Miss(String enemyName, String weapon) 
    {
        Global.view.printText("You swing with your " + weapon + " and miss the " + enemyName + ".");
        Sec.delaySec(2);
        
        LineClear.ClearW(2);
    }

    // Player Magic Hit
    public static void Sc9_Player_Magic_Hit(String enemyName, String weapon, double damage)
    {
        Global.view.printText("You take you're " + weapon + " and point it at the " + enemyName + ".");
        Sec.delaySec(2);
        Global.view.printText("You cleer you're mind and all of a sudden a fireball erupts from the " + weapon + " and hits the " + enemyName + ".");
        Sec.delaySec(3);
        Global.view.printText("You do " + damage + " points of damage to the " + enemyName + ".");
        Sec.delaySec(2);

        LineClear.ClearW(2);
    }

    // Player Magic Miss
    public static void Sc10_Player_Magic_Miss(String enemyName, String weapon)
    {
        Global.view.printText("You take you're " + weapon + " and point it at the " + enemyName + ".");
        Sec.delaySec(2);
        Global.view.printText("You try to cleer your mind but you can't.");
        Sec.delaySec(2);

        LineClear.ClearW(2);
    }
    
    // Player out of Magic
    public static void Sc11_Player_Out_Magic(String enemyName, String weapon) 
    {
        Global.view.printText("You take your " + weapon + " and point it at the " + enemyName + ".");
        Sec.delaySec(2);
        Global.view.printText("As you clear your minb, you can not longer feel the majical enerjee flowing through you.");
        Sec.delaySec(3);
        Global.view.printText("You feel that it will come back given some time.");
        Sec.delaySec(2);
        LineClear.ClearW(2);
    }


    // Enemy Hit 
    public static void Sc12_Enemy_Hit(String enemyName, double enemyDamage)
    {
        Global.view.printText("The " + enemyName  + " makes uses a magical purple attack and hits you.");
        Sec.delaySec(2);
        Global.view.printText("The " + enemyName + " does " + enemyDamage + " points of damage to you.");
        Sec.delaySec(2);
    }

    // Enemy Miss
    public static void Sc13_Enemy_Miss(String enemyName) 
    {
        Global.view.printText("The " + enemyName + " makes an attack.");
        Sec.delaySec(1);
        Global.view.printText("You are able to dodje out of the way of the " + enemyName + "\'s attack.");
        Sec.delaySec(2);
    }

    // Enemy Killed 
    public static void Sc14_Enemy_Killed(String enemyName) 
    {
        Global.view.printText("After a grulling dattle with the " + enemyName + " you are able to sla it.");
        Sec.delaySec(1);
        Global.view.printText("You have left combat.");
        Sec.delaySec(2);
        
        LineClear.ClearW(2);
        Global.view.printText("\t \t END OF COMBAT");
        LineClear.ClearW(1);        

        enemiesKilled = enemiesKilled + 1;
    }


    // **********


    // **********
    // COMBAT ACTIONS
    
    // Health Potion
    public static void Sc15_Health_Potion(double hpPoints) 
    {
        Global.view.printText();
        Global.view.printText("You grab your heelth posion from your bag and down the hole thing.");
        Sec.delaySec(2);
        Global.view.printText("You heel for "  + hpPoints + " points.");
        Sec.delaySec(1);
        Global.view.printText();
        Global.view.printText();
    }

    // Run Success 
    public static void Sc16_Running_Success(String enemy) 
    {
        Global.view.printText("Reelising you are owt matched you run for it.");
        Sec.delaySec(2);
        Global.view.printText("You look behind you and it appears the " + enemy + " you where fighting has disappeared.");
        Sec.delaySec(3);
        Global.view.printText();

    }
    // Run Fail
    public static void Sc17_Running_Fail(String enemy) 
    {
        Global.view.printText("Realising you are owt matched you try run for it.");
        Sec.delaySec(2);
        Global.view.printText("The " + enemy + " chases after you and you are unable to escape.");
        Sec.delaySec(2);
        Global.view.printText();
    }
    public static void Sc18_Combat_Instructions() 
    {
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
        // Check
        Global.view.printText("To Check your Inventory, Health, Level, or Xp you would type \"Check\" then what you want to check");
        Global.view.printText("    To check your health you would type \"Check health\"");
        Global.view.printText();
        // Run
        Global.view.printText("To run away you would type \"Run\" then North, East, South or West");
        Global.view.printText("    To run North you would type  \"Run North\"");
        Global.view.printText();
        Global.view.printText();
        Global.view.printText();
        
        Sec.delaySec((long) 5);
    }

    // **********

    
    public static void Sc19_Level_Up(int level) 
    {
        Global.view.printText("Pop...");
        Sec.delaySec(2);
        Global.view.printText("looking adout you see standing next to you is Caduceus with a large grin across his face.");
        Sec.delaySec(5);
        Global.view.printText("\"Look at you go, your progress has been very impressive, you look stronger already!\"");
        Sec.delaySec(5);
        Global.view.printText("\"When you put in all your effort and strength you will always be rewarded.\"");
        Sec.delaySec(4);
        Global.view.printText("And with that he vanishes in a buff of pink petals.");
        Sec.delaySec(3);


        Global.view.printText("\t\t YOU LEVELED UP");
        Sec.delaySec(1);
        Global.view.printText("You are now level " + level +".");
        Sec.delaySec(2);
        Global.view.printText("Your health has increase and you will now do more damage.");
        Sec.delaySec(3);
        Global.view.printText("You have also been fully healed.");
        Sec.delaySec(2);

    }


    // Boss Battle
    // *************************************************************

    

    public static void Sc20_Enter_Area() 
    {
        Global.view.printText("You here an all too familiar popping sownd and to your left you see Caduceus at your side once more.");
        Sec.delaySec(7);
        Global.view.printText("\"I\'m impressed but your greatest challenge still lies ahead of you, in the gym you will face a fear of yours.\"");
        Sec.delaySec(6);
        Global.view.printText("\"The power is within you and no one else, your strength will lead to victory ");
        Sec.delaySec(2);
        Global.view.printText("and your anxieties will lead to defeat, your destiny is up to you and no one else.\"");
        Sec.delaySec(9);
        Global.view.printText("\"Oh and one more thing, I know I can do it\" and with that he vanishes leaving you in a cloud of pink petals."); 
        Sec.delaySec(2);

    }

    public static void Sc21_Approach_Minotaur() 
    {
        Global.view.printText("As you approach the senter of the gym you heer a louwd whooshing and crinkling sounb.");
        Sec.delaySec(6);
        Global.view.printText("You look up just in thyme to see a large banner with the words School Spelling Bee written across it heeding strayt for you.");
        Sec.delaySec(9);
        Global.view.printText("You manaje to dodje out of the way but it looks like its getting ready to attack again.");
        Sec.delaySec(5);
        
        Global.view.printText("\t \t COMBAT");
        LineClear.ClearW(1);

    }

    // Charge
    public static void Sc22_Charge_Hit(double BossDamage) 
    {
        Global.view.printText("The Banner charges directly at you.");
        Sec.delaySec(2);
        Global.view.printText("The Banner raps you up and starts to squeaze you tightly");
        Sec.delaySec(3);
        Global.view.printText("The Banner does " + BossDamage + " points of damage to you.");
        Sec.delaySec(3);
    }
    public static void Sc23_Charge_Miss() 
    {
        Global.view.printText("The Banner charges directly at you.");
        Sec.delaySec(2);
        Global.view.printText("But you are able to quicklee duck and dodje out of the way.");
        Sec.delaySec(3);
    }

    // Mace attack
    public static void Sc24_Mace_Hit(double BossDamage) 
    {
        Global.view.printText("The Banner lashes owt and strikes you with its sharp edjes");
        Sec.delaySec(2);
        Global.view.printText("You try to dodje but Banner is two quick and cuts you.");
        Sec.delaySec(3);
        Global.view.printText("The Banner does " + BossDamage + " points of damage to you.");
        Sec.delaySec(3);
    }
    public static void Sc25_Mace_Miss() 
    {
        Global.view.printText("The Banner lashes owt.");
        Sec.delaySec(2);
        Global.view.printText("But you quickly dodje out of the way.");
        Sec.delaySec(3);
    }

    // Shout
    public static void Sc26_Shout(double BossDamage)
    {
        Global.view.printText("The letters on the Banner start to glowing a dark purple");
        Sec.delaySec(2);
        Global.view.printText("You feal a sence a panic thinking that you are going to have to spell infront of everyone.");
        Sec.delaySec(3);
        Global.view.printText("The Banner does " + BossDamage + " points of damage to you.");
        Sec.delaySec(3);
    }
    
    // **********************************************************

    // Rusty Sword
    public static void Sc26_Rusty_Sword()
    {
        Global.view.printText("As you are heading along you see something shiny.");
        Sec.delaySec(2);
        Global.view.printText("You run over to be for your eyes is a rusty sword.");
        Sec.delaySec(3);
        Global.view.printText("There is a Rusty sword on the ground.");
        Sec.delaySec(1);
    }

    // Continue
    public static void Sc27_Continue(int x, int y, double health, int level)
    {
        Global.view.printText("You enter the world of Taro.");
        Sec.delaySec(2);
        Global.view.printText("You have " + health + " Hp.");
        Sec.delaySec(1);
        Global.view.printText("And you are level " + level);
        Sec.delaySec(1);

        LineClear.ClearW(5);
        pos.MoveResponce(x, y);
        Global.view.printText();
    }

    // Enter Cave
    public static void Sc_Enter_Cave()
    {
        Global.view.printText("You see a booring labeled Basement Acccess.");
        Sec.delaySec(2);
        Global.view.printText("You feal drawn to it and enter. You follow a long winding path.");
        Sec.delaySec(3);
        Global.view.printText("Eventually it levels owt and you are in a dank and bark dasement.");
        Sec.delaySec(2);
        Global.view.printText("There are walls to the north and south of you.");
        Sec.delaySec(2);
    }
    // Exit Cave 
    public static void Sc_Exit_Cave()
    {
        Global.view.printText("You see light coming from a stair case");
        Sec.delaySec(2);
        Global.view.printText("You follow it up and c familiar halls of the school");
        Sec.delaySec(3);
        Global.view.printText("There are walls north and south of you.");
        Sec.delaySec(2);
    }


    // TROLL
    public static void Sc_Troll_Approach () 
    {
        Global.view.printText("The basement opens up into a large areya");
        Sec.delaySec(1);
        Global.view.printText("Standing in the middle is a Troll, it is surrownded the bones of its fallin victims.");
        Sec.delaySec(4);
        Global.view.printText("Its stench is horrific.");
        Sec.delaySec(3);
    }

    public static void Sc_Troll_Combat()
    {
        Global.view.printText("You approach the Troll.");
        Sec.delaySec(1);
        Global.view.printText("Reedy for the battle of your life.");
        Sec.delaySec(2);

        LineClear.ClearW(2);
        Global.view.printText("\t \t COMBAT");
        LineClear.ClearW(1);
    }

    public static void Sc_Troll_Bite_Hit(double BossDamage)
    {
        Global.view.printText("The Troll opens its mowth and goes to bite you");
        Sec.delaySec(2);
        Global.view.printText("You feal its sharp teath sync into your flesh");
        Sec.delaySec(3);
        Global.view.printText("The Troll does " + BossDamage + " points of damage to you.");
        Sec.delaySec(3);
    }

    public static void Sc_Troll_Bite_Miss() 
    {
        Global.view.printText("The Troll opens its mowth and goes to bite you");
        Sec.delaySec(2);
        Global.view.printText("But you are able to dodje owt of the way");
        Sec.delaySec(3);    
    }

    public static void Sc_Troll_Claw_Hit(double BossDamage)
    {
        Global.view.printText("The Troll charjes toward you swinging it arms wildly.");
        Sec.delaySec(2);
        Global.view.printText("It comes so quickly that you are unable to dodje its sharp claws.");
        Sec.delaySec(3);
        Global.view.printText("The Troll does " + BossDamage + " points of damage to you.");
        Sec.delaySec(3);
    }

    public static void Sc_Troll_Claw_Miss()
    {
        Global.view.printText("The Troll charjes toward you swinging it arms wildlee.");
        Sec.delaySec(2);
        Global.view.printText("You act quickly and dodje owt of the way of its razor sharp claws.");
        Sec.delaySec(3);
    }

    public static void Sc_Troll_Killed() 
    {
        Global.view.printText("With that last hit the Troll goes limp and you can ce their is no life left in it.");
        Sec.delaySec(2);
        Global.view.printText("You look at the beest and think to yourself how luckee you are to have beaten this beest");
        Sec.delaySec(3);

        LineClear.ClearW(2);
        Global.view.printText("\t \t END OF COMBAT");
        LineClear.ClearW(1);

        enemiesKilled += 3;
    }




    public static void instructions() {
       
        // Commands during Exploration
        Global.view.printText("Commands While Exploring");
        // Move
        Global.view.printText("To Move you would type \"Go\" then North, East, South or West");
        Global.view.printText("    To go North you would type \"Go North\"");

        // Pick up
        Global.view.printText("To Pick stuff up you would type \"Grab\" then the name of the item");
        Global.view.printText("    To pick up a stick you would time \"Grab Stick\"");

        // Say
        Global.view.printText("To Say something you would type \"Say\" then what you want to say");
        Global.view.printText("    To say hello you would type \"Say Hello\"");

        // Check
        Global.view.printText("To Check your Inventory or Health you would type \"Check\" then what you want to check");
        Global.view.printText("    To check your health you would type \"Check health\"");

        // Open
        Global.view.printText("To Open something you would type \"Open\" then what you want to open");
        Global.view.printText("    To open a chest you would type \"Open Chest\"");

        // Inspect
        Global.view.printText("To Inspect an item you would type \"Inspect\" then type the item name");
        Global.view.printText("    To inspect a stick you would type \"Inspect Stick\"");
        Global.view.printText();


        // Commands During Combat
        Global.view.printText("Commands During Combat");

        // Sword
        Global.view.printText("To Attack with an weapon you would type \"Attack with\" then the name of the weapon");
        Global.view.printText("    To attack with a sword you would type \"Attack with sword\"");

        // Magic
        Global.view.printText("To cast a spell you would type \"Cast spell with\" then the item that can cast magic");
        Global.view.printText("    To cast a spell you would type  \"Cast spell with wand\"");

        // Use
        Global.view.printText("To drink a potion you would type \"Use\" then the name of the potion");
        Global.view.printText("    To drink a health potion you would type  \"Use health potion\"");
        // Run
        Global.view.printText("To run away you would type \"Run\" then North, East, South or West");
        Global.view.printText("    To run North you would type  \"Run North\"");
        Global.view.printText();

        // General Command & Infor
        Global.view.printText("General Commands & Information");
        
        // Rest
        Global.view.printText("In order to restore Hp you can Rest, but you can only rest 3 times.");
        Global.view.printText("    To rest type \"Rest\"");

        // Help
        Global.view.printText("If you for get the Commands you can type \"Help\" and it will bring up this list");

        // Case
        Global.view.printText("The commands are not case sensitve");

    }

    //  Death
    public static void Sc000_Killed(String enenmyName) 
    {
        LineClear.ClearW(10);
        Global.view.printText("After a grulling battle with a " + enenmyName + " you have no enerjy left.");
        Sec.delaySec(5);
        Global.view.printText("The " + enenmyName + " has beeten you. You fought as hard as you could. . .");
        Sec.delaySec(7);

        LineClear.ClearW(11);

        Global.view.printText("You here a soft voice in your ear");
        Sec.delaySec(4);
        Global.view.printText("\"Life and death... ying and yangs... the world exists in a delicate balance but now is not your time.\"");
        Sec.delaySec(7);

        Global.view.printText("\"Failure should not be shunned or discouraged. We learn more about ourselves through failure than through success.\"");
        Sec.delaySec(6);
    }

    //  Death
    public static void Sc001_Killed(String enenmyName) 
    {
        Global.view.printText("After a grulling battle with a " + enenmyName + " you have no enerjy left.");
        Sec.delaySec(3);
        Global.view.printText("The " + enenmyName + " has beeten you. You fought as hard as you could. . .");
        Sec.delaySec(5);
        Global.view.printText("But is was not enough.");
        Sec.delaySec(3);

        Global.view.printText("You fall to the ground and accept your fate.");
        Sec.delaySec(7);

        LineClear.ClearW(10);
        Global.view.printText("\t \t \t Game Over");
        LineClear.ClearNW(4);

        Sec.delaySec(5);

        System.exit(0);

    }
    /*
    Global.view.printText("");
    Sec.delaySec(5);

    */

    public static void Sc100_Victory() 
    {
        
        Global.view.printText("After all you’re mite and energy you manajed to conker the large parchment leaving it in tatters on the grownd of the gym.");
        Sec.delaySec(6);
        Global.view.printText("\"I knew you could do it\" You look over and see an ecstatic Caduceus looking over at you.");
        Sec.delaySec(6);
        Global.view.printText("\"I could see your strength all along but you needed to discover it for yourself.\"");
        Sec.delaySec(7);
        Global.view.printText("\"Now take the lessons you learned here and conquer your fears show the world the true you\"");
        Sec.delaySec(10);


        LineClear.ClearW(10);
        Global.view.printText("Game Over");
        LineClear.ClearNW(4);

        Sec.delaySec(10);

        System.exit(0);
    }
    

    /*
    public static void Sc1980()
    {
        Global.view.printText("Just as you are about to leave an old man appears in front of you.");
        Sec.delaySec(3);
        Global.view.printText("He is tall, thin, and very old, judging by the silver of his hair and beard.");
        Sec.delaySec(3);
        Global.view.printText("He is wearing long robes, a purple cloak that swept the ground, and buckled boots.");
        Sec.delaySec(4);
        Global.view.printText("His blue eyes were light, bright, and sparkling behind half-moon spectacles.");
        Sec.delaySec(4);
        Global.view.printText("and his nose was very long and crooked, as though it had been broken at least twice.");
        Sec.delaySec(5);
        Global.view.printText("As you stare at him he says \"Help will always be given to those who ask for it\"");
        Sec.delaySec(4);
        Global.view.printText("He reaches into his robes and pulls out an odd stick and gives it to you");
        Sec.delaySec(4);
        Global.view.printText("As you open to mouth to ask the millions of questions you have he vanishish.");
        Sec.delaySec(5);

    }
    */

}
