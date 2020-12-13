package _07_Abstract_Interface.Bai_Tap.Interface_Colorable;

import _06_Ke_Thua.Thuc_Hanh.Circle;
import _06_Ke_Thua.Thuc_Hanh.Rectangle;
import _06_Ke_Thua.Thuc_Hanh.Shape;
import _06_Ke_Thua.Thuc_Hanh.Square;

public class main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2.0, "blue", true);
        shapes[1] = new Rectangle(2.0, 3.0, "blue", true);
        shapes[2] = new Square(4.0, "red", true);

        System.out.println("ban dau : ");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println("Sau khi : ");
        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                Interface_Colorable interface_colorable = (Square) shape;
                interface_colorable.HowToColor();
            } else {
                System.out.println(shape);
            }
        }
    }
}
