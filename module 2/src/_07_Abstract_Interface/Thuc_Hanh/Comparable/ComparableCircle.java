package _07_Abstract_Interface.Thuc_Hanh.Comparable;

import _06_Ke_Thua.Thuc_Hanh.Circle;

public class ComparableCircle extends Circle
        implements Comparable<ComparableCircle>{

    public ComparableCircle() {
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) {
            return 1;
        }
        else if (getRadius() < o.getRadius()) {
            return -1;
        }
        else {
            return 1;
        }
    }
}

