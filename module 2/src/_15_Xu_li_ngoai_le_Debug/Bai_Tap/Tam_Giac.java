package _15_Xu_li_ngoai_le_Debug.Bai_Tap;

import java.util.Scanner;

public class Tam_Giac{
    public static void main(String[] args) {
        double canh_1, canh_2, canh_3 ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 3 cạnh của 1 tam giác :");

            canh_1=scanner.nextDouble();
            canh_2=scanner.nextDouble();
            canh_3=scanner.nextDouble();
        check(canh_1,canh_2,canh_3);
    }
    public static void check(double canh1, double canh2, double canh3){
        try {
            if (canh1 < 0 || canh2 < 0 || canh3 < 0) {
                throw new IllegalTriangleException();
            } else {
                if (canh1 + canh2 < canh3 || canh1 + canh3 < canh2 || canh2 + canh3 < canh1) {
                    throw new IllegalTriangleException();
                } else {
                    System.out.println("La canh cua tam giac");
                }
            }
        } catch (IllegalTriangleException e) {
            System.err.println("xay ra ngoai le");
        }

    }
}
