import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        String[] x = new String[]{"John", "Chris", "Mark", "PJ"};

        if (x.length == 4) {
            System.out.print(x[x.length-3]);
        } else {
            System.out.print("Codegym");
        }
    }
}

