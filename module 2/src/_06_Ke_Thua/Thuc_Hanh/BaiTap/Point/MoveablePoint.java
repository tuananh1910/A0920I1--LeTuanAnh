package _06_Ke_Thua.Thuc_Hanh.BaiTap.Point;

import java.util.Arrays;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint() {
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        setxSpeed(xSpeed);
        setySpeed(ySpeed);
    }

    public float[] getSpeed() {
        return new float[]{getxSpeed(), getySpeed()};
    }

    @Override
    public String toString() {
        return "x,y , speed = " + getX()+" "+ getY()+" "
                + Arrays.toString(getSpeed());
    }

    public Point move() {
        float x= getX();
        setX(x+=xSpeed);
        float y= getY();
        setY(y+=ySpeed);
        return this;
    }
}
