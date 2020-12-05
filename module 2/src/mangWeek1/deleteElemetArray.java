package mangWeek1;

import java.util.Scanner;

public class deleteElemetArray {
    static int[] array;
    public static void main(String[] args) {
        int indel_del=0;
        array = new int[]{1,2,3,4,5,6,0,0,0,0};
        Scanner scanner= new Scanner(System.in);
        System.out.println("enter element delete =");
        int number = scanner.nextInt();
        for (int i=0;i<array.length;i++){
            if (number == array[i]){
                indel_del=i;
            }
        }
        for (int j=indel_del; j<array.length;j++){
            if (j==(array.length-1)){
                array[array.length-1]=0;
                break;
            }
            array[j]= array[j+1];
        }
        for (int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
