package _07_Abstract_Interface.Bai_Tap.Interface_Resizeable;

import _06_Ke_Thua.Thuc_Hanh.Circle;
import _06_Ke_Thua.Thuc_Hanh.Rectangle;
import _06_Ke_Thua.Thuc_Hanh.Shape;
import _06_Ke_Thua.Thuc_Hanh.Square;

import java.util.Scanner;

public class main_Interface_Resizeable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2.0,"blue",true);
        shapes[1] = new Rectangle(2.0,3.0,"blue",true);
        shapes[2] = new Square(4.0,"red",true);

        System.out.println("truoc khi tang kich thuoc");
        for (Shape shape :shapes){
            System.out.println(shape);
        }
        System.out.println("nhap percent muon tang =");
        double percent = scanner.nextDouble();
        System.out.println("sau khi tang kich thuoc :");

        for (Shape shape :shapes){
            if ( shape instanceof Circle){
                Interface_Resizeable interface_resizeable1
                        = (Circle) shape;
                interface_resizeable1.resize(percent);
            }
            else if (shape instanceof Rectangle){
                Interface_Resizeable interface_resizeable2
                        = (Rectangle) shape;
                interface_resizeable2.resize(percent);
            }
            else if (shape instanceof Square){
                Interface_Resizeable interface_resizeable3
                        = (Square) shape;
                interface_resizeable3.resize(percent);
            }
            System.out.println(shape);
        }
    }
}
