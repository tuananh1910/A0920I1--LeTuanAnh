package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final String ID_REGEX =   "SV\\w{2}-\\d{4}";
    private static final String PHONE_REGEX="090\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}|\\(84\\)\\+90\\d{7}";
    private static final String CMND_REGEX="\\d{9}";
    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String NUMBER_REGEX ="^[1-9]\\d*$";
    private static final String NUMBER_DECIMAL ="^(\\d*\\.)?\\d+$";
    private static Pattern pattern ;
    private static Matcher matcher;

    public static boolean validateCMND(String rentCost){
        pattern = Pattern.compile(CMND_REGEX);
        matcher = pattern.matcher(rentCost);
        return matcher.matches();
    }
    public static boolean validateEmail(String rentCost){
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(rentCost);
        return matcher.matches();
    }
    public static boolean validatePhone(String rentCost){
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(rentCost);
        return matcher.matches();
    }
    public static boolean validateNumber(String rentCost){
        pattern = Pattern.compile(NUMBER_REGEX);
        matcher = pattern.matcher(rentCost);
        return matcher.matches();
    }
    public static boolean validateNumberDecimal(String rentCost){
        pattern = Pattern.compile(NUMBER_DECIMAL);
        matcher = pattern.matcher(rentCost);
        return matcher.matches();
    }

}
