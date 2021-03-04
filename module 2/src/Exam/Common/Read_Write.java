package Exam.Common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Read_Write {
    public static void write_File(String path, String data, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bw;
        try {
            fileWriter = new FileWriter(path, append);
            bw = new BufferedWriter(fileWriter);
            bw.write(data);
            bw.newLine();
//            bw.flush();
            bw.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
