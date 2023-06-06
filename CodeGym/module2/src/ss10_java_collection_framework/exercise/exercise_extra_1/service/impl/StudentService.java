package ss10_java_collection_framework.exercise.exercise_extra_1.service.impl;

import ss10_java_collection_framework.exercise.exercise_extra_1.model.Student;
import ss10_java_collection_framework.exercise.exercise_extra_1.service.IStudentService;
import ss10_java_collection_framework.exercise.exercise_extra_1.utils.Check;
import ss10_java_collection_framework.exercise.exercise_extra_1.utils.FormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService implements IStudentService {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Student> studentsList = new ArrayList<>();

    public Student enterInfoStudent() {
        System.out.print("Enter code of student:(Code start with A word and 4 number) ");
        String code;
        while(true){
            try{
                code = scanner.nextLine();
                Check.checkCode(code);
                boolean flagCheck = false;
                for(Student student : studentsList){
                    if (student.getCode().equals(code)){
                        flagCheck = true;
                        break;
                    }
                }
                if (flagCheck){
                    System.out.println("Code is duplicate. Enter again:");
                }else {
                    break;
                }
            }catch(FormatException e){
                e.getStackTrace();
                System.out.println("Enter again.");
            }

        }
        String name;
        while (true) {
            try {
                System.out.print("Enter name of student: ");
                name = scanner.nextLine();
                Check.checkName(name);
                break;
            } catch (FormatException e) {
                e.getStackTrace();
                System.out.println("Enter again!");
            }
        }
        System.out.print("Enter gender of student(male/female/other):");
        Boolean gender;
        while (true) {
            try{
                String tempGender = scanner.nextLine();
                Check.checkGender(tempGender);
                switch (tempGender){
                    case "male":
                        gender = true;
                        break;
                    case "female":
                        gender = false;
                        break;
                    default:
                        gender = null;
                }
                break;
            }catch (FormatException e){
                e.getStackTrace();
                System.out.println("Gender is male, female or other.Enter again");
            }
        }
        String nameClass;
        System.out.print("Enter class of student:(Name class start with A or B or C and have 2 number)");
        while (true){
            try {
                nameClass = scanner.nextLine();
                Check.checkClassName(nameClass);
                break;
            }catch (FormatException e){
                e.getStackTrace();
                System.out.print("Enter again:");
            }
        }
        double point;
        while (true) {
            try {
                System.out.print("Enter point of student: ");
                point = Double.parseDouble(scanner.nextLine());
                Check.checkPoint(point);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Enter again!");
            } catch (FormatException e) {
                System.out.print("Point is greater than 0 or less than 10!");
            }
        }

        return new Student(code, name, gender, nameClass, point);
    }

    @Override
    public void add() {
        studentsList = readFile();
        Student student = this.enterInfoStudent();
        studentsList.add(student);
        writeFile(studentsList);
        System.out.println("Successfully add new.");
    }

    @Override
    public void remove() {
        studentsList = readFile();
        System.out.print("Enter the code of student that you want to remove: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getCode().equals(code)) {
                System.out.print("Are you certain to remove this student? Enter y: yes, n: no: ");
                String choice = scanner.nextLine();
                if (choice.equals("y")) {
                    studentsList.remove(i);
                    System.out.println("Successfully remove.");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("The student you want to remove does not exist");
        }
        writeFile(studentsList);
    }

    @Override
    public void showList() {
        studentsList = readFile();
        for (Student student : studentsList) {
            System.out.println(student.toString());
        }
    }


    @Override
    public int find() {
        studentsList = readFile();
        System.out.println("Do you want to find student follow exact code or approximate name.");
        System.out.println("1 exact code / 2 approximate name");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.print("Enter the code of student:");
                String code = scanner.nextLine();
                for (int i = 0; i < studentsList.size(); i++) {

                    if (code.equals(studentsList.get(i).getCode())) {
                        System.out.println(studentsList.get(i).toString());
                        return i;
                    }
                }
                break;
            case 2:
                System.out.print("Enter the approximate name of student:");
                String name = scanner.nextLine();
                for (int i = 0; i < studentsList.size(); i++) {

                    if (studentsList.get(i).getName().contains(name)) {
                        System.out.println(studentsList.get(i).toString());
                        return i;
                    }
                }


                break;
        }
        return -1;
    }

    @Override
    public void sort() {
        studentsList = readFile();
        System.out.println("Do you want to sort follow name or code?");
        System.out.println("1.Follow name");
        System.out.println("2.Id");
        System.out.println("3.Return");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                for (int i = 0; i < studentsList.size(); i++) {
                    for (int j = 0; j < studentsList.size() - i - 1; j++) {

                        Student student1 = studentsList.get(j);
                        Student student2 = studentsList.get(j + 1);

                        int compare = student1.compareTo(student2);

                        if (compare > 0) {
                            Student temp = studentsList.get(j);
                            studentsList.set(j, studentsList.get(j + 1));
                            studentsList.set(j + 1, temp);
                        }
                    }
                }
                break;
            case 2:
                studentsList.sort((o1, o2) -> o1.getCode().compareTo(o2.getCode()));

                break;
            case 3:
                return;
        }

        writeFile(studentsList);
    }

    public ArrayList<Student> readFile() {
        ArrayList<Student> studentList = new ArrayList<>();

        File file = new File("src\\ss10_java_collection_framework\\exercise\\exercise_extra_1\\data\\students_list.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] studentInfo;


            while ((line = bufferedReader.readLine()) != null) {
                studentInfo = line.split(",");
                Student student = new Student();
                student.setCode(studentInfo[0]);
                student.setName(studentInfo[1]);
                student.setGender(studentInfo[2]);
                student.setNameClass(studentInfo[3]);
                student.setPoint(Double.parseDouble(studentInfo[4]));
                studentList.add(student);

            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File is not exist or data is corrupted.");
        }
        return studentList;
    }

    public void writeFile(ArrayList<Student> studentsList) {
        File file = new File("src\\ss10_java_collection_framework\\exercise\\exercise_extra_1\\data\\students_list.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Student student : studentsList) {
                bufferedWriter.write(student.info());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("File is not exist or data is corrupted.");
        }

    }
}
