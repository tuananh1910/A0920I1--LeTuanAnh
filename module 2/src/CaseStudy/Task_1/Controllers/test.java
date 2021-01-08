package CaseStudy.Task_1.Controllers;

public class test {
    public static void main(String[] args) {
        String s3 = "p";
        System.out.println("s3=" + s3);
        // Kiểm tra s3 kết thúc bằng p
        // Quy tắc $
        // true
        boolean match = s3.matches("p$");
        System.out.println("-Match p$ " + match);
    }
}
