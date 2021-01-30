package CaseStudy.Refesh.Common;

import java.io.*;
import java.util.ArrayList;

public class Read_Write_File {
    public static void write_File(String path, String data) {
        FileWriter fileWriter;
        BufferedWriter bw;
        try {
            fileWriter = new FileWriter(path, true);
            bw = new BufferedWriter(fileWriter);
            bw.write(data);
            bw.flush();
            bw.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> read_File(final String PATH) {

        FileReader fileReader;
        BufferedReader br;
        String temp = "";
        String[] string_list = null;
        ArrayList<String> arrayList = new ArrayList<>();
        String line;
        try {
            fileReader = new FileReader(PATH);
            br = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null) {
                temp += line;
                System.out.println(temp);
                string_list = temp.split(","); //bug doc file bị ghi đè lên string[] -> thiếu dữ liệu -> tra ve arraylist de tranh ghi de
                temp = "";
                for (int index =0; index<string_list.length;index++){ // do index = 0 khi while lại sẽ bị đảo thứ tự trong data villa khi đẩy lên
                    arrayList.add(index,string_list[index]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // check bug
        System.out.println("list----");
        for (String value : arrayList){
            System.out.println(value);
        }
//        if (string_list != null) {
//            for (String value : string_list) {
//                System.out.println(value);
//            }
//        }


        return arrayList;
    }
}
