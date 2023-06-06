package ss11_stack_queue.practice.stack_with_linked;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class StackWithLinked<E> {
    private LinkedList<E> stack;

    public StackWithLinked(){
        stack = new LinkedList<>();
    }

    public void push(E element){
        stack.addFirst(element);
    }

    public E pop(){
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

    public int size(){
        return stack.size();
    }



}
