package ss10_java_collection_framework.exercise.exercise_extra_1.controller;

import ss10_java_collection_framework.exercise.exercise_extra_1.service.IStudentService;
import ss10_java_collection_framework.exercise.exercise_extra_1.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {

    public static Scanner scanner = new Scanner(System.in);
    public static IStudentService iStudentService = new StudentService();

    public static void menuStudent(){
        while (true){
            System.out.println("STUDENT MANAGEMENT PROGRAM");
            System.out.println("choose function follow number:");
            System.out.println("1.Add new student.");
            System.out.println("2.Remove student.");
            System.out.println("3.Show student list.");
            System.out.println("4.Find student.");
            System.out.println("5.Return main menu.");
            System.out.println("6.Exit.");
            System.out.println("7.Creat temp to test.");
            System.out.print("Choose the function: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    iStudentService.add();
                    break;
                case 2:
                    iStudentService.remove();
                    break;
                case 3:
                    iStudentService.showList();
                    break;
                case 4:
                    if (iStudentService.find() == -1){
                        System.out.println("There is not student in the list.");
                    }
                    iStudentService.find();
                    break;
                case 5:
                    PersonController.menuPerson();
                case 6:
                    System.exit(0);
                case 7:
                    iStudentService.creatTemp();
                    break;
            }
        }
    }

}
