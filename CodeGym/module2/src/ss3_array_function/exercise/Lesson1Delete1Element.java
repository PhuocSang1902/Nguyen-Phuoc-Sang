package ss3_array_function.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson1Delete1Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 4, 0, 0, 0, 9};
        while (true) {
            System.out.print("Enter the element that you want to delete: ");
            int deletingElement = Integer.parseInt(scanner.nextLine());
            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                if (deletingElement == arr[i]) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("The element is not in the array.");
            } else {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == deletingElement) {
                        for (int j = i; j < arr.length - 1; j++) {
                            arr[j] = arr[j + 1];
                        }
                        arr[arr.length - 1] = 0;
                        i--;
                    }
                }
                System.out.println(Arrays.toString(arr));
                break;
            }
        }
    }
}
