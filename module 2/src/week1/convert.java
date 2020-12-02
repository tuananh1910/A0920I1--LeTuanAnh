package week1;

import java.util.Scanner;

public class convert {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int usd, vnd;
        System.out.println("Nhap USD =");
        usd = scanner.nextInt();
        vnd = usd*23000;
        System.out.println(vnd);
    }
}
