package case_study_furama_resort_module_2.services.impl.facility_service_impl;

import case_study_furama_resort_module_2.models.facility.Room;
import case_study_furama_resort_module_2.services.facility_service.FacilityRoomService;

import java.io.*;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class FacilityRoomServiceImpl implements FacilityRoomService {
    private static final Scanner SC = new Scanner(System.in);
    private static LinkedHashMap<Room, Integer> roomsList = new LinkedHashMap<>();

    private Room inputInfoRoom() {
        String serviceName;
        double usableArea;
        double rentalCost;
        int maximumNumberOfPeople;
        String rentalType;
        String freeServiceIncluded;
        String code;

        while (true) {
            String rangeID = "0123456789";
            SecureRandom random = new SecureRandom();

            StringBuilder tempCode = new StringBuilder("SVRO-");
            for (int i = 0; i < 4; i++) {
                tempCode.append(rangeID.charAt(random.nextInt(rangeID.length())));
            }
            code = tempCode.toString();
            boolean flagCheck = true;
            Set<Room> keyList = roomsList.keySet();
            for (Room room : keyList) {
                if (room.getFacilityCode().equals(code)) {
                    flagCheck = false;
                    break;
                }
            }
            if (flagCheck) {
                break;
            }
        }
        System.out.println("Facility code is: " + code);

        System.out.print("Enter service name: ");
        serviceName = SC.nextLine();
        while (true) {
            System.out.print("Enter usable area: ");
            try {
                usableArea = Double.parseDouble(SC.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format.Enter again.");
            }
        }
        while (true) {
            System.out.print("Enter rental cost: ");
            try {
                rentalCost = Double.parseDouble(SC.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format.Enter again.");
            }
        }
        while (true) {
            System.out.print("Enter maximum number of people: ");
            try {
                maximumNumberOfPeople = Integer.parseInt(SC.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format.Enter again.");
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

        System.out.print("Enter free service included: ");
        freeServiceIncluded = SC.nextLine();


        return new Room(code, serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType, freeServiceIncluded);
    }

    private LinkedHashMap<Room, Integer> getDataFromFile() {
        LinkedHashMap<Room, Integer> roomsList = new LinkedHashMap<>();

        File file = new File("src\\case_study_furama_resort_module_2\\data\\facility_room_facility_data.csv");
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
                Room room = new Room();
                room.setFacilityCode(info[0]);
                room.setServiceName(info[1]);
                room.setUsableArea(Double.parseDouble(info[2]));
                room.setRentalCost(Double.parseDouble(info[3]));
                room.setMaximumNumberOfPeople(Integer.parseInt(info[4]));
                room.setRentalType(info[5]);
                room.setFreeServiceIncluded(info[6]);
                Integer value = Integer.parseInt(info[7]);
                roomsList.put(room, value);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return roomsList;
    }

    private void writeFile(LinkedHashMap<Room, Integer> roomsList) {
        File file = new File("src\\case_study_furama_resort_module_2\\data\\facility_room_facility_data.csv");
        if (!file.exists()) {
            System.out.println("File is not exist");
        }

        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Room> rooms = new LinkedHashSet<>();
            rooms = roomsList.keySet();
            for (Room room : rooms) {
                bufferedWriter.write(getInfo(room) + "," + roomsList.get(room));
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

    private String getInfo(Room room) {
        return String.format("%s,%s,%s,%s,%s,%s,%s", room.getFacilityCode(), room.getServiceName(), room.getUsableArea(), room.getRentalCost(), room.getMaximumNumberOfPeople(), room.getRentalType(), room.getFreeServiceIncluded());

    }


    @Override
    public void displayMaintenanceList() {

    }

    @Override
    public void display() {
        roomsList = getDataFromFile();
        Set<Room> rooms = new LinkedHashSet<>();
        rooms = roomsList.keySet();
        for (Room room : rooms) {
            System.out.println(room.toString());
        }
    }

    @Override
    public void add() {
        roomsList = getDataFromFile();
        Room room = inputInfoRoom();
        roomsList.put(room, 0);
        writeFile(roomsList);
    }
}
