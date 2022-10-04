package case_study_furama_resort_module_2.controllers;

import case_study_furama_resort_module_2.services.EmployeeService;
import case_study_furama_resort_module_2.services.impl.EmployServiceImpl;

import java.util.Scanner;

public class EmployeeController {
    private static EmployeeService employeeServiceImpl = new EmployServiceImpl();
    private static Scanner sc = new Scanner(System.in);


    public static void displayEmployeeMenu() {
        while (true) {
            System.out.println("EMPLOYEE MANAGEMENT MENU");
            System.out.println("1.Display List Employees");
            System.out.println("2.Add New Employee");
            System.out.println("3.Edit Employee");
            System.out.println("4.Return Main Menu");
            System.out.print("Enter your choice follow number: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    employeeServiceImpl.display();
                    break;
                case 2:
                    employeeServiceImpl.add();
                    break;
                case 3:
                    employeeServiceImpl.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong format. Enter again!");

            }
            System.out.println();
        }
    }
}
