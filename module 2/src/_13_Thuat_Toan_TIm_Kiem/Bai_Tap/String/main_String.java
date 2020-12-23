package _13_Thuat_Toan_TIm_Kiem.Bai_Tap.String;

import java.util.LinkedList;
import java.util.Scanner;

public class main_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String");
        String string = scanner.nextLine();
        LinkedList<Character> max= new LinkedList<>();

        // đẩy từng kí tự trong String vào LinkedList list
        for (int i=0;i<string.length();i++){
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j=i+1;j<string.length();j++){
                if (string.charAt(j)>list.getLast()){
                    list.add(string.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        for (Character ch: max) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
