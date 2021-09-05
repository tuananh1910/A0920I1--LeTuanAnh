package date;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        String S = "abc";
        String T = "abcabcabc";
        checkAppear(S,T);
        int[] A={1,2,3,2,1};
        System.out.println(A);
    }
    public static void checkAppear(String S, String T){
        int lengthS = S.length();
        String hold="";
        for(int i=0; i<T.length() ;i+= lengthS){
            hold = T.substring(i,i+lengthS);
            System.out.println(hold);
        }
    }
}
