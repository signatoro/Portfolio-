package Util;


import java.util.*;

public class RNG
{
    public static double rangeDouble(double min, double max)
    {
        double number = (Math.random() * ((max - min)) + min);
        return Math.round(number * 10) / 10.0;
    }
    public static double setDouble()
    {
        double number = (Math.random() * 9 + 1);
        return Math.round(number * 10) / 10.0;
    }
    
    public static int rangeInt(int min, int max) 
    {
        int number = (int) (Math.random() * (max) +min);
        return number;
    }
    public static int setInt()
    {
        int number = (int)(Math.random() * 9 + 1);
        return number;
    }
}