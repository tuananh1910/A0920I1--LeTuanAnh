package _06_Ke_Thua.Thuc_Hanh.BaiTap.Point;

public class main_MoveablePoint {
    public static void main(String[] args) {
        MoveablePoint moveablePoint
                = new MoveablePoint(2.0f,3.0f,4.0f,5.0f);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
    }
}
