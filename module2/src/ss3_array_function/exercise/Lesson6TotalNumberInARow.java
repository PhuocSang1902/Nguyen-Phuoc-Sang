package ss3_array_function.exercise;

import java.util.Scanner;

public class Lesson6TotalNumberInARow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array = creat2DimensionalIntArray();
        int row;
        do {
            System.out.print("Enter the row that total: ");
            row = Integer.parseInt(sc.nextLine());
            if (row < 0 || row >= array.length){
                System.out.println("The Row is not correct.");
            }
        }while (row < 0 || row >= array.length);
        int total = 0;
        for (int[] value : array) {
            total += value[row];
        }
        System.out.printf("Total of row %d is %d", row, total);
    }

    static int[][] creat2DimensionalIntArray() {
        Scanner sc = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter the size of array you want to creat: ");
            size = Integer.parseInt(sc.nextLine());
            if (size <= 0) {
                System.out.println("Input again, size of array has to greater than zero.");
            }
        } while (size <= 0);
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("Enter the element %d %d of array: ", i, j);
                array[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        return array;
    }
}
