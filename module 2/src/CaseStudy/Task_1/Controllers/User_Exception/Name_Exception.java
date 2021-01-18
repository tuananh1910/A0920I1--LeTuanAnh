package CaseStudy.Task_1.Controllers.User_Exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name_Exception extends Exception {
    final String REGIX_NAME = "([A-Z]+[a-z]+ )"; //Le_Tuan_Anh_

    public Name_Exception(String s) {
        System.out.println(s);
    }

    public Name_Exception() {

    }


    public boolean name_Exeption(String name) throws Name_Exception {
        boolean match;
        Pattern pattern = Pattern.compile(REGIX_NAME);
        Matcher matcher = pattern.matcher(name);
        match = matcher.matches();

        if (!match) {
            throw new Name_Exception("The first character of the name must be capitalized ");
        } else {
            return true;
        }
    }
}
