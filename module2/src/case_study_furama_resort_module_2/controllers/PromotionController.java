package case_study_furama_resort_module_2.controllers;

import case_study_furama_resort_module_2.services.PromotionService;
import case_study_furama_resort_module_2.services._impl.PromotionServiceImpl;

import java.util.Scanner;

public class PromotionController {
    private static Scanner sc = new Scanner(System.in);
    private static PromotionService promotionService = new PromotionServiceImpl();

    public static void displayPromotionMenu() {
        while (true) {
            System.out.println("PROMOTION MANAGEMENT MENU");
            System.out.println("1.Display List Customers Use Service");
            System.out.println("2.Display List Customers Get Voucher");
            System.out.println("3.Return Main Menu");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    promotionService.display();
                    break;
                case "2":
                    promotionService.displayCustomerGetVoucher();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Wrong format. Enter again!");
            }
            System.out.println();
        }
    }
}
