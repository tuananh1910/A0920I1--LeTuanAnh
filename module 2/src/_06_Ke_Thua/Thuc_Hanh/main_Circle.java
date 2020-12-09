package _06_Ke_Thua.Thuc_Hanh;

public class main_Circle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5,"indigo", false);
        System.out.println(circle);
    }
}
