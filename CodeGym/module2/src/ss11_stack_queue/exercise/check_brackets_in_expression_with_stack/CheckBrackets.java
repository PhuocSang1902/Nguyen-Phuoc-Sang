package ss11_stack_queue.exercise.check_brackets_in_expression_with_stack;

import java.util.Scanner;
import java.util.Stack;

public class CheckBrackets {
    public static boolean checkBrackets() {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String expressionString = sc.nextLine();
        for (int i = 0; i < expressionString.length(); i++) {
            char ch = expressionString.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
