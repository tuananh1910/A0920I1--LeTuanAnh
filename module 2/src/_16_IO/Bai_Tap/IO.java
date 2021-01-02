package _16_IO.Bai_Tap;

import java.io.*;

public class IO {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos;

        FileInputStream fis;
        // ghi file
        try {
            fis = new FileInputStream(
                    "E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\input.txt");

            fos = new FileOutputStream(
                    "E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\output.txt");

            int length;
            byte[] buffer = new byte[1];//?
            // copy the file content in bytes
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);

            }
            System.out.println("File is copied successful!");
        }
        catch (IOException exception){
            exception.printStackTrace(); //xac dinh phuong phap nao gay ra loi
                                        // LIFO
        }
        finally {
            System.out.println("DOne");
        }
    }
}
