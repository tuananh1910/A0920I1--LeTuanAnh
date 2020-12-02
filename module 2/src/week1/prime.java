package week1;

public class prime {
    public static void main(String[] args) {
        int cout=0;
        for (int i=2;i>0;i++){
            for (int j=1;j<=i;j++){
                if (i%j==0){
                    cout++;
                }
            }
            if (cout <3){
                System.out.println(i);
            }
            cout =0;
            if (i >= 100){
                break;
            }
        }
    }
}
