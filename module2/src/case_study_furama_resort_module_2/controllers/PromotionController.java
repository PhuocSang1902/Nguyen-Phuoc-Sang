package case_study_furama_resort_module_2.controllers;

import java.util.Scanner;

public class PromotionController {
    private static Scanner sc = new Scanner(System.in);

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
