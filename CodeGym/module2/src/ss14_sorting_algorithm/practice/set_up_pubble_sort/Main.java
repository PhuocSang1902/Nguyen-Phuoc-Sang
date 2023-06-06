package ss14_sorting_algorithm.practice.set_up_pubble_sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
         int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
         BubbleSort.sort(list);
        System.out.println(Arrays.toString(list));
    }
}
