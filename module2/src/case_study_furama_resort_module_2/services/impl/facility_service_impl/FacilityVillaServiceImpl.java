package case_study_furama_resort_module_2.services.impl.facility_service_impl;

import case_study_furama_resort_module_2.models.facility.Facility;
import case_study_furama_resort_module_2.models.facility.Villa;
import case_study_furama_resort_module_2.services.facility_service.FacilityVillaService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityVillaServiceImpl implements FacilityVillaService {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Villa, Integer> facilitiesList = new LinkedHashMap<>();

    private static Facility inputInfoVilla() {
        String serviceName;
        double usableArea;
        double rentalCost;
        int maximumNumberOfPeople;
        String rentalType;
        String standardRoom;
        double poolArea;
        int numberOfFloor;

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
        standardRoom = sc.nextLine();
        System.out.print("Enter pool area: ");
        poolArea = Double.parseDouble(sc.nextLine());
        System.out.print("Enter number of floor: ");
        numberOfFloor = Integer.parseInt(sc.nextLine());

        return new Villa(serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType, standardRoom, poolArea, numberOfFloor);
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
