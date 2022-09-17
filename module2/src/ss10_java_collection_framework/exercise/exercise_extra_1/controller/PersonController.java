package ss10_java_collection_framework.exercise.exercise_extra_1.controller;

import java.util.Scanner;

public class PersonController {

    public static Scanner scanner = new Scanner(System.in);
    public static void menuPerson(){
        while (true){
            System.out.println("PERSONNEL LIST:");
            System.out.println("Choose the management program follow number.");
            System.out.println("1. Student management program.");
            System.out.println("2. Teacher management program.");
            System.out.println("3. Exit.");
            System.out.println("Choose the management program: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    StudentController.menuStudent();
                    break;
                case 2:
                    TeacherController.menuTeacher();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
