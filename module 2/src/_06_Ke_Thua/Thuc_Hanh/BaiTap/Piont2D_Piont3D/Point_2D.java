package _06_Ke_Thua.Thuc_Hanh.BaiTap.Piont2D_Piont3D;

import _06_Ke_Thua.Thuc_Hanh.BaiTap.Point.Point;

public class Point_2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point_2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Point_2D(){}

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY(){
        return new float[]{getX(),getY()};
    }
    public void setXY(float x, float y){
        setX(x);
        setY(y);
    }
    @Override
    public String toString(){
        return "x =" + getX() + "y = "+getY();
    }
}

