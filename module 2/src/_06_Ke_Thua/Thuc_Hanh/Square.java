package _06_Ke_Thua.Thuc_Hanh;

import _07_Abstract_Interface.Bai_Tap.Interface_Colorable.Interface_Colorable;
import _07_Abstract_Interface.Bai_Tap.Interface_Resizeable.Interface_Resizeable;

public class Square extends Rectangle
        implements Interface_Resizeable, Interface_Colorable {
    public Square() {
    }
    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }
    public double getArea() {
        return (getWidth() * getWidth());
    }


    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
    @Override
    public void resize(double percent) {
        double size = getSide()*(percent/100);
        System.out.println("side =" + getSide());
    }

    @Override
    public void HowToColor() {
        System.out.println("Color all four sides...");
    }
}
