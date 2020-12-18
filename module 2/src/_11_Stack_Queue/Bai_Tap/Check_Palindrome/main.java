package _11_Stack_Queue.Bai_Tap.Check_Palindrome;

public class main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        Queue queue = new Queue();
        String string = "able was I ere I saw elba";
        String[] arrayString = string.split("");
        for (int i =0;i<arrayString.length;i++) {
            stack.push(arrayString[i]);
            queue.enqueue(arrayString[i]);
        }
        boolean check = true;
        while (!stack.isEmpty()) {
            if (stack.pop().equals(queue.dequeue().key)){
                check = true;
            }
            else {
                check = false;
            }
        }
        if (check){
            System.out.println("Palidrome ~~");
        }
        else{
            System.out.println("Not is Palidrome");
        }

    }
}

