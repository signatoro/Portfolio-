package Util;


import java.util.*;

public class Rng
{
    public static Random random = new Random(System.currentTimeMillis());

    public static double rangeDouble(double min, double max)
    {
        double number = (random.nextDouble() * ((max - min)) + min);
        return Math.round(number * 10) / 10.0;
    }
    //1 to 10 doubles
    public static double setDouble()
    {
        double number = (random.nextDouble() * 9 + 1);
        return Math.round(number * 10) / 10.0;
    }
    
    //Exclusive
    public static int rangeInt(int min, int max) 
    {
        int number = (int) (random.nextInt((max+1)-min) + min);
        return number;
    }
    
    public static int setInt()
    {
        int number = (int)(random.nextInt(10)+ 1);
        return number;
    }
}