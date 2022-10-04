package case_study_furama_resort_module_2.services.impl.facility_service_impl;

import case_study_furama_resort_module_2.models.facility.Facility;
import case_study_furama_resort_module_2.models.facility.House;
import case_study_furama_resort_module_2.models.facility.Room;
import case_study_furama_resort_module_2.models.facility.Villa;
import case_study_furama_resort_module_2.services.facility_service.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {

    public static Scanner sc = new Scanner(System.in);
    public static Map<Facility, Integer> facilitiesList = new LinkedHashMap<>();

    private static Facility inputInfoHouse() {
        String serviceName;
        double usableArea;
        double rentalCost;
        int maximumNumberOfPeople;
        String rentalType;
        String roomStandard;
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
        roomStandard = sc.nextLine();
        System.out.print("Enter number of floor: ");
        numberOfFloor = Integer.parseInt(sc.nextLine());

        return new House(serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType, roomStandard, numberOfFloor);
    }

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

//    private static Facility getInfoFromFile(){
//        File file = new File("src\\case_study_furama_resort_module_2\\data\\facility_data.csv");
//        FileReader fileReader;
//        BufferedReader bufferedReader;
//
//        try {
//            fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//            String line;
//            String[] str;
//            while ((line = bufferedReader.readLine())!=null){
//                str = line.split(",");
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    @Override
    public void display() {

    }

    @Override
    public void add() {

    }

    @Override
    public void displayMaintenanceList() {

    }
}
