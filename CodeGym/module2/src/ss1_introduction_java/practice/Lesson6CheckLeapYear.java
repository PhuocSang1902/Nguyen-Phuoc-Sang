package ss1_introduction_java.practice;

import java.util.Scanner;

public class Lesson6CheckLeapYear {
    public static void main(String[] args) {
        int year;
        System.out.println("Enter a year you want to check:");
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        year = sc.nextInt();
        boolean isDivisibleBy4 = year % 4 == 0;

        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100) {
                boolean isDivisible400 = year % 400 == 0;
                if (isDivisible400) {
                    check = true;
                }
            } else {
                check = true;
            }
        }

        if (check) {
            System.out.printf("%d is a leap year", year);
        } else {
            System.out.printf("%d is not a leap year", year);
        }
    }
}
