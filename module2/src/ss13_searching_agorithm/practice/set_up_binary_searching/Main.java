package ss13_searching_agorithm.practice.set_up_binary_searching;

public class Main {
    public static void main(String[] args) {
        BinarySearching Search = new BinarySearching();
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println(Search.binarySearching(list, 2));  /* 0 */
        System.out.println(Search.binarySearching(list, 11)); /* 4 */
        System.out.println(Search.binarySearching(list, 79)); /*12 */
        System.out.println(Search.binarySearching(list, 1));  /*-1 */
        System.out.println(Search.binarySearching(list, 5));  /*-1 */
        System.out.println(Search.binarySearching(list, 80)); /*-1 */
    }
}
