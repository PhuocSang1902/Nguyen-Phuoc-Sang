package ss13_searching_agorithm.exercise.set_up_binary_search_use_recursion;


public class Main {
    public static void main(String[] args) {
        BinarySearch Search = new BinarySearch();
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println(Search.binarySearch(list, 2, 0, list.length));  /* 0 */
        System.out.println(Search.binarySearch(list, 11, 0, list.length)); /* 4 */
        System.out.println(Search.binarySearch(list, 79, 0, list.length)); /*12 */
        System.out.println(Search.binarySearch(list, 1, 0, list.length));  /*-1 */
        System.out.println(Search.binarySearch(list, 5, 0, list.length));  /*-1 */
        System.out.println(Search.binarySearch(list, 80, 0, list.length)); /*-1 */
    }
}
