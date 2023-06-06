package case_study_furama_resort_module_2.services._impl;

import case_study_furama_resort_module_2.models.Booking;
import case_study_furama_resort_module_2.models.Contract;
import case_study_furama_resort_module_2.services.ContractService;
import case_study_furama_resort_module_2.utils.CheckUtils;
import case_study_furama_resort_module_2.utils.FormatException;

import java.io.*;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ContractServiceImpl implements ContractService {

    private static List<Contract> contractList = new LinkedList<>();
    private static final Scanner SC = new Scanner(System.in);
    private static BookingServiceImpl bookingService = new BookingServiceImpl();
    private static final String PATH = "src\\case_study_furama_resort_module_2\\data\\contract.csv";

    private Contract inputInfo() {
        String contractNumber;
        String bookingCode;
        double advanceDepositAmount;
        double totalPaymentAmountFinal;
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
            for (Booking booking : bookingList) {
                if (booking.getBookingCode().equals(bookingCode)) {
                    flagCheck = true;
                    break;
                }
            }
            if (!flagCheck) {
                System.out.println("Booking code is not exist. Enter again!");
            } else if (contractList != null) {
                for (Contract contract : contractList) {
                    if (contract.getBookingCode().equals(bookingCode)) {
                        flagCheck = false;
                        System.out.println("This booking created agreement");
                        break;
                    }
                }
            }
            if (flagCheck) {
                break;
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

        while (true) {
            System.out.println("Enter total payment amount: ");
            try {
                double totalPaymentAmount = Double.parseDouble(SC.nextLine());
                totalPaymentAmountFinal = totalPaymentAmount - advanceDepositAmount;
                break;
            } catch (Exception e) {
                System.out.println("Wrong format enter again");
            }
        }

        while (true) {
            Set<Booking> bookingList = bookingService.getDataFromFile();
            bookingService.display();
            System.out.println("Enter the customer code: ");

            customerCode = SC.nextLine();
            boolean flagCheck = false;
            for (Booking booking : bookingList) {
                if (booking.getCustomerCode().equals(customerCode)) {
                    flagCheck = true;
                    break;
                }
            }
            if (!flagCheck) {
                System.out.println("Customer code is not exist. Enter again!");
            } else if (contractList != null) {
                for (Contract contract : contractList) {
                    if (contract.getCustomerCode().equals(customerCode)) {
                        flagCheck = false;
                        System.out.println("This customer created agreement");
                        break;
                    }
                }
            }
            if (flagCheck) {
                break;
            }
        }


        return new Contract(contractNumber, bookingCode, advanceDepositAmount, totalPaymentAmountFinal, customerCode);
    }

    private String getInfo(Contract contract) {
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
                contract.setAdvanceDepositAmount(Double.parseDouble(info[2]));
                contract.setTotalPaymentAmount(Double.parseDouble(info[3]));
                contract.setCustomerCode(info[4]);

                contractList.add(contract);
            }
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
        for (Contract contract : contractList) {
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
        for (Contract contract : contractList) {
            if (contract.getContractNumber().equals(numberOfContract)) {
                System.out.println("Enter new booking code");
                String bookingCode = SC.nextLine();
                contract.setBookingCode(bookingCode);
                flagCheck = true;
                break;
            }
        }
        if (flagCheck) {
            System.out.println("Successfully edit.");
        } else {
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
        for (Contract contract : contractList) {
            if (contract.getContractNumber().equals(numberOfContract)) {
                System.out.println("Enter new advance deposit amount code");
                double advanceDepositAmount = Double.parseDouble(SC.nextLine());
                contract.setAdvanceDepositAmount(advanceDepositAmount);
                flagCheck = true;
                break;
            }
        }
        if (flagCheck) {
            System.out.println("Successfully edit.");
        } else {
            System.out.println("Number of contract is not exist");
        }
        writeFile(contractList);
    }
}
