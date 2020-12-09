package _05_.Access_Modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(){

    }

    protected double getRadius() {
        return radius;
    }
    protected String getColor() {
        return color;
    }
}
