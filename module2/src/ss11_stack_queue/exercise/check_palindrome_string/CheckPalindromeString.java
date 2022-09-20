package ss11_stack_queue.exercise.check_palindrome_string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckPalindromeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new LinkedList();
        System.out.println("Enter a String: ");
        String str = scanner.nextLine();
        for (int i = str.length() - 1; i >= 0; i--) {
            queue.add(str.charAt(i));
        }
        String strReverse = "";
        while (!(queue.isEmpty())){
            strReverse += queue.remove();
        }
        if (str.equals(strReverse)){
            System.out.println("This is palindrome string.");
        }else {
            System.out.println("This is not palindrome string.");
        }

    }
}
