package case_study_furama_resort_module_2.services._impl;

import case_study_furama_resort_module_2.models.Booking;
import case_study_furama_resort_module_2.models.Contract;
import case_study_furama_resort_module_2.models.facility.House;
import case_study_furama_resort_module_2.models.facility.Room;
import case_study_furama_resort_module_2.models.facility.Villa;
import case_study_furama_resort_module_2.models.person.Customer;
import case_study_furama_resort_module_2.services.BookingService;
import case_study_furama_resort_module_2.services._impl.facility_service_impl.FacilityHouseServiceImpl;
import case_study_furama_resort_module_2.services._impl.facility_service_impl.FacilityRoomServiceImpl;
import case_study_furama_resort_module_2.services._impl.facility_service_impl.FacilityVillaServiceImpl;
import case_study_furama_resort_module_2.services._impl.people_service_impl.CustomerServiceImpl;
import case_study_furama_resort_module_2.utils.CheckUtils;
import case_study_furama_resort_module_2.utils.FormatException;

import java.io.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingServiceImpl implements BookingService {

    private static CustomerServiceImpl customerService = new CustomerServiceImpl();
    private static FacilityVillaServiceImpl facilityVillaService = new FacilityVillaServiceImpl();
    private static FacilityHouseServiceImpl facilityHouseService = new FacilityHouseServiceImpl();
    private static FacilityRoomServiceImpl facilityRoomService = new FacilityRoomServiceImpl();
    private static final Scanner SC = new Scanner(System.in);
    private static final String PATH = "src\\case_study_furama_resort_module_2\\data\\booking.csv";
    private static TreeSet<Booking> bookingList = new TreeSet<>();
    private static ContractServiceImpl contractService = new ContractServiceImpl();

    private Booking inputInfo() {

        String code;
        LocalDate startDay;
        LocalDate endDay;
        String customerCode;
        String serviceCode;
        String serviceType;

        while (true) {
            String rangeID = "0123456789";
            SecureRandom random = new SecureRandom();

            StringBuilder tempCode = new StringBuilder("BK");
            for (int i = 0; i < 4; i++) {
                tempCode.append(rangeID.charAt(random.nextInt(rangeID.length())));
            }
            code = tempCode.toString();
            boolean flagCheck = true;
            for (Booking booking : bookingList) {
                if (booking.getBookingCode().equals(code)) {
                    flagCheck = false;
                    break;
                }
            }
            if (flagCheck) {
                break;
            }
        }
        System.out.println("Booking code is: " + code);

        while (true) {
            System.out.print("Enter the booking start day (dd-MM-yyyy): ");

            try {
                String date = SC.nextLine();
                CheckUtils.checkDate(date);
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                startDay = LocalDate.parse(date, fm);
                break;
            } catch (NumberFormatException | FormatException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Enter the booking end day (dd-MM-yyyy): ");

            try {
                String date = SC.nextLine();
                CheckUtils.checkDate(date);
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                endDay = LocalDate.parse(date, fm);
                if (endDay.isAfter(startDay)) {
                    break;
                } else {
                    System.out.println("Input again. End day has to be after start day.");
                }

            } catch ( NumberFormatException | FormatException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            customerService.display();
            System.out.println("Enter the customer code: ");
            customerCode = SC.nextLine();
            try {
                CheckUtils.checkCustomerCode(customerCode);
                boolean flagCheck = false;
                for (Customer customer : customerService.getDataFromFile()) {
                    if (customer.getCode().equals(customerCode)) {
                        flagCheck = true;
                        break;
                    }
                }
                if (flagCheck) {
                    break;
                } else {
                    System.out.println("Wrong customer code. Enter again!");
                }
            } catch (FormatException e) {
                e.printStackTrace();
                System.out.println("Enter again!");
            }
        }

        while (true) {
            facilityVillaService.display();
            facilityHouseService.display();
            facilityRoomService.display();

            System.out.println("Enter the service code: ");
            serviceCode = SC.nextLine();
            try {
                CheckUtils.checkFacilityCode(serviceCode);
                boolean flagCheck = false;
                if (serviceCode.contains("SVHO")) {
                    Set<House> houses;
                    houses = facilityHouseService.getDataFromFile().keySet();
                    for (House house : houses) {
                        if (house.getFacilityCode().equals(serviceCode)) {
                            flagCheck = true;
                            break;
                        }
                    }
                } else if (serviceCode.contains("SVRO")) {
                    Set<Room> rooms;
                    rooms = facilityRoomService.getDataFromFile().keySet();
                    for (Room room : rooms) {
                        if (room.getFacilityCode().equals(serviceCode)) {
                            flagCheck = true;
                            break;
                        }
                    }
                } else if (serviceCode.contains("SVVL")) {
                    Set<Villa> villas;
                    villas = facilityVillaService.getDataFromFile().keySet();
                    for (Villa villa : villas) {
                        if (villa.getFacilityCode().equals(serviceCode)) {
                            flagCheck = true;
                            break;
                        }
                    }
                }

                if (flagCheck) {
                    break;
                } else {
                    System.out.println("Wrong facility code. Enter again!");
                }
            } catch (FormatException e) {
                e.printStackTrace();
                System.out.println("Enter again!");
            }
        }

        while (true) {
            System.out.println("1.1 star service\n2.2 stars service\n3.3 stars service\nEnter the service type follow the number: ");
            String choice = SC.nextLine();
            boolean flagCheck = false;
            switch (choice) {
                case "1":
                    serviceType = "1 star service";
                    flagCheck = true;
                    break;
                case "2":
                    serviceType = "2 star service";
                    flagCheck = true;
                    break;
                case "3":
                    serviceType = "3 star service";
                    flagCheck = true;
                    break;
                default:
                    serviceType = null;
                    System.out.println("Wrong format! Enter again!");
            }
            if (flagCheck) {
                break;
            }
        }

        return new Booking(code, startDay, endDay, customerCode, serviceCode, serviceType);
    }

    public TreeSet<Booking> getDataFromFile() {
        File file = new File(PATH);

        if (!file.exists()) {
            System.out.println("File is not exist.");
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        TreeSet<Booking> bookingList = new TreeSet<>();

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] info;
            Booking booking;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                booking = new Booking();
                booking.setBookingCode(info[0]);
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                booking.setStartDay(LocalDate.parse(info[1], fm));
                booking.setEndDay(LocalDate.parse(info[2], fm));
                booking.setCustomerCode(info[3]);
                booking.setServiceCode(info[4]);
                booking.setServiceType(info[5]);

                bookingList.add(booking);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bookingList;
    }

    private void writeFile(TreeSet<Booking> bookingList) {
        File file = new File(PATH);

        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking booking : bookingList) {
                bufferedWriter.write(getInfo(booking));
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

    private String getInfo(Booking booking) {
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("%s,%s,%s,%s,%s,%s",
                booking.getBookingCode(), booking.getStartDay().format(fm), booking.getEndDay().format(fm), booking.getCustomerCode(), booking.getServiceCode(), booking.getServiceType());
    }

    @Override
    public void display() {
        List<Contract> contractList = contractService.getDataFromFile();
        bookingList = getDataFromFile();
        for (Booking booking : bookingList) {
            System.out.println(booking.toString());
            boolean flag = false;
            String contractNumber = null;
            for (Contract contract : contractList) {
                if (contract.getBookingCode().equals(booking.getBookingCode())) {
                    flag = true;
                    contractNumber = contract.getContractNumber();
                    break;
                }
            }
            if (flag) {
                System.out.println("This booking has contract number is " + contractNumber);
            } else if (booking.getServiceCode().contains("SVHO")){
                System.out.println("This booking is miss contract");
            }else if (booking.getServiceCode().contains("SVVL")){
                System.out.println("This booking is miss contract");
            }
            System.out.println();
        }
    }

    @Override
    public void add() {
        bookingList = getDataFromFile();
        Booking booking = inputInfo();
        bookingList.add(booking);
        if (booking.getServiceCode().contains("SVHO")) {
            LinkedHashMap<House, Integer> houseList = facilityHouseService.getDataFromFile();
            Set<House> houses = houseList.keySet();
            for (House house : houses) {
                if (house.getFacilityCode().equals(booking.getServiceCode())) {
                    houseList.replace(house, houseList.get(house) + 1);
                    break;
                }
            }
            facilityHouseService.writeFile(houseList);
            System.out.println("Remember to make a rental agreement");
        } else if (booking.getServiceCode().contains("SVRO")) {
            LinkedHashMap<Room, Integer> roomList = facilityRoomService.getDataFromFile();
            Set<Room> roomSet = roomList.keySet();
            for (Room room : roomSet) {
                if (room.getFacilityCode().equals(booking.getServiceCode())) {
                    roomList.replace(room, roomList.get(room) + 1);
                    break;
                }
            }
            facilityRoomService.writeFile(roomList);
        } else if (booking.getServiceCode().contains("SVVL")) {
            LinkedHashMap<Villa, Integer> villaList = facilityVillaService.getDataFromFile();
            Set<Villa> villaSet = villaList.keySet();
            for (Villa villa : villaSet) {
                if (villa.getFacilityCode().equals(booking.getServiceCode())) {
                    villaList.replace(villa, villaList.get(villa) + 1);
                    break;
                }
            }
            facilityVillaService.writeFile(villaList);
            System.out.println("Remember to make a rental agreement");
        }
        writeFile(bookingList);
    }
}
