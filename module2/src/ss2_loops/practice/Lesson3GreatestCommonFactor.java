package ss2_loops.practice;

import java.util.Scanner;

public class Lesson3GreatestCommonFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the number 2: ");
        int num2 = scanner.nextInt();
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }
        System.out.println("The greatest common factor is: " + num1);
    }
}
