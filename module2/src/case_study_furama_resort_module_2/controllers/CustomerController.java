package case_study_furama_resort_module_2.controllers;

import case_study_furama_resort_module_2.services.CustomerService;
import case_study_furama_resort_module_2.services.impl.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
    public static CustomerService customerServiceImpl = new CustomerServiceImpl();
    public static Scanner sc = new Scanner(System.in);

    public static void displayCustomerMenu() {
        while (true) {
            System.out.println("CUSTOMER MANAGEMENT MENU");
            System.out.println("1.Display List Customer");
            System.out.println("2.Add New Customer");
            System.out.println("3.Edit Customer");
            System.out.println("4.Return Main Menu");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    customerServiceImpl.display();
                    break;
                case 2:
                    customerServiceImpl.add();
                    break;
                case 3:
                    customerServiceImpl.edit();
                    break;
                case 4:
                    System.exit(0);
            }
            System.out.println();
        }
    }

}
