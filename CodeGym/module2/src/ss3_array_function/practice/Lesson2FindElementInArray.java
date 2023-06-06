package ss3_array_function.practice;

import java.util.Scanner;

public class Lesson2FindElementInArray {
    public static void main(String[] args) {
        String[] studentList = {"Phuong", "Bao", "Cong", "Quang", "Huy", "Trung"};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the name you want to find in the student list: ");
            String nameToFind = scanner.nextLine();
            boolean check = false;
            for (int i = 0; i < studentList.length; i++) {
                if (studentList[i].equals(nameToFind)) {
                    check = true;
                    System.out.printf("Position of the %s in student list is %d\n", nameToFind, i + 1);
                    break;
                }
            }
            if (!check) {
                System.out.printf("Not find %s in the student list.", nameToFind);
                break;
            }
        }
    }
}
