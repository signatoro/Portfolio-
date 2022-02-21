package Util;

public class StringCleaner {

    public static String cleanString(String s) {
        
        String str = "";
        
        for (int i = 0; i < s.length(); i++) 
        {
            if (s.charAt(i) != ' ' || (i > 0 && i < s.length()-1 && s.charAt(i-1) != ' ' && s.charAt(i+1) != ' ' && s.charAt(i) == ' ' )) 
            {
                str += Character.toLowerCase(s.charAt(i));
            }

        }

        return str;
    }
}
