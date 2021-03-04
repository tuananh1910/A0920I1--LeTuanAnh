package CaseStudy.Refesh.Common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    static String FORMAT_ID_SERVICE;
    static String FORMAT_NAME_SERVICE = "^[A-Z]+[a-z]+$";
    static String FORMAT_NUMBER = "^[0-9]+.[0-9]+$";
    static String FORMAT_SERVICE_FREE = "massage||karaoke||food||drink||car";
    static Pattern pattern;
    static Matcher matcher;
    static boolean match;
    public static boolean check_Id_Service(String string, int number){

        switch (number){
            case 1:
                FORMAT_ID_SERVICE ="^[S][V][V][L][-][0-9]{4}$";
                break;
            case 2:
                FORMAT_ID_SERVICE ="^[S][V][H][O][-][0-9]{4}$";
                break;
            case 3:
                FORMAT_ID_SERVICE ="^[S][V][R][O][-][0-9]{4}$";
                break;
            default:
                break;
        }
        pattern = Pattern.compile(FORMAT_ID_SERVICE);
        matcher = pattern.matcher(string);
        match = matcher.matches();
        return match;
    }
    public static boolean check_Service(String string){
       pattern = Pattern.compile(FORMAT_NAME_SERVICE);
       matcher = pattern.matcher(string);
       match= matcher.matches();
       return !match;
    }
    public static boolean check_Number_Double(String string){
        pattern = Pattern.compile(FORMAT_NUMBER);
        matcher= pattern.matcher(string);
        match = matcher.matches();
        return !match;
    }
    public static boolean check_Number_Int(String string){
        pattern = Pattern.compile("^[0-9]+$");
        matcher = pattern.matcher(string);
        return !matcher.matches();
    }
    public static boolean check_Service_Free(String string){
        pattern=Pattern.compile(FORMAT_SERVICE_FREE);
        matcher = pattern.matcher(string);
        return !matcher.matches();
    }
}
