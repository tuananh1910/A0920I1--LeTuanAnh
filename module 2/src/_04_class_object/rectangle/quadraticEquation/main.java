package _04_class_object.rectangle.quadraticEquation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a= ");
        double a = scanner.nextDouble();
        System.out.println("enter b= ");
        double b = scanner.nextDouble();
        System.out.println("enter c = ");
        double c = scanner.nextDouble();
        QuadraticEquation quaratic = new
                QuadraticEquation(a, b, c);
        double delta = quaratic.getDiscriminant();
        if (delta > 0) {
            System.out.println(quaratic.getRoot1());
            System.out.println(quaratic.getRoot2());
        } else if (delta == 0) {
            System.out.println(quaratic.get());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
