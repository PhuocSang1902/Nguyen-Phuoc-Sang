package case_study_furama_resort_module_2.services._impl;

import case_study_furama_resort_module_2.models.Booking;
import case_study_furama_resort_module_2.models.Contract;
import case_study_furama_resort_module_2.services.ContractService;
import case_study_furama_resort_module_2.utils.CheckUtils;
import case_study_furama_resort_module_2.utils.FormatException;

import java.security.SecureRandom;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ContractServiceImpl implements ContractService {

    private static List<Contract> contractList = new LinkedList<>();
    private static final Scanner SC = new Scanner(System.in);
    private static BookingServiceImpl bookingService = new BookingServiceImpl();

    private Contract inputInfo() {
        String contractNumber;
        String bookingCode;
        double advanceDepositAmount;
        double totalPaymentAmount;
        String customerCode;


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
            Set<Booking> bookingList = bookingService.getDataFromFile();
            bookingService.display();
            System.out.println("Enter the booking code: ");
            bookingCode = SC.nextLine();
            boolean flagCheck = false;
            for (Booking booking : bookingList){
                if (booking.getBookingCode().equals(bookingCode)){
                    flagCheck = true;
                    break;
                }
            }
            if (flagCheck){
                break;
            }else {
                System.out.println("Booking code is not exist. Enter again!");
            }
            try {
                CheckUtils.checkBookingCode(bookingCode);
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true){
            System.out.println("Enter ");
        }
    }

    private String getInfo(Contract contract) {
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("%s,%s,%s,%s,%s",
                contract.getContractNumber(), contract.getBookingCode(), contract.getAdvanceDepositAmount(), contract.getTotalPaymentAmount(), contract.getCustomerCode());
    }

    @Override
    public void display() {

    }

    @Override
    public void add() {

    }
}
