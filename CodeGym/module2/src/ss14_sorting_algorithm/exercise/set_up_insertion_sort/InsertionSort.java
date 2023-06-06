package ss14_sorting_algorithm.exercise.set_up_insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];

                } else {
                    break;
                }

            }
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));

        }

    }
}
