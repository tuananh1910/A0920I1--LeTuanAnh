package _11_Stack_Queue.Bai_Tap.Reverse_Stack;

public class main {
    public static void main(String[] args) {
        Reverse<Integer> stack = new Reverse<>();
        Reverse<String> wStack = new Reverse<>();

        //dao mang so nguyen
        int[] arrayInt = {1,2,3};
        for (int i=0; i<arrayInt.length;i++){
            stack.push(arrayInt[i]);
        }
        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }

        //dao mang chuoi
        String string = "String";
        String[] arrayString = string.split("");
        for (int i=0;i<arrayString.length;i++){
            wStack.push(arrayString[i]);
        }
        while (!wStack.isEmpty()) {
            System.out.printf(" %s ", wStack.pop());
        }
    }
}
