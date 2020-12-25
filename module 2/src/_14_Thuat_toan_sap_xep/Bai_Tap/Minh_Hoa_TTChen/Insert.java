package _14_Thuat_toan_sap_xep.Bai_Tap.Minh_Hoa_TTChen;

import java.util.Arrays;

public class Insert {
    static int[] arrayInt = {6,5,3,1,8,4,7,2,4};
    public static void main(String[] args) {
        int temp;
        for (int i=0;i<arrayInt.length;i++){
            temp = arrayInt[i];
            int j=i-1;
            while (j>=0&&arrayInt[j]<temp){
                arrayInt[j+1]=arrayInt[j];
                j=j-1;
            }
            arrayInt[j+1] = temp;
        }
        System.out.println(Arrays.toString(arrayInt));
    }
}
