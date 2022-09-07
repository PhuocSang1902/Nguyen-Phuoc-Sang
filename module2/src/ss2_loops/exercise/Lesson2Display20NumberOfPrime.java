package ss2_loops.exercise;

import java.util.Scanner;

public class Lesson2Display20NumberOfPrime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of prime you want to print: ");
        int amountOfPrime = Integer.parseInt(scanner.nextLine());

        int count = 0;
        int number = 2;
        while (count < amountOfPrime) {
            boolean check = true;
                for (int j = 2; j < number; j++) {
                    int IsDivisibleByJ = number % j;
                    if (IsDivisibleByJ == 0) {
                        check = false;
                        break;
                    }
                }
            if (check) {
                System.out.print(number + "\t");
                count++;
            }
            number++;
        }
    }
}
