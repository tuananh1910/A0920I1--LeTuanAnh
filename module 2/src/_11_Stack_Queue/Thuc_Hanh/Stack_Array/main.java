package _11_Stack_Queue.Thuc_Hanh.Stack_Array;

public class main {
    public static void main(String[] args) throws Exception {
        Stack_Array stack = new Stack_Array(5);

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("1. Size of stack " +
                "after push operations: " + stack.size());
        System.out.printf("2. P" +
                "op elements from stack : ");

        while (!stack.isEmpty()) {
            System.out.printf(" %" +
                    "d", stack.pop());
        }

        System.out.println("\n3. Size o" +
                "f stack after pop operations : " + stack.size());
    }
}
