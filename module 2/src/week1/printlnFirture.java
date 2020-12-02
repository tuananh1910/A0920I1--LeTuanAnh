package week1;

public class printlnFirture {
    public static void main(String[] args) {
        for (int i=0;i<3;i++){
            System.out.println("**************");
        }
        System.out.println("-------------");
        String string = "";
        for(int i=1; i<=5; i++) {
            for (int j = 1; j < i; j++){
                string +="*";
            }
            System.out.println(string);
            string = "";
        }
        System.out.println("----------");
        for(int i=7;i>=1;i--) {
            for (int j = 1; j <= i; j++){
                string +="*";
            }
            System.out.println(string);
            string = "";
        }
    }
}
