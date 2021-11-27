package trainee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class days30 {

    public static void main(String[] args) {
        List<Integer> arr= new ArrayList<>();
        arr.add(1);
        arr.add(4);
        arr.add(3);
        arr.add(2);
        for (int i = 0 ; i < (arr.size()/2);i++){
            int temp = arr.get(i);
            arr.set(i,arr.get(arr.size()-i-1));
            arr.set(arr.size()-1-i,temp);
        }

        for (int i : arr){
            System.out.println(i);
        }
    }

}
