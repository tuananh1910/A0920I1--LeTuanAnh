package _11_Stack_Queue.Bai_Tap.TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class Dem_so_lan {
    public static void main(String[] args) {
        Map<Character, Integer> map = new TreeMap<>();
        String st = "abcabcxyz";
        for (int i = 0; i < st.length(); i++) {
            if (map.containsKey(st.charAt(i))){
                map.put(st.charAt(i),map.get(st.charAt(i))+1);
            }
            else {
                map.put(st.charAt(i),1);
            }
        }
        System.out.println(map);
    }
}

