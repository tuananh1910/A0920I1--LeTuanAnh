package week1;

import java.util.Scanner;

public class alertHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name ;
        System.out.println("Enter Your Name:");
        name = scanner.nextLine();
        System.out.println("Hello:" + name );
    }
}
