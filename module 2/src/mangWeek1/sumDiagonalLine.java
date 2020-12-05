package mangWeek1;

import java.util.Scanner;

public class sumDiagonalLine {
    static int[][] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size, sum=0;
        System.out.println("Nhập size mảng vuông =");
        size = scanner.nextInt();
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("Nhập giá trị phần tử thứ ["+i+","+j+"]");
                array[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < size; i++) {
                sum += array[i][i];
        }
        for (int i=0;i<size;i++){
                sum += array[i][array.length-1-i];
        }
        System.out.println(sum);
    }
}
