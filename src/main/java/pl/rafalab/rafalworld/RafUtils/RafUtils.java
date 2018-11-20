package pl.rafalab.rafalworld.RafUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RafUtils {

    public static boolean checkEmailOrPassword(String pattern, String toMatch) {

        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(toMatch);
        return matcher.matches();


    }


}
