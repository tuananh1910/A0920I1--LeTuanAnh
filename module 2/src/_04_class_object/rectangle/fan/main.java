package _04_class_object.rectangle.fan;

public class main {
    public static void main(String[] args) {
        Fan fan_1 = new Fan(3,10.0,"yellow",true);
        Fan fan_2 = new Fan(2,5.0,"blue",false);
        fan_1.inforFan();
        fan_2.inforFan();
    }
}
