package ss3_array_function.exercise;

import java.util.Scanner;

public class Lesson5FindMinInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter the size of array: ");
            size = Integer.parseInt(scanner.nextLine());
            if (size < 0){
                System.out.println("Size is greater or equal zero.Enter again!");
            }
        }while (size < 0);
        int[] array = creat1DimensionalIntArray(size);
        System.out.println("The min of the array is: " + findMinArray(array));
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
    public static int[] creat1DimensionalIntArray(int size){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            System.out.printf("Enter the element %d: ", i+1);
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        return array;
    }
}
