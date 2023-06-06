package ss2_loops.exercise;

import java.util.Scanner;

public class Lesson1DisplayTypeOfGeometric {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Print the rectangle.");
        System.out.println("2.Print the square triangle");
        System.out.println("3.Print the isosceles triangle");
        System.out.println("4.Exit");

        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            String text = "";
            switch (choice) {
                case 1:
                    System.out.println("Print the rectangle.");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            text += "* ";
                        }
                        text += "\n";
                    }
                    System.out.println(text);
                    break;
                case 2:
                    System.out.println("Print the rectangle.");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            text += "* ";
                        }
                        text += "\n";
                    }

                    text += "\n";

                    for (int i = 5; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            text += "* ";
                        }
                        text += "\n";
                    }

                    text += "\n";

                    for (int i = 5; i > 0; i--) {
                        for (int j = 1; j <= 5; j++) {
                            if (j < i) {
                                text += "  ";
                            } else {
                                text += "* ";
                            }
                        }
                        text += "\n";
                    }
                    text += "\n";
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (j < i) {
                                text += "  ";
                            } else {
                                text += "* ";
                            }
                        }
                        text += "\n";
                    }
                    System.out.println(text);
                    break;
                case 3:
                    System.out.println("Print the isosceles triangle.");
                    int count = 5;
                    for (int i = 5; i > 0; i--) {
                        for (int j = 1; j <= count; j++) {
                            if (j < i) {
                                text += "  ";
                            } else {
                                text += "* ";
                            }
                        }
                        text += "\n";
                        count++;
                    }
                    System.out.println(text);
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice.");
            }
        }
    }
}
