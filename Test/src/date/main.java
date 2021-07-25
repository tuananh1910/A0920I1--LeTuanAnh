package date;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] x = new int[]{1, 3, 5, 8};
        int temp = x[x.length-1];
        x[x.length - 1] = x[0];
        x[0] = temp;
        System.out.print(Arrays.toString(x));
    }

}
