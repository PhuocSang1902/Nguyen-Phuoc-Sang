package ss3_array_function.exercise;

import java.util.Arrays;

public class Lesson3ConnectArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7, 8};
        int[] arr = new int[8];
        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr));
    }
}
