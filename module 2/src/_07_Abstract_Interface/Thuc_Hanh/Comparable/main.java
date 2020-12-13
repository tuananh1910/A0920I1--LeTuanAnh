package _07_Abstract_Interface.Thuc_Hanh.Comparable;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(3.5, "indigo", false);


        System.out.println("truoc khi sap xep :");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        System.out.println("sau khi sap xep :");
        Arrays.sort(circles);
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

    }
}
