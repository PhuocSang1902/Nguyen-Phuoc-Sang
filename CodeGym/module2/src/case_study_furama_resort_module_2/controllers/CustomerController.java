package case_study_furama_resort_module_2.controllers;

import case_study_furama_resort_module_2.services.people_service.CustomerService;
import case_study_furama_resort_module_2.services._impl.people_service_impl.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
    private static CustomerService customerServiceImpl = new CustomerServiceImpl();
    private static Scanner sc = new Scanner(System.in);

    public static void displayCustomerMenu() {
        while (true) {
            System.out.println("CUSTOMER MANAGEMENT MENU");
            System.out.println("1.Display List Customer");
            System.out.println("2.Add New Customer");
            System.out.println("3.Edit Customer");
            System.out.println("4.Return Main Menu");
            System.out.print("Enter your choice follow number: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    customerServiceImpl.display();
                    break;
                case "2":
                    customerServiceImpl.add();
                    break;
                case "3":
                    customerServiceImpl.edit();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Wrong format. Enter again!");
            }
            System.out.println();
        }
    }

}
