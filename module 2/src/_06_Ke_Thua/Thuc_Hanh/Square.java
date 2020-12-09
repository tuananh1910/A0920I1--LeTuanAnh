package _06_Ke_Thua.Thuc_Hanh;

public class Square extends Shape{
    private double side;
    public Square() {
    }

    public Square(double side) {
        super(side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, color, filled);
    }

    public double getSide() {
        return side;
    }


    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    public void setWidth(double width) {
        setSide(width);
    }

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

}
