package _15_Xu_li_ngoai_le_Debug.Bai_Tap;

import java.util.Scanner;

public class Tam_Giac{
    public static void main(String[] args) {
        double canh_1, canh_2, canh_3 ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 3 cạnh của 1 tam giác :");
        try {
            canh_1=scanner.nextDouble();
            canh_2=scanner.nextDouble();
            canh_3=scanner.nextDouble();
        }
        catch ( e){
            System.err.println("xảy ra ngoại lệ : "+e.getMessage());
        }
        finally {
            System.out.println("Finish");
        }
        System.out.println("là 3 cạnh của tam giác");
    }
}
