package ss14_sorting_algorithm.practice.set_up_selection_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
         int[] list = {1, 9, 4, 6, 5, -4};
        SelectionSort.sort(list);
        System.out.println(Arrays.toString(list));
    }
}
