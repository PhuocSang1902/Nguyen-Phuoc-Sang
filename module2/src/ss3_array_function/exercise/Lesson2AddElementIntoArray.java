package ss3_array_function.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson2AddElementIntoArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the element that you want to add: ");
        int addElement = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter position: ");
        int position;
        do {
            position = Integer.parseInt(scanner.nextLine());
            if (position < 0 || position > arr.length - 1) {
                System.out.println("The position you enter is not correct.");
            }
        } while (position < 0 || position > arr.length - 1);
        System.arraycopy(arr, position, arr, position + 1, arr.length - 2 - position);
        arr[position] = addElement;
        System.out.println(Arrays.toString(arr));
    }
}
