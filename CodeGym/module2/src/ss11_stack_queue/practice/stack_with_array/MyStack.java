package ss11_stack_queue.practice.stack_with_array;

public class MyStack {
    private int[] array;
    private int size;
    private int index = 0;

    public MyStack(int size){
        this.size = size;
        array = new int[size];
    }

    public boolean isFull(){
        if (this.index == size){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if (this.index == 0){
            return true;
        }
        return false;
    }

    public int size (){
        return this.index;
    }

    public void push(int element){
        if (isFull()){
            throw new StackOverflowError("Stack is full.");
        }
        array[index]=element;
        index ++;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is null");
        }
        return array[--index];
    }
}
