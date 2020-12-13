package _07_Abstract_Interface.Thuc_Hanh.Comparator;

import _06_Ke_Thua.Thuc_Hanh.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        if (o1.getRadius() < o2.getRadius()) {
            return -1;
        } else if (o1.getRadius() > o2.getRadius()) {
            return 1;
        } else return 0;
    }
}
