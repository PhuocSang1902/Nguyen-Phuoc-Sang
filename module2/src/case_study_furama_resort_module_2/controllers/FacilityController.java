package case_study_furama_resort_module_2.controllers;

import case_study_furama_resort_module_2.services.facility_service.FacilityService;
import case_study_furama_resort_module_2.services.impl.facility_service_impl.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    public static Scanner sc = new Scanner(System.in);
    public static FacilityService facilityServiceImpl = new FacilityServiceImpl();

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
                    facilityServiceImpl.display();
                    break;
                case 2:
                    addNewFacility();
                    break;
                case 3:
                    facilityServiceImpl.displayMaintenanceList();
                    break;
                case 4:
                    return;
            }
            System.out.println();
        }
    }

    public static void addNewFacility() {
        while (true) {
            System.out.println("ADD NEW FACILITY");
            System.out.println("1.Add New Villa");
            System.out.println("2.Add New House");
            System.out.println("3.Add New Room");
            System.out.println("4.Return Facility Menu");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    facilityServiceImpl.addNewVilla();
                    break;
                case 2:
                    facilityServiceImpl.addNewHouse();
                    break;
                case 3:
                    facilityServiceImpl.addNewRoom();
                    break;
                case 4:
                    return;
            }
            System.out.println();
        }
    }
}
