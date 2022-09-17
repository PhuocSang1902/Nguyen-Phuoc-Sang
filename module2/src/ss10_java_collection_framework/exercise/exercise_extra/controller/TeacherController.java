package ss10_java_collection_framework.exercise.exercise_extra.controller;

import ss10_java_collection_framework.exercise.exercise_extra.service.ITeacherService;
import ss10_java_collection_framework.exercise.exercise_extra.service.impl.TeacherService;

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
            System.out.println("4.Return main menu.");
            System.out.println("5.Exit.");
            System.out.println("6.Creat temp");
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
                    PersonController.menuPerson();
                    break;
                case 5:
                    System.exit(0);
                case 6:
                    iTeacherService.creatTemp();
                    break;
            }
        }
    }
}
