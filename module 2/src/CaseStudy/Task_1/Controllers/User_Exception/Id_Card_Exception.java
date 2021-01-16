package CaseStudy.Task_1.Controllers.User_Exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Id_Card_Exception extends Exception {
    final String REGIX_ID_CARD = "[0-9][0-9][0-9][ ][0-9][0-9][0-9][ ][0-9][0-9][0-9][ ]";

    public Id_Card_Exception(String s) {
        System.out.println(s);
    }

    public Id_Card_Exception() {

    }

    public boolean id_Card_Exception(String id_card) throws Id_Card_Exception {
        Pattern pattern = Pattern.compile(REGIX_ID_CARD);
        Matcher matcher = pattern.matcher(id_card);
        boolean macth = matcher.matches();
        if (!macth){
            throw new Id_Card_Exception("ID Card must be correct format XXX XXX XXX");
        }
        else {
            return true;
        }
    }
}
