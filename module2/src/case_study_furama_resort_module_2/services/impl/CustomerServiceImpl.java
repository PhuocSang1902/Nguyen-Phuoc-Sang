package case_study_furama_resort_module_2.services.impl;

import case_study_furama_resort_module_2.models.person.Customer;
import case_study_furama_resort_module_2.services.CustomerService;
import case_study_furama_resort_module_2.utils.CheckUtils;
import case_study_furama_resort_module_2.utils.FormatException;

import java.io.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {

    public static List<Customer> customerList = new LinkedList<>();
    public static Scanner sc = new Scanner(System.in);

    private static Customer inputInfo() {
        String code;
        String fullName;
        LocalDate dateOfBirth;
        String gender;
        String idNumber;
        String phoneNumber;
        String email;
        String guestType;
        String address;

        while (true) {
            String rangeID = "0123456789";
            SecureRandom random = new SecureRandom();

            StringBuilder tempCode=new StringBuilder("E");
            for (int i = 0; i < 3; i++) {
                tempCode.append(rangeID.charAt(random.nextInt(rangeID.length())));
            }
            code = tempCode.toString();
            boolean flagCheck = true;
            for (Customer customer : customerList) {
                if (customer.getCode().equals(code)) {
                    flagCheck = false;
                    break;
                }
            }
            if (flagCheck) {
                break;
            }
        }
        System.out.println("Customer code is: " + code);

        while (true) {
            System.out.print("Enter customer full name: ");
            fullName = sc.nextLine();
            try {
                CheckUtils.checkName(fullName);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            System.out.print("Enter customer birthday (dd-MM-yyyy): ");

            try {
                String date = sc.nextLine();
                CheckUtils.checkDate(date);
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                dateOfBirth = LocalDate.parse(date,fm);
                break;
            } catch (FormatException | NumberFormatException | DateTimeParseException e) {
                System.out.println("Format error!");
            }
        }

        while (true) {
            System.out.print("1.Male\n2.Female\n3.Other\nEnter customer gender: ");
            int choice = Integer.parseInt(sc.nextLine());
            boolean flagCheck = false;
            switch (choice) {
                case 1:
                    gender = "male";
                    flagCheck = true;
                    break;
                case 2:
                    gender = "female";
                    flagCheck = true;
                    break;
                case 3:
                    gender = "other";
                    flagCheck = true;
                    break;
                default:
                    gender = null;
                    System.out.println("Enter again.");
            }
            if (flagCheck) {
                break;
            }
        }
        while (true) {
            System.out.print("Enter customer id number(Id have 10 numbers): ");
            idNumber = sc.nextLine();
            try {
                CheckUtils.checkId(idNumber);
                break;
            } catch (FormatException | NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Enter again.");
            }
        }

        while (true) {
            System.out.print("Enter customer phone number(start with zero and have 10 numbers): ");
            phoneNumber = sc.nextLine();
            try {
                CheckUtils.checkPhoneNumber(phoneNumber);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("Enter customer email (example: abc@abc.com): ");
            email = sc.nextLine();
            try {
                CheckUtils.checkEmail(email);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("1.Diamond\n2.Platinum\n3.Gold\n4.Silver\n5.Member\nEnter customer type: ");
            int choice = Integer.parseInt(sc.nextLine());
            boolean flagCheck = false;
            switch (choice) {
                case 1:
                    guestType = "Diamond";
                    flagCheck = true;
                    break;
                case 2:
                    guestType = "Platinum";
                    flagCheck = true;
                    break;
                case 3:
                    guestType = "Gold";
                    flagCheck = true;
                    break;
                case 4:
                    guestType = "Silver";
                    flagCheck = true;
                    break;
                case 5:
                    guestType = "Member";
                    flagCheck = true;
                    break;
                default:
                    guestType = null;
                    System.out.println("Enter again.");
            }
            if (flagCheck) {
                break;
            }

        }

        while (true) {
            System.out.print("Enter customer full name: ");
            address = sc.nextLine();
            try {
                CheckUtils.checkAddress(address);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        return new Customer(code, fullName, dateOfBirth, gender, idNumber, phoneNumber, email, guestType, address);
    }

    private static Customer editInfo(String code) {
        String fullName;
        LocalDate dateOfBirth;
        String gender;
        String idNumber;
        String phoneNumber;
        String email;
        String guestType;
        String address;

        while (true) {
            System.out.print("Enter customer full name: ");
            fullName = sc.nextLine();
            try {
                CheckUtils.checkName(fullName);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            System.out.print("Enter customer birthday (dd-MM-yyyy): ");

            try {
                String date = sc.nextLine();
                CheckUtils.checkDate(date);
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                dateOfBirth = LocalDate.parse(date,fm);
                break;
            } catch (FormatException | NumberFormatException | DateTimeParseException e) {
                System.out.println("Format error!");
            }
        }

        while (true) {
            System.out.print("1.Male\n2.Female\n3.Other\nEnter customer gender: ");
            int choice = Integer.parseInt(sc.nextLine());
            boolean flagCheck = false;
            switch (choice) {
                case 1:
                    gender = "male";
                    flagCheck = true;
                    break;
                case 2:
                    gender = "female";
                    flagCheck = true;
                    break;
                case 3:
                    gender = "other";
                    flagCheck = true;
                    break;
                default:
                    gender = null;
                    System.out.println("Enter again.");
            }
            if (flagCheck) {
                break;
            }
        }
        while (true) {
            System.out.print("Enter customer id number(Id have 10 numbers): ");
            idNumber = sc.nextLine();
            try {
                CheckUtils.checkId(idNumber);
                break;
            } catch (FormatException | NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Enter again.");
            }
        }

        while (true) {
            System.out.print("Enter customer phone number(start with zero and have 10 numbers): ");
            phoneNumber = sc.nextLine();
            try {
                CheckUtils.checkPhoneNumber(phoneNumber);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("Enter customer email (example: abc@abc.com): ");
            email = sc.nextLine();
            try {
                CheckUtils.checkEmail(email);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("1.Diamond\n2.Platinum\n3.Gold\n4.Silver\n5.Member\nEnter customer type: ");
            int choice = Integer.parseInt(sc.nextLine());
            boolean flagCheck = false;
            switch (choice) {
                case 1:
                    guestType = "Diamond";
                    flagCheck = true;
                    break;
                case 2:
                    guestType = "Platinum";
                    flagCheck = true;
                    break;
                case 3:
                    guestType = "Gold";
                    flagCheck = true;
                    break;
                case 4:
                    guestType = "Silver";
                    flagCheck = true;
                    break;
                case 5:
                    guestType = "Member";
                    flagCheck = true;
                    break;
                default:
                    guestType = null;
                    System.out.println("Enter again.");
            }
            if (flagCheck) {
                break;
            }

        }

        while (true) {
            System.out.print("Enter customer full name: ");
            address = sc.nextLine();
            try {
                CheckUtils.checkAddress(address);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        return new Customer(code, fullName, dateOfBirth, gender, idNumber, phoneNumber, email, guestType, address);
    }

    private List<Customer> getInfoFromFile() {
        File file = new File("src\\case_study_furama_resort_module_2\\data\\customer_data.csv");

        if (!file.exists()) {
            System.out.println("File is not exist.");
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        List<Customer> customerList = new LinkedList<>();

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] info;
            Customer customer;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                customer = new Customer();
                customer.setCode(info[0]);
                customer.setFullName(info[1]);
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                customer.setDateOfBirth(LocalDate.parse(info[2],fm));
                customer.setGender(info[3]);
                customer.setIdNumber(info[4]);
                customer.setPhoneNumber(info[5]);
                customer.setEmail(info[6]);
                customer.setGuestType(info[7]);
                customer.setAddress(info[8]);
                customerList.add(customer);
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
        return customerList;
    }

    private void writeFile(List<Customer> customerList) {
        File file = new File("src\\case_study_furama_resort_module_2\\data\\customer_data.csv");

        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                bufferedWriter.write(getInfo(customer));
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

    private String getInfo(Customer customer) {
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                customer.getCode(), customer.getFullName(), customer.getDateOfBirth().format(fm), customer.getGender(), customer.getIdNumber(), customer.getPhoneNumber(), customer.getEmail(), customer.getGuestType(), customer.getAddress());
    }

    @Override
    public void display() {
        customerList = getInfoFromFile();
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void add() {
        customerList = getInfoFromFile();
        Customer customer = inputInfo();
        customerList.add(customer);
        writeFile(customerList);
    }

    @Override
    public void edit() {
        customerList = getInfoFromFile();
        System.out.print("Enter code of employee that you want to edit:");
        String code = sc.nextLine();
        boolean flagCheck = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCode().equals(code)) {
                Customer customer = editInfo(customerList.get(i).getCode());
                customerList.set(i, customer);
                flagCheck = true;
                break;
            }
        }
        if (!flagCheck) {
            System.out.println("Employee is not exist");
        }
        writeFile(customerList);
    }
}
