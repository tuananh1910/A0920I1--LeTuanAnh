package CaseStudy.Task_1.Controllers;

import java.io.*;

public class Write_Read_File {
        public void write_File(String path, String data) throws IOException {
                FileWriter fileWriter = new FileWriter(path,false);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write(data);
                bw.newLine();
                bw.close();
                fileWriter.close();
        }
        public String read_File(String path) throws IOException {
                FileReader fileReader = new FileReader(path);
                BufferedReader br = new BufferedReader(fileReader);
                String line = null;
                String rs = "";
                while((line = br.readLine())!=null){
                        rs+=line;
                        rs+="\n";
                }
                return rs;
        }
}
