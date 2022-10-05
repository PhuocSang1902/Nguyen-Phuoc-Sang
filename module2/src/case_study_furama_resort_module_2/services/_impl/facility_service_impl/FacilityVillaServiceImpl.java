package case_study_furama_resort_module_2.services._impl.facility_service_impl;

import case_study_furama_resort_module_2.models.facility.Villa;
import case_study_furama_resort_module_2.services.facility_service.FacilityVillaService;
import case_study_furama_resort_module_2.utils.CheckUtils;
import case_study_furama_resort_module_2.utils.FormatException;

import java.io.*;
import java.security.SecureRandom;
import java.util.*;

public class FacilityVillaServiceImpl implements FacilityVillaService {
    private static final Scanner SC = new Scanner(System.in);
    private static LinkedHashMap<Villa, Integer> villasList = new LinkedHashMap<>();
    private static final String PATH = "src\\case_study_furama_resort_module_2\\data\\facility_villa_data.csv";

    private Villa inputInfoVilla() {
        String code;
        String serviceName;
        double usableArea;
        double rentalCost;
        int maximumNumberOfPeople;
        String rentalType;
        String standardRoom;
        double poolArea;
        int numberOfFloor;

        while (true) {
            String rangeID = "0123456789";
            SecureRandom random = new SecureRandom();

            StringBuilder tempCode = new StringBuilder("SVVL-");
            for (int i = 0; i < 4; i++) {
                tempCode.append(rangeID.charAt(random.nextInt(rangeID.length())));
            }
            code = tempCode.toString();
            boolean flagCheck = true;
            Set<Villa> keyList = villasList.keySet();
            for (Villa villa : keyList) {
                if (villa.getFacilityCode().equals(code)) {
                    flagCheck = false;
                    break;
                }
            }
            if (flagCheck) {
                break;
            }
        }
        System.out.println("Facility code is: " + code);

        while (true){
            System.out.print("Enter service name: ");
            serviceName = SC.nextLine();
            try {
                CheckUtils.checkNameService(serviceName);
                break;
            } catch (FormatException e) {
                System.out.println("Wrong format. Enter again!");
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

        while (true){
            System.out.print("1.Superior Room\n2.Deluxe Room\n3.Suite Room\nEnter room standard follow number: ");
            String choice = SC.nextLine();

            switch (choice){
                case "1":
                    standardRoom = "Superior Room";
                    break;
                case "2":
                    standardRoom = "Deluxe Room";
                    break;
                case "3":
                    standardRoom = "Suite Room";
                    break;
                default:
                    standardRoom = null;
                    System.out.println("Wrong format! Enter again.");
            }
            try {
                if (standardRoom != null) {
                    CheckUtils.checkNameService(standardRoom);
                }
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true){
            System.out.print("Enter pool area: ");
            try{
                poolArea = Double.parseDouble(SC.nextLine());
                CheckUtils.checkArea(poolArea);
                break;
            }catch (NumberFormatException e){
                System.out.println("Wrong format.Enter again");
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

        return new Villa(code, serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType, standardRoom, poolArea, numberOfFloor);
    }

    public LinkedHashMap<Villa, Integer> getDataFromFile() {
        LinkedHashMap<Villa, Integer> villasList = new LinkedHashMap<>();

        File file = new File(PATH);
        if (!file.exists()) {
            System.out.println("File is not exist");
        }

        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                Villa villa = new Villa();
                villa.setFacilityCode(info[0]);
                villa.setServiceName(info[1]);
                villa.setUsableArea(Double.parseDouble(info[2]));
                villa.setRentalCost(Double.parseDouble(info[3]));
                villa.setMaximumNumberOfPeople(Integer.parseInt(info[4]));
                villa.setRentalType(info[5]);
                villa.setStandardRoom(info[6]);
                villa.setPoolArea(Double.parseDouble(info[7]));
                villa.setNumberOfFloor(Integer.parseInt(info[8]));
                Integer value = Integer.parseInt(info[9]);
                villasList.put(villa, value);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return villasList;
    }

    private void writeFile(LinkedHashMap<Villa, Integer> villasList) {
        File file = new File(PATH);
        if (!file.exists()) {
            System.out.println("File is not exist");
        }

        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Villa> villas;
            villas = villasList.keySet();
            for (Villa villa : villas) {
                bufferedWriter.write(getInfo(villa) + "," + villasList.get(villa));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getInfo(Villa villa) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", villa.getFacilityCode(), villa.getServiceName(), villa.getUsableArea(), villa.getRentalCost(), villa.getMaximumNumberOfPeople(), villa.getRentalType(), villa.getStandardRoom(), villa.getPoolArea(), villa.getNumberOfFloor());

    }

    @Override
    public void displayMaintenanceList() {

    }

    @Override
    public void display() {
        villasList = getDataFromFile();
        Set<Villa> villas;
        villas = villasList.keySet();
        for (Villa villa : villas){
            System.out.println(villa.toString());
        }
    }

    @Override
    public void add() {
        villasList = getDataFromFile();
        Villa villa = inputInfoVilla();
        villasList.put(villa, 0);
        writeFile(villasList);
    }
}
