package ss4_class_and_object.exercise.lesson2_stop_watch;

import java.util.Arrays;

public class MainStopWatch {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int maxIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] >= max){
                    max = arr[j];
                    maxIndex = j;
                }
                arr[maxIndex] = arr[i];
                arr[i]=max;
            }
        }
        System.out.println(Arrays.toString(arr));
        stopWatch.stop();
        System.out.println(stopWatch.getElapsedTime() + " millisecond");
    }
}
