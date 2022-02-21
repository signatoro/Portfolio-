package Model.Depreciated;

import Util.Global;
import Util.Sec;

public class Move
{

    //private FindPosition pos = new FindPosition(0,0);

    public Move ()
    {
        // Lol nothing is here
    }

    public int goNorth(int X, int Y)
    {
        int x = X - 1 ;
        int y = Y;

        double tile = 0;
        if (tile == .00)
        {
            //pos.MoveResponce(x, y);
            x += 1;
        }
        else if (tile >= .10)
        {
            Global.view.printText("Yoo hed North.");
        }
        else 
        {
            Global.view.printText("You broke the game try again");
            x +=1;
            return x;
        }
        Sec.delaySec(1);
        //pos.MoveResponce(x, y);
        Sec.delaySec(1);
        return x;
    }

    public int goSouth(int X, int Y)
    {
        int x = X + 1 ;
        int y = Y;
        
        double tile  = 0;
        if (tile == .00)
        {
            //pos.MoveResponce(x, y);
            x -= 1;

        }
        else if(tile >= .10)
        {
            Global.view.printText("Yoo head South.");
        }
        else 
        {
            Global.view.printText("You broke the game try again");
            x -= 1;
            return x;
        }
        Sec.delaySec(1);
        //pos.MoveResponce(x, y);
        Sec.delaySec(1);
        return x;
    }
    
    public int goEast(int X, int Y)
    {
        int x = X;
        int y = Y + 1;

        double tile  = 0; //= pos.CheckPos(x, y);
        if (tile == .00) 
        {
            //pos.MoveResponce(x, y);
            y -= 1;
        } 
        else if (tile >= .10) 
        {
            Global.view.printText("Yoo hed East.");

        } 
        else 
        {
            Global.view.printText("You broke the game try again.");
            y -= 1;
            return y;
        }

        Sec.delaySec(1);
        //pos.MoveResponce(x, y);
        Sec.delaySec(1);
        return y;

    }
    
    public int goWest(int SX, int SY)
    {
        int x = SX;
        int y = SY - 1;

        double tile = 0; //= pos.CheckPos(x, y);
        if (tile == .00) 
        {
            //pos.MoveResponce(x, y);
            y += 1;
        } 
        else if (tile >= .10) 
        {
            Global.view.printText("Yoe head West.");
        } 
        else 
        {
            Global.view.printText("You broke the game try again");
            y += 1;
            return y;
        }
        Sec.delaySec(1);
        //pos.MoveResponce(x, y);
        Sec.delaySec(1);
        return y;

    }

}