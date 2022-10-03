package test;

import java.util.Arrays;

public class Text {
    public static int[] solution(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i]!= -1){
                int max = arr[i];
                int index = i;
                for (int k = 0; k <= i ; k++) {
                    if (arr[k] > max) {
                        max = arr[k];
                        index = k;
                    }
                }
                arr[index] = arr[i];
                arr[i] = max;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, -1,9, 2};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }
}
