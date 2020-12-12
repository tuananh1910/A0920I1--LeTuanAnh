package _06_Ke_Thua.Thuc_Hanh.BaiTap.Piont2D_Piont3D;

import java.util.Arrays;

public class Point_3D extends Point_2D {
    private float z = 0.0f;

    public Point_3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point_3D() {}

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ(){
        return new float[]{getX(),getY(),getZ()};
    }
    public void setXYZ(float x, float y, float z){
        setX(x);
        setY(y);
        setZ(z);
    }
    @Override
    public String toString(){
        return "X,Y,Z =" + Arrays.toString(getXYZ());
    }

}
