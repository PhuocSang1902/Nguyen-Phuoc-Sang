package ss3_array_function.practice;

import java.util.Scanner;

public class Lesson6MethodCountNumberOfStudentPass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter number of student");
            size = Integer.parseInt(sc.nextLine());
            if (size > 30 || size <= 0) {
                System.out.println("Number of student is greater than 0 and less than 30. Enter again!");
            }
        } while (size <= 0 || size > 30);
        int[] listScoreOfStudent = creat1DimensionalIntArray(size);
        System.out.printf("Number of student pass is %d", countStudentPass(listScoreOfStudent));
    }

    public static int[] creat1DimensionalIntArray(int size) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Enter the element %d: ", i + 1);
            array[i] = Integer.parseInt(sc.nextLine());
        }
        return array;
    }

    static int countStudentPass(int[] array) {
        int count = 0;
        for (int value : array) {
            if (value > 5) {
                count++;
            }
        }
        return count;
    }
}
