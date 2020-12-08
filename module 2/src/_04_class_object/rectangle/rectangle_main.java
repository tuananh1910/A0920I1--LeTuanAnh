package _04_class_object.rectangle;

import java.util.Scanner;

public class rectangle_main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width:");
        double width = scanner.nextDouble();
        System.out.print("Enter the height:");
        double height = scanner.nextDouble();
        rectangle Retangle = new rectangle(width, height);
        System.out.println("Your Rectangle \n"+ Retangle.display());
        System.out.println("Perimeter of the Rectangle: "+ Retangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ Retangle.getArea());
    }
}
