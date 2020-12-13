package _07_Abstract_Interface.Thuc_Hanh.Comparator;

import _06_Ke_Thua.Thuc_Hanh.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "indigo", false);

        System.out.println("Truoc khi sap xep:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("Sau khi sap xep:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}

