package case_study_furama_resort_module_2.services._impl;

import case_study_furama_resort_module_2.models.Booking;
import case_study_furama_resort_module_2.models.Contract;
import case_study_furama_resort_module_2.models.facility.House;
import case_study_furama_resort_module_2.models.facility.Villa;
import case_study_furama_resort_module_2.services.ContractService;
import case_study_furama_resort_module_2.services._impl.facility_service_impl.FacilityHouseServiceImpl;
import case_study_furama_resort_module_2.services._impl.facility_service_impl.FacilityVillaServiceImpl;
import case_study_furama_resort_module_2.utils.CheckUtils;
import case_study_furama_resort_module_2.utils.FormatException;

import java.io.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ContractServiceImpl implements ContractService {

    private static List<Contract> contractList = new LinkedList<>();
    private static final Scanner SC = new Scanner(System.in);
    private static BookingServiceImpl bookingService = new BookingServiceImpl();
    private static FacilityVillaServiceImpl facilityVillaService = new FacilityVillaServiceImpl();
    private static FacilityHouseServiceImpl facilityHouseService = new FacilityHouseServiceImpl();
    private static final String PATH = "src\\case_study_furama_resort_module_2\\data\\contract.csv";

    private Contract inputInfo() {
        String contractNumber;
        String bookingCode;
        double advanceDepositAmount;
        double totalPaymentAmount = 0;
        String customerCode = null;


        while (true) {
            String rangeID = "0123456789";
            SecureRandom random = new SecureRandom();

            StringBuilder tempCode = new StringBuilder("AG");
            for (int i = 0; i < 4; i++) {
                tempCode.append(rangeID.charAt(random.nextInt(rangeID.length())));
            }
            contractNumber = tempCode.toString();
            boolean flagCheck = true;
            for (Contract contract : contractList) {
                if (contract.getContractNumber().equals(contractNumber)) {
                    flagCheck = false;
                    break;
                }
            }
            if (flagCheck) {
                break;
            }
        }
        System.out.println("Contract number is: " + contractNumber);

        while (true) {
            System.out.println("Enter the booking code: ");
            Set<Booking> bookingList = bookingService.getDataFromFile();
            bookingService.display();
            bookingCode = SC.nextLine();
            boolean flagCheck = false;
            for (Booking booking : bookingList) {
                if (booking.getBookingCode().equals(bookingCode)) {
                    flagCheck = true;
                    break;
                }
            }
            if (flagCheck) {
                break;
            } else {
                System.out.println("Booking code is not exist. Enter again!");
            }
            try {
                CheckUtils.checkBookingCode(bookingCode);
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.println("Enter advance deposit amount: ");
            try {
                advanceDepositAmount = Double.parseDouble(SC.nextLine());
                CheckUtils.checkMoney(advanceDepositAmount);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format.Enter again!");
            } catch (FormatException e) {
                e.printStackTrace();
                System.out.println("It has to greater than or equal zero.Enter again!");
            }

        }

        Set<Booking> bookingList = bookingService.getDataFromFile();
        String serviceCode = null;
        LocalDate startDay = null;
        LocalDate endDay = null;

        for (Booking booking : bookingList) {
            if (booking.getBookingCode().equals(bookingCode)) {
                serviceCode = booking.getServiceCode();
                startDay = booking.getStartDay();
                endDay = booking.getEndDay();
                customerCode = booking.getCustomerCode();
                break;
            }
        }
        double rentalCost = 0;
        if (serviceCode != null) {
            if (serviceCode.contains("SVVL")) {
                LinkedHashMap<Villa, Integer> villas = facilityVillaService.getDataFromFile();
                Set<Villa> villaSet = villas.keySet();
                for (Villa villa : villaSet) {
                    if (villa.getFacilityCode().equals(serviceCode)) {
                        rentalCost = villa.getRentalCost();
                        break;
                    }
                }
                Period period = null;
                if (endDay != null) {
                    period = Period.between(startDay, endDay);
                    totalPaymentAmount = rentalCost * period.getDays() - advanceDepositAmount;
                }
            } else if (serviceCode.contains("SVHO")) {
                LinkedHashMap<House, Integer> Houses = facilityHouseService.getDataFromFile();
                Set<House> houseSet = Houses.keySet();
                for (House house : houseSet) {
                    if (house.getFacilityCode().equals(serviceCode)) {
                        rentalCost = house.getRentalCost();
                        break;
                    }
                }
                Period period = null;
                if (endDay != null) {
                    period = Period.between(startDay, endDay);
                    totalPaymentAmount = rentalCost * period.getDays() - advanceDepositAmount;
                }
            }
        } else {
            System.out.println("Booking code is wrong.");
        }

        System.out.println("Customer code is " + customerCode);

        return new Contract(contractNumber, bookingCode, advanceDepositAmount, totalPaymentAmount, customerCode);
    }

    private String getInfo(Contract contract) {
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("%s,%s,%s,%s,%s",
                contract.getContractNumber(), contract.getBookingCode(), contract.getAdvanceDepositAmount(), contract.getTotalPaymentAmount(), contract.getCustomerCode());
    }

    public List<Contract> getDataFromFile() {
        File file = new File(PATH);

        if (!file.exists()) {
            System.out.println("File is not exist.");
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        List<Contract> contractList = new LinkedList<>();

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] info;
            Contract contract;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                contract = new Contract();
                contract.setContractNumber(info[0]);
                contract.setBookingCode(info[1]);
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                contract.setAdvanceDepositAmount(Double.parseDouble(info[2]));
                contract.setTotalPaymentAmount(Double.parseDouble(info[3]));
                contract.setCustomerCode(info[4]);

                contractList.add(contract);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    private void writeFile(List<Contract> contractList) {
        File file = new File(PATH);

        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Contract contract : contractList) {
                bufferedWriter.write(getInfo(contract));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
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

    @Override
    public void display() {
        contractList = getDataFromFile();
        for (Contract contract : contractList){
            System.out.println(contract.toString());
        }

    }

    @Override
    public void add() {
        contractList = getDataFromFile();
        Contract contract = inputInfo();
        contractList.add(contract);
        writeFile(contractList);
    }

    @Override
    public void editBookingCode() {
        contractList = getDataFromFile();
        display();
        System.out.print("Enter the number of contract: ");
        String numberOfContract = SC.nextLine();
        boolean flagCheck = false;
        for (Contract contract : contractList){
            if (contract.getContractNumber().equals(numberOfContract)){
                System.out.println("Enter new booking code");
                String bookingCode = SC.nextLine();
                contract.setBookingCode(bookingCode);
                flagCheck = true;
                break;
            }
        }
        if (flagCheck){
            System.out.println("Successfully edit.");
        }else {
            System.out.println("Number of contract is not exist");
        }
        writeFile(contractList);
    }

    @Override
    public void editAdvanceDepositAmount() {
        contractList = getDataFromFile();
        display();
        System.out.print("Enter the number of contract: ");
        String numberOfContract = SC.nextLine();
        boolean flagCheck = false;
        for (Contract contract : contractList){
            if (contract.getContractNumber().equals(numberOfContract)){
                System.out.println("Enter new advance deposit amount code");
                double advanceDepositAmount = Double.parseDouble(SC.nextLine());
                contract.setAdvanceDepositAmount(advanceDepositAmount);
                break;
            }
        }
        if (flagCheck){
            System.out.println("Successfully edit.");
        }else {
            System.out.println("Number of contract is not exist");
        }
        writeFile(contractList);
    }
}
