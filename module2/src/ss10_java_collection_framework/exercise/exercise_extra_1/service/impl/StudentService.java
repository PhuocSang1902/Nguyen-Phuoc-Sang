package ss10_java_collection_framework.exercise.exercise_extra_1.service.impl;

import ss10_java_collection_framework.exercise.exercise_extra_1.model.Student;
import ss10_java_collection_framework.exercise.exercise_extra_1.service.IStudentService;
import ss10_java_collection_framework.exercise.exercise_extra_1.util.Check;
import ss10_java_collection_framework.exercise.exercise_extra_1.util.IncorrectFormatException;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService implements IStudentService {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Student> studentsList = new ArrayList<>();

    public Student enterInfoStudent() {
        System.out.print("Enter code of student: ");
        String code = scanner.nextLine();
        String name;
        while (true){
            try{
                System.out.print("Enter name of student: ");
                name = scanner.nextLine();
                Check.checkName(name);
                break;
            }catch (IncorrectFormatException e){
                System.out.println("Enter again!");
            }
        }
        System.out.print("Enter gender of student: ");
        Boolean gender;
        while (true) {
            String tempGender = scanner.nextLine();
            if (tempGender.equals("male")) {
                gender = true;
                break;
            }
            if (tempGender.equals("female")) {
                gender = false;
                break;
            }
            if (tempGender.equals("other")) {
                gender = null;
                break;
            }
            System.out.println("Gender is male, female or other ");
        }
        System.out.print("Enter class of student:");
        String nameClass = scanner.nextLine();
        double point;
        while (true){
           try{
               System.out.println("Enter point of student: ");
               point = Double.parseDouble(scanner.nextLine());
               Check.checkPoint(point);
               break;
           }catch (NumberFormatException e){
               System.out.println("Enter again!");
           }catch (IncorrectFormatException e){
               System.out.println("Point is greater than 0 or less than 10!");
           }
        }

        return new Student(code, name, gender, nameClass, point);
    }

    @Override
    public void add() {
        Student student = this.enterInfoStudent();
        studentsList.add(student);
        System.out.println("Successfully add new.");
    }

    @Override
    public void remove() {
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

    }

    @Override
    public void showList() {
        for (Student student : studentsList) {
            System.out.println(student.toString());
        }
    }

    @Override
    public void creatTemp() {
        Student student1 = new Student("01", "Hoa", true, "9a", 5);
        Student student2 = new Student("02", "Thang", true, "9a", 2);
        Student student3 = new Student("03", "Hoa", false, "9a", 6.5);
        Student student4 = new Student("04", "Bao", false, "9a", 8);
        Student student5 = new Student("05", "Anh", true, "9a", 10);
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);
    }

    @Override
    public int find() {
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
    }

}
