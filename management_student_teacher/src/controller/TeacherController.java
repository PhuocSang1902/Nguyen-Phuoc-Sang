package controller;

import service.TeacherService;
import service.impl.TeacherServiceImpl;

import java.util.Scanner;

public class TeacherController {
    public static TeacherService teacherService = new TeacherServiceImpl();

    public static void displayMenu() {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("TEACHER MANAGEMENT PROGRAMMING");
            System.out.println("1.Add New Teacher");
            System.out.println("2.Remove Teacher");
            System.out.println("3.Display Teacher List");
            System.out.println("4.Return");
            System.out.println("Enter your choice follow number: ");
            String choice = sc.nextLine();

            switch (choice){
                case "1":
                    teacherService.add();
                    break;
                case "2":
                    teacherService.remove();
                    break;
                case "3":
                    teacherService.display();
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
