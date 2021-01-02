package _16_IO.Thuc_Hanh;
import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis ;
        DataInputStream dis;
        try {
            fis=new FileInputStream(
                    "E:\\DATA\\A0920I1--LeTuanAnh\\module" +
                            " 2\\src\\ReadFile.txt");
            dis=new DataInputStream(fis);

            int readCount=fis.available();
            byte[] arr = new byte[readCount];
            dis.read(arr);
            for (byte bt : arr){
                System.out.println(bt);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        finally {
            System.out.println("Finished");
        }
    }
}
