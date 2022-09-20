package ss11_stack_queue.exercise.reverse_array_with_stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseArrayWithStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack1 = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        stack1.push(stack.pop());
        stack1.push(stack.pop());
        stack1.push(stack.pop());
        stack1.push(stack.pop());
        stack1.push(stack.pop());
        System.out.println(stack1);

        String mWord = "phuong tao lao";
        Stack<String> wStack = new Stack<>();
        String[] mWord2 = new String[mWord.length()];
        mWord2 = mWord.split("");
        for (int i = 0; i < mWord2.length; i++) {
            wStack.push(mWord2[i]);
        }
        System.out.println(wStack);
        for (int i = 0; i < mWord2.length; i++) {
            mWord2[i] = wStack.pop();
        }
        System.out.println(Arrays.toString(mWord2));
        for (int i = 0; i < mWord2.length; i++) {
            System.out.print(mWord2[i]);
        }
    }

}
