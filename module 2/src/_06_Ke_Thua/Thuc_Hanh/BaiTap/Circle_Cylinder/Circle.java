package _06_Ke_Thua.Thuc_Hanh.Circle_Cylinder;

public class Circle {

    private double radius;

    public Circle(double side) {
        this.radius = side;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double Area() {
        return (Math.PI * Math.pow(radius, 2));
    }

    public String toString() {
        return "Radius =" + getRadius() +
                ", Area = " + Area();
    }
}
