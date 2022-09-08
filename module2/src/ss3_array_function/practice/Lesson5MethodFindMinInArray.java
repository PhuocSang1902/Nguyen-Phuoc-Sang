package ss3_array_function.practice;

public class Lesson5MethodFindMinInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println("The Min of the array is: " + findMinArray(arr));
    }
    public static int findMinArray(int[] array){
        int min = array[0];
        for (int value: array) {
            if (min >= value){
                min = value;
            }
        }
        return min;
    }
}
