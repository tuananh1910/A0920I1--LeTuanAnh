package CaseStudy.Task_1.Controllers;

import java.util.Calendar;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
//        Calendar cal = Calendar.getInstance();
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//        int month = cal.get(Calendar.MONTH)+1;
//        int year = cal.get(Calendar.YEAR);
//        System.out.println(day + " " +month+" "+year);
        Scanner scanner = new Scanner(System.in);
        String gender = scanner.nextLine();
        gender = gender.substring(1).toUpperCase() + gender.substring(1).toLowerCase();
    }
}
