package controller;

import java.util.Scanner;

public class PersonController {
    public static void displayMenu() {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("PERSON MANAGEMENT PROGRAMMING");
            System.out.println("1.Student management programming");
            System.out.println("2.Teacher management programming");
            System.out.println("3.Exit");
            System.out.println("Enter your choice follow number: ");
            String choice = sc.nextLine();

            switch (choice){
                case "1":
                    StudentController.displayMenu();
                    break;
                case "2":
                    TeacherController.displayMenu();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Wrong choice. Enter again!");
                    System.out.println();
            }
        }
    }
}
