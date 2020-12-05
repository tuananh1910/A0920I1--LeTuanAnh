package mangWeek1;

import java.util.Scanner;

public class countCharacter {
    public static void main(String[] args) {
        String string = "what hh your name ";
        char[] array = string.toCharArray();
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter character want to find");
        String charac = scanner.nextLine();
        char[] cha = charac.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (cha[0] == array[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
