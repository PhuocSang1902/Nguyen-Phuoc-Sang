package ss10_java_collection_framework.exercise.exercise_extra_1.service.impl;

import ss10_java_collection_framework.exercise.exercise_extra_1.model.Student;
import ss10_java_collection_framework.exercise.exercise_extra_1.service.IStudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService implements IStudentService {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Student> studentsList = new ArrayList<>();

    public Student enterInfoStudent() {
        System.out.print("Enter code of student: ");
        String code = scanner.nextLine();
        System.out.print("Enter name of student: ");
        String name = scanner.nextLine();
        System.out.print("Enter gender of student: ");
        Boolean gender;
        while (true){
            String tempGender = scanner.nextLine();
            if (tempGender.equals("male")){
                gender = true;
                break;
            }
            if (tempGender.equals("female")){
                gender = false;
                break;
            }
            if (tempGender.equals("other")){
                gender = null;
                break;
            }
            System.out.println("Gender is male, female or other ");
        }
        System.out.print("Enter class of student:");
        String nameClass = scanner.nextLine();
        System.out.println("Enter point of student: ");
        double point = Double.parseDouble(scanner.nextLine());

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
            if (studentsList.get(i).getCode().equals(code)){
                System.out.print("Are you certain to remove this student? Enter y: yes, n: no: ");
                String choice = scanner.nextLine();
                if (choice.equals("y")){
                    studentsList.remove(i);
                    System.out.println("Successfully remove.");
                }
                flagDelete = true;
                break;
            }
        }
        if(!flagDelete){
            System.out.println("The student you want to remove does not exist");
        }

    }

    @Override
    public void showList() {
        for(Student student : studentsList){
            System.out.println(student.toString());
        }
    }

    @Override
    public void creatTemp() {
        Student student1 = new Student("a01", "Hoang", true, "9a", 5);
        Student student2 = new Student("a02", "Thang", true, "9a", 2);
        Student student3 = new Student("a03", "Hoa", false, "9a", 6.5);
        Student student4 = new Student("a04", "Thao", false, "9a", 8);
        Student student5 = new Student("a05", "Hung", true, "9a", 10);
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);
        studentsList.add(student5);
    }
}
