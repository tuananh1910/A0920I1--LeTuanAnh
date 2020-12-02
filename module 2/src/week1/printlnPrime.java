package week1;

import java.util.Scanner;

public class printlnPrime {
    public static void main(String[] args) {
        int check =0;
        int prime;
        int cout=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number prime");
        prime = scanner.nextInt();
        for (int i=2;i>0;i++){
            for (int j=1;j<=i;j++){
                if (i%j==0){
                   cout++;
                }
            }
            if (cout<3){
                System.out.println(i);
                check++;
            }
            cout =0;
            if (prime==check){
                break;
            }
        }
    }
}
