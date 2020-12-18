package _08_Cleancode_Refactoring.Thuc_Hanh.Cylinder;

public class Cylinder {
        public static double getVolume(int radius, int height){
            double baseArea = Math.PI * radius * radius;
            double perimeter = 2 * Math.PI  * radius;
            double volume = perimeter * height + 2 * baseArea;
            return volume;
    }
}
