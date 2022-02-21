
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controller.GameLoop;
import Model.CutScene;
import Model.ExitAndContinue;
import View.GuiView;
import Util.GameState;
import Util.Global;
import Util.LineClear;
import Util.Sec;

public class MainStarter 
{
    public static void main(String[] args)
    {
        ExitAndContinue.getFile();

        Global.view = new GuiView("GAME");
        Thread thread = new Thread("New Thread") {
            public void run(){
                Global.view.update();
            }
         };
         thread.start();



        Global.gamestate = GameState.MENU;
        Global.view.panelSwitcher(Global.gamestate);
        

        /*
        Global.gamestate = GameState.PLAY;
        Global.view.gameScreen();
        CutScene.instructions();

        Sec.delaySec(10);
        System.exit(0);

        */





    }
}


// Cool Idea
/**
 * The game is running even if you arenet typing. Could do a cool idea like that game is still moving
 * Paths will be blocked if you move to slow or take longer to type. 
 */




