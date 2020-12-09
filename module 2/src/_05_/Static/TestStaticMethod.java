package _05_.Static;

public class TestStaticMethod {
    public static void main(String[] args) {
        Static_method.change(); //calling change method

        //creating objects
        Static_method s1 = new Static_method(111, "Hoang");
        Static_method s2 = new Static_method(222, "Khanh");
        Static_method s3 = new Static_method(333, "Nam");

        //calling display method
        s1.display();
        s2.display();
        s3.display();
    }
}
