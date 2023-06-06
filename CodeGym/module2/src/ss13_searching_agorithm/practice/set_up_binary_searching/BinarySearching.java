package ss13_searching_agorithm.practice.set_up_binary_searching;

public class BinarySearching {
    public int binarySearching(int[] array, int value) {
        int head = 0;
        int tail = array.length - 1;
        int mid = 0;
        while (tail >= head) {
                mid = (tail + head) / 2;

            if (array[mid] > value) {
                tail = mid - 1;
            } else if (array[mid] == value) {
                return mid;
            } else {
                head = mid + 1;
            }
        }
        return -1;
    }

}
