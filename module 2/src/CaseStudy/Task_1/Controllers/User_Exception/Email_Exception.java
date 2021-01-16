package CaseStudy.Task_1.Controllers.User_Exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email_Exception extends Exception {
    final String REGIX_EMAIL ="^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";

    public Email_Exception(String s) {
        System.out.println(s);
    }

    public Email_Exception() {

    }

    public boolean email_Exeption(String email) throws Email_Exception {
        boolean match;
        Pattern pattern = Pattern.compile(REGIX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        match = matcher.matches();
        if (!match){
            throw new Email_Exception("Email must be in the correct format abc@abc.abc ");
        }
        else {
            return true;
        }
    }

}
