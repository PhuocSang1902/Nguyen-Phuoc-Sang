package case_study_furama_resort_module_2.services.impl.facility_service_impl;

import case_study_furama_resort_module_2.models.facility.Facility;
import case_study_furama_resort_module_2.models.facility.Room;
import case_study_furama_resort_module_2.services.facility_service.FacilityRoomService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityRoomServiceImpl implements FacilityRoomService {
    public static Scanner sc = new Scanner(System.in);
    public static Map<Room, Integer> facilitiesList = new LinkedHashMap<>();

    private static Facility inputInfoRoom() {
        String serviceName;
        double usableArea;
        double rentalCost;
        int maximumNumberOfPeople;
        String rentalType;
        String freeServiceIncluded;

        System.out.print("Enter service name: ");
        serviceName = sc.nextLine();
        System.out.print("Enter usable area: ");
        usableArea = Double.parseDouble(sc.nextLine());
        System.out.print("Enter rental cost: ");
        rentalCost = Double.parseDouble(sc.nextLine());
        System.out.print("Enter maximum number of people: ");
        maximumNumberOfPeople = Integer.parseInt(sc.nextLine());
        System.out.print("Enter rental type: ");
        rentalType = sc.nextLine();
        System.out.print("Enter room standard: ");
        freeServiceIncluded = sc.nextLine();


        return new Room(serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType, freeServiceIncluded);
    }

    @Override
    public void displayMaintenanceList() {

    }

    @Override
    public void display() {

    }

    @Override
    public void add() {

    }
}
