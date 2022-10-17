package controller;

import service.StudentService;
import service.impl.StudentServiceImpl;

import java.util.Scanner;

public class StudentController {
    private static StudentService studentService = new StudentServiceImpl();

    public static void displayMenu() {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("STUDENT MANAGEMENT PROGRAMMING");
            System.out.println("1.Add New Student");
            System.out.println("2.Remove Student");
            System.out.println("3.Display Student List");
            System.out.println("4.Return");
            System.out.println("Enter your choice follow number: ");
            String choice = sc.nextLine();

            switch (choice){
                case "1":
                    studentService.add();
                    break;
                case "2":
                    studentService.remove();
                    break;
                case "3":
                    studentService.display();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Wrong choice. Enter again!");
                    System.out.println();
            }
        }
    }
}
