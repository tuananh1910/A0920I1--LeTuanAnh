package _11_Stack_Queue.Bai_Tap.Reverse_Stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Reverse<R> {
    private LinkedList<R> stack;
    public Reverse(){stack = new LinkedList<>();}
    public void push (R element){
        stack.addFirst(element);
    }
    public R pop(){
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
