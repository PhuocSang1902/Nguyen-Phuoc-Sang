package ss13_searching_agorithm.exercise.set_up_binary_search_use_recursion;

public class BinarySearch {
    public static int binarySearch(int[] array, int key, int head, int tail){
        int mid;
        if (tail >= head){
            mid = (head + tail) / 2;
            if (key < array[mid]){
                return binarySearch(array, key, head, mid-1);
            }else if(key == array[mid]){
                return mid;
            }else {
                return binarySearch(array, key, mid + 1, tail);
            }
        }
        return -1;
    }
}
