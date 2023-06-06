package case_study_furama_resort_module_2.services._impl.facility_service_impl;

import case_study_furama_resort_module_2.models.facility.House;
import case_study_furama_resort_module_2.services.facility_service.FacilityHouseService;
import case_study_furama_resort_module_2.utils.CheckUtils;
import case_study_furama_resort_module_2.utils.FormatException;

import java.io.*;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class FacilityHouseServiceImpl implements FacilityHouseService {
    private static Scanner SC = new Scanner(System.in);
    private static LinkedHashMap<House, Integer> housesList = new LinkedHashMap<>();

    private House inputInfoHouse() {
        String code;
        String serviceName;
        double usableArea;
        double rentalCost;
        int maximumNumberOfPeople;
        String rentalType;
        String roomStandard;
        int numberOfFloor;

        while (true) {
            String rangeID = "0123456789";
            SecureRandom random = new SecureRandom();

            StringBuilder tempCode = new StringBuilder("SVHO-");
            for (int i = 0; i < 4; i++) {
                tempCode.append(rangeID.charAt(random.nextInt(rangeID.length())));
            }
            code = tempCode.toString();
            boolean flagCheck = true;
            Set<House> keyList = housesList.keySet();
            for (House house : keyList) {
                if (house.getFacilityCode().equals(code)) {
                    flagCheck = false;
                    break;
                }
            }
            if (flagCheck) {
                break;
            }
        }
        System.out.println("Facility code is: " + code);

        while (true) {
            System.out.print("Enter service name: ");
            serviceName = SC.nextLine();
            try {
                CheckUtils.checkNameService(serviceName);
                break;
            } catch (FormatException e) {
                e.getStackTrace();
            }
        }

        while (true) {
            System.out.print("Enter usable area: ");
            try {
                usableArea = Double.parseDouble(SC.nextLine());
                CheckUtils.checkArea(usableArea);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format.Enter again.");
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("Enter rental cost: ");
            try {
                rentalCost = Double.parseDouble(SC.nextLine());
                CheckUtils.checkMoney(rentalCost);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format.Enter again.");
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            System.out.print("Enter maximum number of people: ");
            try {
                maximumNumberOfPeople = Integer.parseInt(SC.nextLine());
                CheckUtils.checkNumberOfPeople(maximumNumberOfPeople);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format.Enter again.");
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("1.Rental by year\n2.Rental by month\n3.Rental by day\n2.Rental by hours\nEnter rental type follow number: ");
            int choice = 0;
            boolean flagChoice = false;
            try {
                choice = Integer.parseInt(SC.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong format.Enter again.");
            }
            switch (choice) {
                case 1:
                    rentalType = "Rental by year";
                    flagChoice = true;
                    break;
                case 2:
                    rentalType = "Rental by month";
                    flagChoice = true;
                    break;
                case 3:
                    rentalType = "Rental by day";
                    flagChoice = true;
                    break;
                case 4:
                    rentalType = "Rental by hours";
                    flagChoice = true;
                    break;
                default:
                    rentalType = null;
                    System.out.println("Wrong choice.Enter again.");
            }
            if (flagChoice) {
                break;
            }
        }

        while (true) {
            System.out.print("1.Superior Room\n2.Deluxe Room\n3.Suite Room\nEnter room standard follow number: ");
            String choice = SC.nextLine();

            switch (choice) {
                case "1":
                    roomStandard = "Superior room";
                    break;
                case "2":
                    roomStandard = "Deluxe room";
                    break;
                case "3":
                    roomStandard = "Suite room";
                    break;
                default:
                    roomStandard = null;
                    System.out.println("Wrong format! Enter again.");
            }
            try {
                if (roomStandard != null) {
                    CheckUtils.checkNameService(roomStandard);
                }
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("Enter number of floor: ");
            try {
                numberOfFloor = Integer.parseInt(SC.nextLine());
                CheckUtils.checkNumberOfFloors(numberOfFloor);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format. Enter again");
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        return new House(code, serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType, roomStandard, numberOfFloor);
    }

    public LinkedHashMap<House, Integer> getDataFromFile() {
        LinkedHashMap<House, Integer> housesList = new LinkedHashMap<>();

        File file = new File("src\\case_study_furama_resort_module_2\\data\\facility_house_data.csv");
        if (!file.exists()) {
            System.out.println("File is not exist");
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                House house = new House();
                house.setFacilityCode(info[0]);
                house.setServiceName(info[1]);
                house.setUsableArea(Double.parseDouble(info[2]));
                house.setRentalCost(Double.parseDouble(info[3]));
                house.setMaximumNumberOfPeople(Integer.parseInt(info[4]));
                house.setRentalType(info[5]);
                house.setRoomStandard(info[6]);
                house.setNumberOfFloor(Integer.parseInt(info[7]));
                Integer value = Integer.parseInt(info[8]);
                housesList.put(house, value);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not exist");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return housesList;
    }

    public void writeFile(LinkedHashMap<House, Integer> housesList) {
        File file = new File("src\\case_study_furama_resort_module_2\\data\\facility_house_data.csv");
        if (!file.exists()) {
            System.out.println("File is not exist");
        }

        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<House> houses = new LinkedHashSet<>();
            houses = housesList.keySet();
            for (House house : houses) {
                bufferedWriter.write(getInfo(house) + "," + housesList.get(house));
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getInfo(House house) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", house.getFacilityCode(), house.getServiceName(), house.getUsableArea(), house.getRentalCost(), house.getMaximumNumberOfPeople(), house.getRentalType(), house.getRoomStandard(), house.getNumberOfFloor());

    }

    @Override
    public void displayMaintenanceList() {

    }

    @Override
    public void display() {
        housesList = getDataFromFile();
        Set<House> houses = new LinkedHashSet<>();
        houses = housesList.keySet();
        for (House house : houses) {
            System.out.println(house.toString() + "," + housesList.get(house));
        }

    }

    @Override
    public void add() {
        housesList = getDataFromFile();
        House house = inputInfoHouse();
        housesList.put(house, 0);
        writeFile(housesList);
    }
}
