package Util;


public class Sec
{
    // Seconds
    public static void delaySec(long seconds)
    {

        long time = seconds * 1000;

        try
        {
            Thread.sleep(time);
        }
        catch (Exception e)
        {
            Global.view.printError(e.getLocalizedMessage());
        }
    }
    //Milliseconds
    public static void delayMil(long mil)
    {

        long time = mil;

        try
        {
            Thread.sleep(time);
        }
        catch (Exception e)
        {
            Global.view.printError(e.getLocalizedMessage());
        }
    }
}