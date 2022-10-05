package case_study_furama_resort_module_2.controllers;

import case_study_furama_resort_module_2.services.BookingService;
import case_study_furama_resort_module_2.services._impl.BookingServiceImpl;

import java.util.Scanner;

public class BookingController {

    private static BookingService bookingServiceImpl = new BookingServiceImpl() {};

    private static Scanner sc = new Scanner(System.in);

    public static void displayBookingMenu() {
        while (true) {
            System.out.println("BOOKING MANAGEMENT MENU");
            System.out.println("1.Add New Booking");
            System.out.println("2.Display List Booking");
            System.out.println("3.Create New Contracts");
            System.out.println("4.Display List Contracts");
            System.out.println("5.Edit Contracts");
            System.out.println("6.Return Main Menu");
            System.out.print("Enter your choice follow number: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    bookingServiceImpl.add();
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":
                    return;
                default:
                    System.out.println("Wrong format. Enter again!");
            }
            System.out.println();
        }
    }
}
