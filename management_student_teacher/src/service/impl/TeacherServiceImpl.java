package service.impl;

import model.Teacher;
import service.TeacherService;
import util.CheckFormat;
import util.FormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherServiceImpl implements TeacherService {
    private static Scanner sc = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();
    private static String path = "src\\data\\teachers.csv";

    private Teacher inputInfo() {

        System.out.print("Enter code of teacher:(Code start with B word and 4 number) ");
        String code;
        while (true) {

            code = sc.nextLine();
            try {
                CheckFormat.checkTeacherCode(code);
                boolean flagCheck = false;
                if (!teacherList.isEmpty()) {
                    for (Teacher teacher : teacherList) {
                        if (teacher.getCode().equals(code)) {
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

            System.out.print("Enter name of teacher: ");
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
            System.out.print("Enter teacher birthday (dd-MM-yyyy): ");
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

        String speciality;

        System.out.print("Enter class speciality of teacher: ");
        speciality = sc.nextLine();


        return new Teacher(code, name, birthday, gender, speciality);
    }

    private List<Teacher> readFile() {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File is not exist.");
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        List<Teacher> teacherList = new ArrayList<>();

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] info;
            Teacher teacher;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                teacher = new Teacher();
                teacher.setCode(info[0]);
                teacher.setName(info[1]);
                teacher.setBirthday(info[2]);
                teacher.setGender(info[3]);
                teacher.setSpeciality(info[4]);

                teacherList.add(teacher);
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
        return teacherList;
    }

    private void writeFile(List<Teacher> teacherList) {
        File file = new File(path);

        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Teacher teacher : teacherList) {
                bufferedWriter.write(teacher.getInfo());
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

        teacherList = readFile();
        Teacher teacher = inputInfo();
        teacherList.add(teacher);
        System.out.println("Add new successful");
        writeFile(teacherList);

    }

    @Override
    public void remove() {
        teacherList = readFile();

        System.out.println("Enter code of teacher to remove: ");
        String code = sc.nextLine();
        boolean flagCheck = false;

        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getCode().equals(code)) {
                flagCheck = true;
                System.out.println("Are you sure to remove this teacher?\n1.Yes\n2.No");
                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        teacherList.remove(teacherList.get(i));
                        writeFile(teacherList);
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
        teacherList = readFile();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher.toString());
        }
    }
}
