package mangWeek1;

import java.util.Arrays;
import java.util.Scanner;

public class findMinArr {
    static int[] array;
    public static void main(String[] args) {
        int size =0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập size của mảng =");
        size = scanner.nextInt();
        int[] array = new int[size];
        for (int i=0;i<size;i++){
            System.out.println("Nhập giá trị phần tử thứ "+i);
            array[i] = scanner.nextInt();
        }
        int min = array[0];
        for (int i=0;i<size;i++){
            if (min>array[i]){
                min = array[i];
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("min ="+min);
    }
}
