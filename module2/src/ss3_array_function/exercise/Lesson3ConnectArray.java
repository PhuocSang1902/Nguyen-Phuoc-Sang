package ss3_array_function.exercise;

import java.util.Arrays;

public class Lesson3ConnectArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7, 8};
        int[] arr = new int[8];

        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }
        for (int i = arr2.length - 1; i >= 0; i--) {
            arr[i + arr1.length] = arr2[i];
        }
        System.out.println(Arrays.toString(arr));
    }
}
