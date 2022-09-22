package ss10_java_collection_framework.exercise.exercise_extra_1.controller;

import ss10_java_collection_framework.exercise.exercise_extra_1.service.ITeacherService;
import ss10_java_collection_framework.exercise.exercise_extra_1.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    public static Scanner scanner = new Scanner(System.in);
    public static ITeacherService iTeacherService = new TeacherService();

    public static void menuTeacher() {
        while (true){
            System.out.println("TEACHER MANAGEMENT PROGRAM");
            System.out.println("choose function follow number:");
            System.out.println("1.Add new teacher.");
            System.out.println("2.Remove teacher.");
            System.out.println("3.Show teacher list.");
            System.out.println("4.Find teacher.");
            System.out.println("5.Return main menu.");
            System.out.println("6.Exit.");
            System.out.println("7.Creat temp to test.");
            System.out.print("Choose the function: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    iTeacherService.add();
                    break;
                case 2:
                    iTeacherService.remove();
                    break;
                case 3:
                    iTeacherService.showList();
                    break;
                case 4:
                    iTeacherService.find();
                    break;
                case 5:
                    PersonController.menuPerson();
                    break;
                case 6:
                    System.exit(0);
                case 7:
                    iTeacherService.creatTemp();
                    break;
            }
        }
    }
}
