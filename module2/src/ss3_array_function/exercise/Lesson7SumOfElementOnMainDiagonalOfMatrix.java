package ss3_array_function.exercise;

import java.util.Scanner;

public class Lesson7SumOfElementOnMainDiagonalOfMatrix {
    public static void main(String[] args) {
        int[][] array = creat2DimensionalIntArray();
        System.out.println("Total of element on matrix main diagonal is: " + sumOnMainMatrixDiagonal(array));
    }

    static int sumOnMainMatrixDiagonal(int[][] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i][i];
        }
        for (int i = 0; i < array.length; i++) {
            total += array[i][array.length - 1 - i];
        }
        return total;
    }

    static int[][] creat2DimensionalIntArray() {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter the size of array you want to creat: ");
            size = Integer.parseInt(scanner.nextLine());
            if (size <= 0) {
                System.out.println("Input again, size of array has to greater than zero.");
            }
        } while (size <= 0);
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("Enter the element %d %d of array: ", i, j);
                array[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        return array;
    }
}
