package mangWeek1;

import java.util.Scanner;

public class sumColArr {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        Scanner scanner = new Scanner(System.in);
        int sumCol = 0;
        int col ;
        do {
            System.out.println("nhập cột thứ muốn tính =");
            col = scanner.nextInt();
        }
        while (col<0 || col >=array.length );
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length;j++){
                if (j==col){
                    sumCol += array[i][j] ;
                }
            }
        }
        System.out.println("tổng của cột thứ " + col + " = "+sumCol);
    }
}
