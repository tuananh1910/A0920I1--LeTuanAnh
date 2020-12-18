package _11_Stack_Queue.Bai_Tap.Thap_Phan_Sang_Nhi_Phan;

public class main {
    public static void main(String[] args) throws Exception {
        int number = 30;
        int count =0;
        int check=0;
        Stack stack = new Stack();
        while (check <number) {
            stack.push(number % 2);
            number= number/2;
            count++;
        }
        while (!stack.isEmpty()) {
            System.out.printf(" %" +
                    "d", stack.pop());
        }
    }
}
