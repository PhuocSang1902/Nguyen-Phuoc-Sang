package case_study_furama_resort_module_2.services.impl.facility_service_impl;

import case_study_furama_resort_module_2.models.facility.House;
import case_study_furama_resort_module_2.services.facility_service.FacilityHouseService;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityHouseServiceImpl implements FacilityHouseService {
    public static Scanner sc = new Scanner(System.in);
    public static LinkedHashMap<House, Integer> housesList = new LinkedHashMap<>();

//    private static House inputInfoHouse() {
//        String facilityCode;
//        String serviceName;
//        double usableArea;
//        double rentalCost;
//        int maximumNumberOfPeople;
//        String rentalType;
//        String roomStandard;
//        int numberOfFloor;
//
//        while (true) {
//            String rangeID = "0123456789";
//            SecureRandom random = new SecureRandom();
//
//            StringBuilder tempCode = new StringBuilder("SVHO-");
//
//            for (int i = 0; i < 4; i++) {
//                tempCode.append(rangeID.charAt(random.nextInt(rangeID.length())));
//            }
//            facilityCode = tempCode.toString();
//            boolean flagCheck = true;
//
//            for (House house : housesList) {
//                if (house.getCode().equals(facilityCode)) {
//                    flagCheck = false;
//                    break;
//                }
//            }
//            if (flagCheck) {
//                break;
//            }
//        }
//        System.out.println("Employee code is: " + code);
//        System.out.print("Enter service name: ");
//        serviceName = sc.nextLine();
//        System.out.print("Enter usable area: ");
//        usableArea = Double.parseDouble(sc.nextLine());
//        System.out.print("Enter rental cost: ");
//        rentalCost = Double.parseDouble(sc.nextLine());
//        System.out.print("Enter maximum number of people: ");
//        maximumNumberOfPeople = Integer.parseInt(sc.nextLine());
//        System.out.print("Enter rental type: ");
//        rentalType = sc.nextLine();
//        System.out.print("Enter room standard: ");
//        roomStandard = sc.nextLine();
//        System.out.print("Enter number of floor: ");
//        numberOfFloor = Integer.parseInt(sc.nextLine());
//
//        return new House(serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType, roomStandard, numberOfFloor);
//    }

//    private static LinkedHashMap<House, Integer> getDataFromFile(){
//        File file = new File("src\\case_study_furama_resort_module_2\\data\\facility_house_data.csv");
//        FileReader fileReader;
//        BufferedReader bufferedReader;
//        LinkedHashMap<House, Integer> housesList = new LinkedHashMap<>();
//
//        try {
//            fileReader = new FileReader(file);
//            bufferedReader = new BufferedReader(fileReader);
//            String line;
//            String[] str;
//            while ((line = bufferedReader.readLine()) != null){
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

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
