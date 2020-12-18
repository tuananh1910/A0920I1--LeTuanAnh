package _11_Stack_Queue.Bai_Tap.Check_Palindrome;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> stack;
    public Stack(){
        stack = new LinkedList<>();
    }
    public void push (String element){
        stack.addFirst((T) element);
    }
    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }

    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
    public int size() {
        return stack.size();
    }
}
