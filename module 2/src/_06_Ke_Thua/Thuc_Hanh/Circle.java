package _06_Ke_Thua.Thuc_Hanh;

import _07_Abstract_Interface.Bai_Tap.Interface_Resizeable.Interface_Resizeable;

public class Circle extends Shape implements Interface_Resizeable {
    private double radius;

    public Circle(){

    }
    public Circle(double radius,String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return radius * radius * Math.PI;
    }
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public String toString(){
        return "A circle with radius ="
                + getRadius()+" Area = "
                +getArea()+", which is a subclass of"
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.radius = radius*(percent/100);
        System.out.println("Radius after = "+radius);
    }
}
