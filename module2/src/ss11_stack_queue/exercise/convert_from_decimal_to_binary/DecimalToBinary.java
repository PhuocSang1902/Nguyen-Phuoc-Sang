package ss11_stack_queue.exercise.convert_from_decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an Integer number: ");
        int num = Integer.parseInt(scanner.nextLine());
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            int d = num %2;
            stack.push(d);
            num /= 2;
        }
        System.out.println("Binary value is: ");
        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }
    }
}
