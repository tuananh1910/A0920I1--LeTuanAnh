package _06_Ke_Thua.Thuc_Hanh.BaiTap.Triangle;

import _06_Ke_Thua.Thuc_Hanh.Shape;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public Triangle() {
    }

    public double Area() {
        double p = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return area;
    }

    public double Perimeter() {
        return (side3 + side2 + side1);
    }

    @Override
    public String toString() {
        return "3 canh tam giac a, b, c = " + getSide1()
                + " " + getSide2() + " " + getSide3() + ", Area = " + Area()
                + ", Perimeter = " + Perimeter()+" " + super.toString();

    }
}
