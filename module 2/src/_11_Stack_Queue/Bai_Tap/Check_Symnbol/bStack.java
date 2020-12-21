package _11_Stack_Queue.Bai_Tap.Check_Symnbol;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class bStack<T> {
    private LinkedList<T> stack;
    public bStack(){
        stack = new LinkedList<>();
    }
    public void push (Character character){
        stack.addFirst((T) character);
    }
    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    public boolean isEmpty(){
        if (stack.size()==0){
            return true;
        }
        return false;
    }
}
