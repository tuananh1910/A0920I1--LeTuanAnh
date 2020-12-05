package mangWeek1;

import java.util.Scanner;

public class addElementArray {
    static int[] array;
    public static void main(String[] args) {
        int number, index;
        array = new int[]{1,2,3,4,5,6};
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("enter number =");
            number = scanner.nextInt();
            System.out.println("enter index =");
            index = scanner.nextInt();
        }
        while (index<-1||index>= array.length);
        int[] array_2 = new int[array.length+1];
        for (int i=0; i<index;i++){
            array_2[i]=array[i];
        }
        array_2[index]=number;
        for (int i=index+1;i<array_2.length;i++){
            array_2[i]=array[i-1];
        }

        for (int i=0;i<array.length;i++){
            System.out.println(array_2[i]);
        }
    }
}
