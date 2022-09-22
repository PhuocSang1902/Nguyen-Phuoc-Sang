package ss13_searching_agorithm.exercise.set_up_binary_search_use_recursion;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static void sort(int[] array) {
        int min;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[min])
                    min = j;
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element " + (i + 1));
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        sort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Enter key you want to find");
        int key = Integer.parseInt(scanner.nextLine());

        int value = BinarySearch.binarySearch(array, key, 0, array.length);

        if (value != -1) {
            System.out.println("Position of " + key + " is: " + value);
        } else {
            System.out.println("The key is not exist.");
        }


    }
}
