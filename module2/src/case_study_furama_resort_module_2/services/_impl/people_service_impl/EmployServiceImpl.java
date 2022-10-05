package case_study_furama_resort_module_2.services._impl.people_service_impl;

import case_study_furama_resort_module_2.models.person.Employee;
import case_study_furama_resort_module_2.services.people_service.EmployeeService;
import case_study_furama_resort_module_2.utils.CheckUtils;
import case_study_furama_resort_module_2.utils.FormatException;

import java.io.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployServiceImpl implements EmployeeService {

    private static List<Employee> employeeList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    private Employee inputInfo() {
        String code;
        String fullName;
        LocalDate dateOfBirth;
        String gender;
        String idNumber;
        String phoneNumber;
        String email;
        String qualification;
        String position;
        double salary;

        while (true) {
            String rangeID = "0123456789";
            SecureRandom random = new SecureRandom();

            StringBuilder tempCode = new StringBuilder("EP");
            for (int i = 0; i < 4; i++) {
                tempCode.append(rangeID.charAt(random.nextInt(rangeID.length())));
            }
            code = tempCode.toString();
            boolean flagCheck = true;
            for (Employee employee : employeeList) {
                if (employee.getCode().equals(code)) {
                    flagCheck = false;
                    break;
                }
            }
            if (flagCheck) {
                break;
            }
        }
        System.out.println("Employee code is: " + code);

        while (true) {
            System.out.print("Enter employee full name: ");
            fullName = sc.nextLine();
            try {
                CheckUtils.checkName(fullName);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            System.out.print("Enter employee birthday (dd-MM-yyyy): ");

            try {
                String date = sc.nextLine();
                CheckUtils.checkDate(date);
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                dateOfBirth = LocalDate.parse(date, fm);
                CheckUtils.checkDateOfBirth(dateOfBirth);
                break;
            } catch (FormatException | NumberFormatException | DateTimeParseException e) {
                e.getStackTrace();
                System.out.println("Format error!Try again!");
            }
        }

        while (true) {
            System.out.print("1.Male\n2.Female\n3.Other\nEnter employee gender: ");
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
            System.out.print("Enter employee id number(Id have 10 numbers): ");
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
            System.out.print("Enter employee phone number(start with zero and have 10 numbers): ");
            phoneNumber = sc.nextLine();
            try {
                CheckUtils.checkPhoneNumber(phoneNumber);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("Enter employee email (example: abc@abc.com): ");
            email = sc.nextLine();
            try {
                CheckUtils.checkEmail(email);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("1.Intermediate\n2.College\n3.University\n4.Graduate\nEnter employee qualification: ");
            int choice = Integer.parseInt(sc.nextLine());
            boolean flagCheck = false;
            switch (choice) {
                case 1:
                    qualification = "Intermediate";
                    flagCheck = true;
                    break;
                case 2:
                    qualification = "College";
                    flagCheck = true;
                    break;
                case 3:
                    qualification = "University";
                    flagCheck = true;
                    break;
                case 4:
                    qualification = "Graduate";
                    flagCheck = true;
                    break;
                default:
                    qualification = null;
                    System.out.println("Enter again.");
            }
            if (flagCheck) {
                break;
            }

        }

        while (true) {
            System.out.print("1.Receptionist\n2.Service\n3.Specialist\n4.Supervisor\n5.Manager\n6.Director\nEnter employee position: ");
            int choice = Integer.parseInt(sc.nextLine());
            boolean flagCheck = false;
            switch (choice) {
                case 1:
                    position = "Receptionist";
                    flagCheck = true;
                    break;
                case 2:
                    position = "Service";
                    flagCheck = true;
                    break;
                case 3:
                    position = "Specialist";
                    flagCheck = true;
                    break;
                case 4:
                    position = "Supervisor";
                    flagCheck = true;
                    break;
                case 5:
                    position = "Manager";
                    flagCheck = true;
                    break;
                case 6:
                    position = "Director";
                    flagCheck = true;
                    break;
                default:
                    position = null;
                    System.out.println("Enter again.");
            }
            if (flagCheck) {
                break;
            }

        }

        while (true) {
            System.out.print("Enter employee salary: ");
            salary = Double.parseDouble(sc.nextLine());
            try {
                CheckUtils.checkSalary(salary);
                break;
            } catch (FormatException e) {
                System.out.println("Wrong format.Enter again!");
            } catch (NumberFormatException e){
                System.out.println("Wrong format.Enter again!");
            }
        }

        return new Employee(code, fullName, dateOfBirth, gender, idNumber, phoneNumber, email, qualification, position, salary);
    }

    private Employee editInfo(String code) {
        String fullName;
        LocalDate dateOfBirth;
        String gender;
        String idNumber;
        String phoneNumber;
        String email;
        String qualification;
        String position;
        double salary;

        while (true) {
            System.out.print("Enter employee full name: ");
            fullName = sc.nextLine();
            try {
                CheckUtils.checkName(fullName);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            System.out.print("Enter employee birthday (dd-MM-yyyy): ");

            try {
                String date = sc.nextLine();
                CheckUtils.checkDate(date);
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                dateOfBirth = LocalDate.parse(date, fm);
                break;
            } catch (FormatException | NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Format error!");
            }
        }

        while (true) {
            System.out.print("1.Male\n2.Female\n3.Other\nEnter employee gender: ");
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
            System.out.print("Enter employee id number(Id have 9 numbers): ");
            idNumber = sc.nextLine();
            try {
                CheckUtils.checkId(idNumber);
                break;
            } catch (FormatException | NumberFormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("Enter employee phone number(start with zero and have 10 numbers): ");
            phoneNumber = sc.nextLine();
            try {
                CheckUtils.checkPhoneNumber(phoneNumber);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("Enter employee email (example: abc@abc.com): ");
            email = sc.nextLine();
            try {
                CheckUtils.checkEmail(email);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        while (true) {
            System.out.print("1.Intermediate\n2.College\n3.University\n4.Graduate\nEnter employee qualification: ");
            int choice = Integer.parseInt(sc.nextLine());
            boolean flagCheck = false;
            switch (choice) {
                case 1:
                    qualification = "Intermediate";
                    flagCheck = true;
                    break;
                case 2:
                    qualification = "College";
                    flagCheck = true;
                    break;
                case 3:
                    qualification = "University";
                    flagCheck = true;
                    break;
                case 4:
                    qualification = "Graduate";
                    flagCheck = true;
                    break;
                default:
                    qualification = null;
                    System.out.println("Enter again.");
            }
            if (flagCheck) {
                break;
            }

        }

        while (true) {
            System.out.print("1.Receptionist\n2.Service\n3.Specialist\n4.Supervisor\n5.Manager\n6.Director\nEnter employee position: ");
            int choice = Integer.parseInt(sc.nextLine());
            boolean flagCheck = false;
            switch (choice) {
                case 1:
                    position = "Intermediate";
                    flagCheck = true;
                    break;
                case 2:
                    position = "College";
                    flagCheck = true;
                    break;
                case 3:
                    position = "University";
                    flagCheck = true;
                    break;
                case 4:
                    position = "Graduate";
                    flagCheck = true;
                    break;
                default:
                    position = null;
                    System.out.println("Enter again.");
            }
            if (flagCheck) {
                break;
            }

        }

        while (true) {
            System.out.print("Enter employee salary: ");
            salary = Double.parseDouble(sc.nextLine());
            try {
                CheckUtils.checkSalary(salary);
                break;
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        return new Employee(code, fullName, dateOfBirth, gender, idNumber, phoneNumber, email, qualification, position, salary);
    }

    private List<Employee> getDataFromFile() {
        File file = new File("src\\case_study_furama_resort_module_2\\data\\employee_data.csv");

        if (!file.exists()) {
            System.out.println("File is not exist.");
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        List<Employee> employeeList = new ArrayList<>();

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] info;
            Employee employee;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                employee = new Employee();
                employee.setCode(info[0]);
                employee.setFullName(info[1]);
                DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                employee.setDateOfBirth(LocalDate.parse(info[2], fm));
                employee.setGender(info[3]);
                employee.setIdNumber(info[4]);
                employee.setPhoneNumber(info[5]);
                employee.setEmail(info[6]);
                employee.setQualification(info[7]);
                employee.setPosition(info[8]);
                employee.setSalary(Double.parseDouble(info[9]));
                employeeList.add(employee);
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
        return employeeList;
    }

    private void writeFile(List<Employee> employeeList) {
        File file = new File("src\\case_study_furama_resort_module_2\\data\\employee_data.csv");

        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employeeList) {
                bufferedWriter.write(getInfo(employee));
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

    private String getInfo(Employee employee) {
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                employee.getCode(), employee.getFullName(), employee.getDateOfBirth().format(fm), employee.getGender(), employee.getIdNumber(), employee.getPhoneNumber(), employee.getEmail(), employee.getQualification(), employee.getPosition(), employee.getSalary());
    }

    @Override
    public void display() {
        employeeList = getDataFromFile();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }

    }

    @Override
    public void add() {
        employeeList = getDataFromFile();
        Employee employee = inputInfo();
        employeeList.add(employee);
        writeFile(employeeList);

    }

    @Override
    public void edit() {
        employeeList = getDataFromFile();
        System.out.print("Enter code of employee that you want to edit:");
        String code = sc.nextLine();
        boolean flagCheck = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCode().equals(code)) {
                Employee employee = editInfo(employeeList.get(i).getCode());
                employeeList.set(i, employee);
                flagCheck = true;
                break;
            }
        }
        if (!flagCheck) {
            System.out.println("Employee is not exist");
        }
        writeFile(employeeList);
    }
}
