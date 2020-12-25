package _13_Thuat_Toan_TIm_Kiem.Bai_Tap.StringcConsecutive;

import java.util.LinkedList;
import java.util.Scanner;

public class StringConsecutive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String");
        String string = scanner.nextLine();
        LinkedList<Character> max= new LinkedList<>();

        for (int i=0;i<string.length();i++){
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j=i+1;j<string.length();j++){
                for (int k=j+1;k< string.length();k++) {
                    if (string.charAt(j) > list.getLast()) {
                        list.add(string.charAt(j));
                    }
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
