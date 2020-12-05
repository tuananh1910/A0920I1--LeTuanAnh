package mangWeek1;

import java.util.Arrays;

public class findElementMax {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        int max = array[0][0];
        int x=0,y=0;
        for (int i=0 ;i<array.length;i++){
            for (int j=0;j<array.length;j++){
                if (max<array[i][j]){
                    max = array[i][j];
                    x=i;
                    y=j;
                }
            }
        }
        System.out.println(Arrays.deepToString(array));
        System.out.println("giá trị max "+ max+ ",toạ độ của max "+x+","+y);
    }
}
