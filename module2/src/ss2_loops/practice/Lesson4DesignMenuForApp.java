package ss2_loops.practice;

import java.util.Scanner;

public class Lesson4DesignMenuForApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Draw the triangle.");
        System.out.println("2. Draw the square");
        System.out.println("3. Draw the rectangle");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        StringBuilder text = new StringBuilder();
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 0; j < i; j++) {
                            text.append("*");
                        }
                        text.append("\n");
                    }
                    System.out.print(text);
                    text = new StringBuilder();
                    break;
                case 2:
                    System.out.println("Draw the square");
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 0; j < 6; j++) {
                            text.append("*");
                        }
                        text.append("\n");
                    }
                    System.out.print(text);
                    text = new StringBuilder();
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 0; j < 9; j++) {
                            text.append("*");
                        }
                        text.append("\n");
                    }
                    System.out.print(text);
                    text = new StringBuilder();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice.");

            }
        }
    }
}
