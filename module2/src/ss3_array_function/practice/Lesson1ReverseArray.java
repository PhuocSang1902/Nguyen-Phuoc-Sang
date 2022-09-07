package ss3_array_function.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson1ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr;
        int arrSize;

        do {
            System.out.print("Enter your array size: ");
            arrSize = Integer.parseInt(scanner.nextLine());
            if (arrSize > 20){
                System.out.println("Array size is less than or equal to 20. Please enter again!");
            }
        }while(arrSize > 20);
        arr = new int[arrSize];

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter arr[%d]: ", i);
            arr[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int value : arr) {
            System.out.print(value + "\t");
        }

        for (int firstIndex = 0, lastIndex = arr.length-1; firstIndex < lastIndex ; firstIndex++, lastIndex--) {
            arr[firstIndex] = arr[lastIndex] + (arr[lastIndex] = arr[firstIndex]) - arr[lastIndex];
        }

        System.out.println(Arrays.toString(arr));
    }
}
