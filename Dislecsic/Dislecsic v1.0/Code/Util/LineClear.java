package Util;
public class LineClear
{
    //Cla
    public static void ClearW()
    {
        for (int i = 0; i < 20; i++) 
        {
            Global.view.printText(" ");
            Sec.delayMil((long) 1);
        }
    }
    
    public static void ClearW(int lines)
    {

        for (int i = lines; i > 0; i--) 
        {
            Global.view.printText(" ");
            Sec.delayMil((long)1500);
        }
    }
    
    public static void ClearNW() 
    {
        for (int i = 0; i < 20; i++) 
        {
            Global.view.printText(" ");
        }
    }

    public static void ClearNW(int lines) 
    {
        for (int i = lines; i > 0; i--) 
        {
            Global.view.printText(" ");
        }
    }
}