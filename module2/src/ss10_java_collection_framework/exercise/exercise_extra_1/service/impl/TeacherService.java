package ss10_java_collection_framework.exercise.exercise_extra_1.service.impl;

import ss10_java_collection_framework.exercise.exercise_extra_1.model.Teacher;
import ss10_java_collection_framework.exercise.exercise_extra_1.service.ITeacherService;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Teacher> TeachersList = new ArrayList<>();

    public Teacher enterInfoTeacher() {
        System.out.print("Enter code of teacher: ");
        String code = scanner.nextLine();
        System.out.print("Enter name of teacher: ");
        String name = scanner.nextLine();
        System.out.print("Enter gender of teacher: ");
        String tempGender;
        Boolean gender;
        while (true) {
            tempGender = scanner.nextLine();
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
        System.out.print("Enter speciality: ");
        String speciality = scanner.nextLine();
        return new Teacher(code, name, gender, speciality);
    }

    @Override
    public void add() {
        Teacher teacher = this.enterInfoTeacher();
        TeachersList.add(teacher);
        System.out.println("Successfully add new.");
    }

    @Override
    public void remove() {
        System.out.print("Enter the code of teacher that you want to remove: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < TeachersList.size(); i++) {
            if (TeachersList.get(i).getCode().equals(code)){
                System.out.println("Are you certain to remove this student? Enter y: yes, n: no: ");
                String choice = scanner.nextLine();
                if (choice.equals("y")){
                    TeachersList.remove(i);
                    System.out.println("Successfully remove.");
                }
                flagDelete = true;
                break;
            }
        }
        if(!flagDelete){
            System.out.println("The teacher you want to remove does not exist.");
        }
    }

    @Override
    public void showList() {
        for(Teacher teacher : TeachersList){
            System.out.println(teacher.toString());
        }
    }

    @Override
    public void creatTemp() {
        Teacher teacher1 = new Teacher("a01", "Hoang", true, "Math");
        Teacher teacher2 = new Teacher("a02", "Thang", true, "Physics");
        Teacher teacher3 = new Teacher("a03", "Hoa", false, "Fine Art");
        Teacher teacher4 = new Teacher("a04", "Thao", false, "Chemistry");
        Teacher teacher5 = new Teacher("a05", "Hung", true, "History");
        Teacher teacher6 = new Teacher("a06", "Tuan", true, "Literature");
        Teacher teacher7 = new Teacher("a07", "Huong", false, "Biology");
        Teacher teacher8 = new Teacher("a08", "Thy", false, "Physical Education");
        TeachersList.add(teacher1);
        TeachersList.add(teacher2);
        TeachersList.add(teacher3);
        TeachersList.add(teacher4);
        TeachersList.add(teacher5);
        TeachersList.add(teacher6);
        TeachersList.add(teacher7);
        TeachersList.add(teacher8);
    }
}
