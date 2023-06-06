package ss14_sorting_algorithm.practice.set_up_pubble_sort;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] array) {
        boolean isSwap = true;
        for (int i = 0; i < array.length && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSwap = true;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
