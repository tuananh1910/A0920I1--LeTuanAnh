package CaseStudy.Task_1.Controllers;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
//        Calendar cal = Calendar.getInstance();
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//        int month = cal.get(Calendar.MONTH)+1;
//        int year = cal.get(Calendar.YEAR);
//        System.out.println(day + " " +month+" "+year);
        Scanner scanner = new Scanner(System.in);
//        String gender = scanner.nextLine();
//        gender = gender.substring(1).toUpperCase() + gender.substring(1).toLowerCase();
//        double a ;
//        System.out.println("nhap a = ");
//        a = scanner.nextDouble();
//        System.out.println(String.valueOf(a));
//        Pattern pattern = Pattern.compile("^[0-9].[0-9]$");
//        Matcher matcher = pattern.matcher(String.valueOf(a));
//        boolean match = matcher.matches();
//        System.out.println(match);
//        System.out.println((false&&true));
        String string;
        System.out.println("Nhap String");
        string = scanner.nextLine();
        string += " ";
        System.out.println(string);
        Pattern pattern = Pattern.compile("([A-Z]+[a-z]+ )");
        Matcher matcher = pattern.matcher(string);
        boolean match = matcher.matches();
        System.out.println(match);
    }
}
