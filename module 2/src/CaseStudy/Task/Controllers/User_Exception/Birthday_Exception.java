package CaseStudy.Task.Controllers.User_Exception;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Birthday_Exception extends Exception {

    final String REGEX_BIRTHDAY = "^(?:(?:31(\\/|-|\\.)(?:" +
            "0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(" +
            "?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{" +
            "2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?" +
            ":0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]" +
            "|[3579][26])00))))$|^(?:0?[1-9]|1\\d|" +
            "2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(" +
            "?:1[6-9]|[2-9]\\d)?\\d{2})$ ";

    public Birthday_Exception(String s) {
        System.out.println(s);
    }

    public Birthday_Exception() {
    }

    public boolean birthday_Exception(String birthday) throws Birthday_Exception {
        Pattern pattern = Pattern.compile(REGEX_BIRTHDAY);
        Matcher matcher = pattern.matcher(birthday);
        boolean match = matcher.matches();
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String[] parts;
        int day_Birth = 0;
        int month_Birth = 0;
        int year_Birth = 0;
        if (!match) {
            if (birthday.contains("/")) {
                parts = birthday.split("/");
                day_Birth = Integer.parseInt(parts[0]);
                month_Birth = Integer.parseInt(parts[1]);
                year_Birth = Integer.parseInt(parts[2]);
            }
            if (birthday.contains("-")) {
                parts = birthday.split("-");
                day_Birth = Integer.parseInt(parts[0]);
                month_Birth = Integer.parseInt(parts[1]);
                year_Birth = Integer.parseInt(parts[2]);
            }if (birthday.contains(".")) {
                parts = birthday.split("\\.");
                day_Birth = Integer.parseInt(parts[0]);
                month_Birth = Integer.parseInt(parts[1]);
                year_Birth = Integer.parseInt(parts[2]);
            }
        }
        LocalDate start = LocalDate.of(year_Birth, month_Birth, day_Birth);
        LocalDate end = LocalDate.of(year, month, day);
        long years = ChronoUnit.YEARS.between(start, end);

        if (!(years > 18)) {
            throw new Birthday_Exception("The year of birth must be> 1900 and " +
                    "18 years less than the current year," +
                    " in the correct format dd / mm / yyyy");
        } else {
            return true;
        }

    }

}
