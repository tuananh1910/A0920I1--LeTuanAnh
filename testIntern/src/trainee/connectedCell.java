package trainee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class connectedCell {
    public static int connectedCell(List<List<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix.get(i).get(j) == 1) {
                    int size = findLargestRegion(matrix, i, j, rows, cols);
                    result = Math.max(result, size);
                }
            }
        }
        return result;
    }

    private static int findLargestRegion(List<List<Integer>> matrix, int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix == null || matrix.get(row).get(col) == 0) {
            return 0;
        }

        matrix.get(row).set(col, 0);
        int size = 1;   // have 1
        // count unit size
        for (int i = row - 1; i <= row + 1; i++) {

            for (int j = col - 1; j <= col + 1; j++) {
                size += findLargestRegion(matrix, i, j, rows, cols);
            }
        }
        return size;
    }

    public static void main(String[] args) throws IOException {
//        List<Integer> D = new ArrayList<>();
//        D.add(1);
//        D.add(1);
//        D.add(0);
//        D.add(0);
//        List<Integer> A = new ArrayList<>();
//        A.add(1);
//        A.add(1);
//        A.add(1);
//        A.add(0);
//        List<Integer> B = new ArrayList<>();
//        B.add(0);
//        B.add(0);
//        B.add(1);
//        B.add(0);
//        List<Integer> C= new ArrayList<>();
//        C.add(1);
//        C.add(0);
//        C.add(0);
//        C.add(0);
//        List<List<Integer>> arr = new ArrayList<>();
//        arr.add(D);
//        arr.add(A);
//        arr.add(B);
//        arr.add(C);
//        System.out.println(connectedCell(arr));
    }
}
