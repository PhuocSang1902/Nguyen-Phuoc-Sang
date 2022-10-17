package service.impl;

import model.Student;
import service.StudentService;
import util.CheckFormat;
import util.FormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    private static Scanner sc = new Scanner(System.in);
    private static List<Student> studentsList = new ArrayList<>();
    private static String path = "src\\data\\students.csv";

    private Student inputInfo() {

        System.out.print("Enter code of student:(Code start with A word and 4 number) ");
        String code;
        while (true) {

            code = sc.nextLine();
            try {
                CheckFormat.checkStudentCode(code);
                boolean flagCheck = false;
                if (!studentsList.isEmpty()) {
                    for (Student student : studentsList) {
                        if (student.getCode().equals(code)) {
                            flagCheck = true;
                            break;
                        }
                    }
                }
                if (flagCheck) {
                    System.out.println("Code is duplicate. Enter again:");
                } else {
                    break;
                }
            } catch (FormatException e) {
                e.printStackTrace();
            }
        }

        String name;
        while (true) {

            System.out.print("Enter name of student: ");
            name = sc.nextLine();
            try {
                CheckFormat.checkName(name);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }

        }

        String birthday;
        while (true) {
            System.out.print("Enter student birthday (dd-MM-yyyy): ");
            birthday = sc.nextLine();
            try {
                CheckFormat.checkDate(birthday);
                CheckFormat.checkDateOfBirth(birthday);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());

            }


        }

        String gender;
        while (true) {
            boolean flagCheck = false;
            System.out.println("1.male\n2.female\n3.other\nEnter your choice follow number: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    gender = "male";
                    flagCheck = true;
                    break;
                case "2":
                    gender = "female";
                    flagCheck = true;
                    break;
                case "3":
                    gender = "other";
                    flagCheck = true;
                    break;
                default:
                    gender = null;
                    System.out.println("Wrong choice. Enter again!");
            }
            if (flagCheck) {
                break;
            }

        }

        String className;

        System.out.print("Enter class name of student: ");
        className = sc.nextLine();


        double point;
        while (true) {

            System.out.print("Enter point of student: ");
            try {
                point = Double.parseDouble(sc.nextLine());
                CheckFormat.checkPoint(point);
                break;
            } catch (FormatException | NumberFormatException e) {
                System.out.println(e.getMessage());
                ;
            }

        }

        return new Student(code, name, birthday, gender, className, point);
    }

    private List<Student> readFile() {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File is not exist.");
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        List<Student> studentsList = new ArrayList<>();

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] info;
            Student student;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                student = new Student();
                student.setCode(info[0]);
                student.setName(info[1]);
                student.setBirthday(info[2]);
                student.setGender(info[3]);
                student.setClassName(info[4]);
                student.setPoint(Double.parseDouble(info[5]));

                studentsList.add(student);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    private void writeFile(List<Student> studentsList) {
        File file = new File(path);

        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : studentsList) {
                bufferedWriter.write(student.getInfo());
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
    public void add() {
        studentsList = readFile();
        Student student = inputInfo();
        studentsList.add(student);
        System.out.println("Add new successful!");
        writeFile(studentsList);
    }

    @Override
    public void remove() {
        studentsList = readFile();

        System.out.println("Enter code of student to remove: ");
        String code = sc.nextLine();
        boolean flagCheck = false;

        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getCode().equals(code)) {
                flagCheck = true;
                System.out.println("Are you sure to remove this student?\n1.Yes\n2.No");
                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        studentsList.remove(studentsList.get(i));
                        writeFile(studentsList);
                        break;
                    case "2":
                        return;
                    default:
                        System.out.println("Wrong choice");
                }
            }
        }
        if (!flagCheck) {

            System.out.println("Wrong code");

        }

    }

    @Override
    public void display() {
        studentsList = readFile();
        for (Student student : studentsList) {
            System.out.println(student.toString());
        }
    }
}
