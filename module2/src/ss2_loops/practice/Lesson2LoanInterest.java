package ss2_loops.practice;

import java.util.Scanner;

public class Lesson2LoanInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount of loan: ");
        double money = scanner.nextDouble();
        System.out.print("Enter months of loan: ");
        int month = scanner.nextInt();
        System.out.print("Enter annual interest rate in percentage: ");
        double interestRate = scanner.nextDouble();
        double totalInterest = 0;
        for (int i = 1; i <= month; i++) {
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.printf("Total Interest is: %.2f" ,totalInterest);
    }
}
