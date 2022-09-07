package ss3_array_function.practice;

public class Lesson3FindMaxValueInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 4, 5, 8, 9, 12, 3, 6, 7, 4, 3};
        int max = arr[0];
        for (int value : arr) {
            if (value >= max) {
                max = value;
            }
        }
        System.out.printf("The value max in the array is: %d", max);
    }
}
