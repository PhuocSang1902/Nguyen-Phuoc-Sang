package ss2_loops.practice;

import java.util.Scanner;

public class Lesson1IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = scanner.nextInt();
        boolean check = false;
        if (number >= 2) {
            for (int i = 2; i < number; i++) {
                int IsDivisibleByI = number % i;
                if (IsDivisibleByI == 0) {
                    check = false;
                    break;
                }
                check = true;
            }
        }
        if (check) {
            System.out.println(number + " is a prime.");
        } else {
            System.out.println(number + " is not a prime.");
        }
    }
}
