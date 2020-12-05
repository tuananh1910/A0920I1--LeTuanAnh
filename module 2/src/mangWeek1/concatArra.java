package mangWeek1;

import java.util.Arrays;
import java.util.Scanner;

public class concatArra {
    public static void main(String[] args) {
        int[] array_1 = new int[5];
        int[] array_2 = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i=0;i<array_1.length;i++){
            System.out.println("Nhập giá trị thứ " + i + "của mang1 =");
            array_1[i] = scanner.nextInt();
        }
        for (int i=0;i<array_2.length;i++){
            System.out.println("Nhập giá trị thứ " + i + "của mang2 =");
            array_2[i] = scanner.nextInt();
        }
        int[] array_3 = new int[(array_1.length+array_2.length)];
        for (int i=0 ; i<array_1.length;i++){
            array_3[i] = array_1[i];
        }
        int check =0;
        for (int i=array_1.length;i<array_3.length;i++){
            for (int j=0;j<=check;j++){
                array_3[i] = array_2[j];
            }
            check++;
        }
        System.out.println(Arrays.toString(array_3));
    }
}
