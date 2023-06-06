package ss3_array_function.exercise;

public class Lesson4MethodFindMaxIn2DimensionalArray {
    public static int findMaxIn2DimensionalArray(int[][] array) {
        int max = array[0][0];
        for (int[] element : array) {
            for (int element2 : element) {
                if (element2 > max) {
                    max = element2;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 3, 5, 7},
                {9, 8, 7, 6}
        };
        System.out.printf("Max of array is %d", findMaxIn2DimensionalArray(arr));
    }

}
