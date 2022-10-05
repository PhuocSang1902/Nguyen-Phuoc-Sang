package case_study_furama_resort_module_2.controllers;

import case_study_furama_resort_module_2.services.people_service.CustomerService;
import case_study_furama_resort_module_2.services._impl.people_service_impl.CustomerServiceImpl;

import java.util.Scanner;

public class FuramaController {

    private static CustomerService customerServiceImpl = new CustomerServiceImpl() {};

    private static Scanner sc = new Scanner(System.in);

    public static void displayMainMenu() {
        while (true) {
            System.out.println("FURAMA MANAGEMENT MENU");
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6.Exit");
            System.out.print("Enter your choice follow number: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    EmployeeController.displayEmployeeMenu();
                    break;
                case "2":
                    CustomerController.displayCustomerMenu();
                    break;
                case "3":
                    FacilityController.displayFacilityMenu();
                    break;
                case "4":
                    BookingController.displayBookingMenu();
                    break;
                case "5":
                    PromotionController.displayPromotionMenu();
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("Wrong format. Enter again!");
            }
            System.out.println();
        }
    }


}
