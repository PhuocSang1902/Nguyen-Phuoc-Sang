package case_study_furama_resort_module_2.controllers;

import case_study_furama_resort_module_2.services.CustomerService;
import case_study_furama_resort_module_2.services.impl.CustomerServiceImpl;

import java.util.Scanner;

public class FuramaController {

    public static CustomerService customerServiceImpl = new CustomerServiceImpl() {};

    public static Scanner sc = new Scanner(System.in);

    public static void displayMainMenu() {
        while (true) {
            System.out.println("FURAMA MANAGEMENT MENU");
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6.Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    EmployeeController.displayEmployeeMenu();
                    break;
                case 2:
                    CustomerController.displayCustomerMenu();
                    break;
                case 3:
                    displayFacilityMenu();
                    break;
                case 4:
                    displayBookingMenu();
                    break;
                case 5:
                    displayPromotionMenu();
                    break;
                case 6:
                    System.exit(0);
            }
            System.out.println();
        }
    }





    public static void displayFacilityMenu() {
        while (true) {
            System.out.println("FACILITY MANAGEMENT MENU");
            System.out.println("1.Display List Facility");
            System.out.println("2.Add New Facility");
            System.out.println("3.Display List Facility Maintenance");
            System.out.println("4.Return Main Menu");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
            }
            System.out.println();
        }
    }

    public static void displayBookingMenu() {
        while (true) {
            System.out.println("BOOKING MANAGEMENT MENU");
            System.out.println("1.Display List Booking");
            System.out.println("2.Add New Booking");
            System.out.println("3.Creat New Contract");
            System.out.println("4.Display List Contracts");
            System.out.println("5.Edit Contract");
            System.out.println("6.Return Main Menu");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
            }
            System.out.println();
        }
    }

    public static void displayPromotionMenu() {
        while (true) {
            System.out.println("FACILITY MANAGEMENT MENU");
            System.out.println("1.Display List Customers Use Service");
            System.out.println("2.Display List Customers Get Voucher");
            System.out.println("3.Return Main Menu");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    return;
            }
            System.out.println();
        }
    }
}
