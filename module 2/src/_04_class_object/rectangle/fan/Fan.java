package _04_class_object.rectangle.fan;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = SLOW;
    private double radius = 5.0;
    private String color = "blue";
    private boolean on = false;

    public Fan(int speed, double radius, String color,boolean on) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    public Fan(){

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void inforFan(){
        if (!isOn()){
            System.out.println(getSpeed());
            System.out.println(getColor());
            System.out.println(getRadius());
            System.out.println("fan is on");
        }
        else {
            System.out.println(getColor());
            System.out.println(getRadius());
            System.out.println("fan is off");
        }
    }
}
