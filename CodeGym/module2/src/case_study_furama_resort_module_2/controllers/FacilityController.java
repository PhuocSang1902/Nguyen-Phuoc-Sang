package case_study_furama_resort_module_2.controllers;

import case_study_furama_resort_module_2.services.facility_service.FacilityHouseService;
import case_study_furama_resort_module_2.services.facility_service.FacilityRoomService;
import case_study_furama_resort_module_2.services.facility_service.FacilityVillaService;
import case_study_furama_resort_module_2.services._impl.facility_service_impl.FacilityHouseServiceImpl;
import case_study_furama_resort_module_2.services._impl.facility_service_impl.FacilityRoomServiceImpl;
import case_study_furama_resort_module_2.services._impl.facility_service_impl.FacilityVillaServiceImpl;

import java.util.Scanner;

public class FacilityController {
    private static Scanner sc = new Scanner(System.in);
    private static FacilityHouseService facilityHouseService = new FacilityHouseServiceImpl();
    private static FacilityVillaService facilityVillaService = new FacilityVillaServiceImpl();
    private static FacilityRoomService facilityRoomService = new FacilityRoomServiceImpl();

    public static void displayFacilityMenu() {
        while (true) {
            System.out.println("FACILITY MANAGEMENT MENU");
            System.out.println("1.Display List Facility");
            System.out.println("2.Add New Facility");
            System.out.println("3.Display List Facility Maintenance");
            System.out.println("4.Return Main Menu");
            System.out.print("Enter your choice follow number: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    facilityVillaService.display();
                    facilityHouseService.display();
                    facilityRoomService.display();
                    break;
                case "2":
                    addNewFacility();
                    break;
                case "3":
                    facilityVillaService.displayMaintenanceList();
                    facilityHouseService.displayMaintenanceList();
                    facilityRoomService.displayMaintenanceList();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Wrong format. Enter again!");
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
            System.out.print("Enter your choice follow number: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    facilityVillaService.add();
                    break;
                case "2":
                    facilityHouseService.add();
                    break;
                case "3":
                    facilityRoomService.add();
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
