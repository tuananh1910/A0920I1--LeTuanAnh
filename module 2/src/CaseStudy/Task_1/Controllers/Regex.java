package CaseStudy.Task_1.Controllers;

import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    String FORMAT_CODE_SERVICE ;
    String FORMAT_NAME_SERVICE = "^[A-Z][a-z]$";
    String FORMAT_NUMBER = "^[0-9]$";
    Matcher matcher;
    public boolean check_Format_Code_Service(String string, String name) {
        if (name.equals("Villa")) {
            FORMAT_CODE_SERVICE ="^[S][V][V][L][-][0-9]{4}$";
            Pattern pattern = Pattern.compile(FORMAT_CODE_SERVICE);
            matcher = pattern.matcher(string);
        }
        if (name.equals("House")){
            FORMAT_CODE_SERVICE ="^[S][V][H][O][-][0-9]{4}$";
            Pattern pattern = Pattern.compile(FORMAT_CODE_SERVICE);
            matcher = pattern.matcher(string);
        }
        if (name.equals("Room")){
            FORMAT_CODE_SERVICE ="^[S][V][R][O][-][0-9]{4}$";
            Pattern pattern = Pattern.compile(FORMAT_CODE_SERVICE);
            matcher = pattern.matcher(string);
        }
        boolean match = matcher.matches();
        return match;
    }
    public boolean check_Name_Service(String string, String name){
        if (name.equals("Villa")) {
            Pattern pattern = Pattern.compile(FORMAT_NAME_SERVICE);
            matcher = pattern.matcher(string);
        }
        if (name.equals("House")){
            Pattern pattern = Pattern.compile(FORMAT_NAME_SERVICE);
            matcher = pattern.matcher(string);
        }
        if (name.equals("Room")){
            Pattern pattern = Pattern.compile(FORMAT_NAME_SERVICE);
            matcher = pattern.matcher(string);
        }
        boolean match = matcher.matches();
        return match;
    }

    public boolean check_Number(String string, String name){
        if (name.equals("Villa")) {
            Pattern pattern = Pattern.compile(FORMAT_NUMBER);

            matcher = pattern.matcher(string);
        }
        if (name.equals("House")){
            Pattern pattern = Pattern.compile(FORMAT_NUMBER);
            matcher = pattern.matcher(string);
        }
        if (name.equals("Room")){
            Pattern pattern = Pattern.compile(FORMAT_NUMBER);
            matcher = pattern.matcher(string);
        }
        boolean match = matcher.matches();
        return match;
    }
}
