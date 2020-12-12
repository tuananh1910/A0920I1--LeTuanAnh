package _06_Ke_Thua.Thuc_Hanh.Circle_Cylinder;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(double side){
        super(side);
    }
    public Cylinder(double side,double height){
        super(side);
        this.height = height;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double volume(){
        return (height*Math.PI*Math.pow(getRadius(),2));
    }
    public String toString(){
        return "Radius = "+ getRadius() + ", Height = " +getHeight()
                +", Volume = " + volume();
    }
}
// the tich = h*pi*r^2
