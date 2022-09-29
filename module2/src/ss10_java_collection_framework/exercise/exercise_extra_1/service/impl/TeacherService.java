package ss10_java_collection_framework.exercise.exercise_extra_1.service.impl;

import ss10_java_collection_framework.exercise.exercise_extra_1.model.Student;
import ss10_java_collection_framework.exercise.exercise_extra_1.model.Teacher;
import ss10_java_collection_framework.exercise.exercise_extra_1.service.ITeacherService;
import ss10_java_collection_framework.exercise.exercise_extra_1.util.Check;
import ss10_java_collection_framework.exercise.exercise_extra_1.util.IncorrectFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Teacher> teachersList = new ArrayList<>();


    public Teacher enterInfoTeacher() {
        System.out.print("Enter code of teacher: ");
        String code = scanner.nextLine();
        String name;
        while (true){
            try{
                System.out.print("Enter name of teacher: ");
                name = scanner.nextLine();
                Check.checkName(name);
                break;
            }catch (IncorrectFormatException e){
                System.out.println("Enter again!");
            }
        }
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
        String speciality;
        while (true){
            try{
                System.out.print("Enter speciality: ");
                speciality = scanner.nextLine();
                Check.checkName(speciality);
                break;
            }catch (IncorrectFormatException e){
                System.out.println("Enter again!");
            }
        }

        return new Teacher(code, name, gender, speciality);
    }

    @Override
    public void add() throws IOException {
        teachersList = readFile();
        Teacher teacher = this.enterInfoTeacher();
        teachersList.add(teacher);
        System.out.println("Successfully add new.");
    }

    @Override
    public void remove() throws IOException {
        teachersList = readFile();
        System.out.print("Enter the code of teacher that you want to remove: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < teachersList.size(); i++) {
            if (teachersList.get(i).getCode().equals(code)){
                System.out.println("Are you certain to remove this student? Enter y: yes, n: no: ");
                String choice = scanner.nextLine();
                if (choice.equals("y")){
                    teachersList.remove(i);
                    System.out.println("Successfully remove.");
                }
                flagDelete = true;
                break;
            }
        }
        if(!flagDelete){
            System.out.println("The teacher you want to remove does not exist.");
        }
        writeFile(teachersList);
    }

    @Override
    public void showList() throws IOException {
        teachersList = readFile();
        for(Teacher teacher : teachersList){
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
        teachersList.add(teacher1);
        teachersList.add(teacher2);
        teachersList.add(teacher3);
        teachersList.add(teacher4);
        teachersList.add(teacher5);
        teachersList.add(teacher6);
        teachersList.add(teacher7);
        teachersList.add(teacher8);
    }

    @Override
    public int find() throws IOException {
        teachersList = readFile();
        System.out.println("Do you want to find student follow exact code or approximate name.");
        System.out.println("1 exact code / 2 approximate name");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.print("Enter the code of student:");
                String code = scanner.nextLine();
                for (int i = 0; i < teachersList.size(); i++) {

                    if (code.equals(teachersList.get(i).getCode())) {
                        System.out.println(teachersList.get(i).toString());
                        return i;
                    }
                }
                break;
            case 2:
                System.out.print("Enter the approximate name of student:");
                String name = scanner.nextLine();
                for (int i = 0; i < teachersList.size(); i++) {

                    if (teachersList.get(i).getName().contains(name)) {
                        System.out.println(teachersList.get(i).toString());
                        return i;
                    }
                }


                break;
        }
        return -1;
    }

    @Override
    public void sort() throws IOException {
        teachersList = readFile();
        for (int i = 0; i < teachersList.size(); i++) {

            for (int j = 0; j < teachersList.size() - i - 1; j++) {

                Teacher teacher1 = teachersList.get(j);
                Teacher teacher2 = teachersList.get(j + 1);

                int compare = teacher1.compareTo(teacher2);

                if (compare > 0) {
                    Teacher temp = teachersList.get(j);
                    teachersList.set(j, teachersList.get(j + 1));
                    teachersList.set(j + 1, temp);
                }
            }
        }
        writeFile(teachersList);
    }
    public ArrayList<Teacher> readFile() throws IOException {
        File file = new File("src\\ss10_java_collection_framework\\exercise\\exercise_extra_1\\data\\teachers_list.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        ArrayList<Teacher> teachersList = new ArrayList<>();
        String line;
        String[] teacherInfo;


        while((line = bufferedReader.readLine()) != null){
            teacherInfo = line.split(",");
            Teacher teacher = new Teacher();
            teacher.setCode(teacherInfo[0]);
            teacher.setName(teacherInfo[1]);
            teacher.setGender(teacherInfo[2]);
            teacher.setSpeciality(teacherInfo[3]);
            teachersList.add(teacher);

        }
        bufferedReader.close();
        return teachersList;

    }
    public void writeFile(ArrayList<Teacher> teachersList) throws IOException {
        File file = new File("src\\ss10_java_collection_framework\\exercise\\exercise_extra_1\\data\\teachers_list.csv");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Teacher teacher : teachersList) {
            bufferedWriter.write(teacher.info());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

    }
}
