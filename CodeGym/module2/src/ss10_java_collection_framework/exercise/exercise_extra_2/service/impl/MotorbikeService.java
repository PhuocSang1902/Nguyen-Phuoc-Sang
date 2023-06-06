package ss10_java_collection_framework.exercise.exercise_extra_2.service.impl;

import ss10_java_collection_framework.exercise.exercise_extra_2.model.Motorbike;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.IMotorbikeService;

import java.util.ArrayList;
import java.util.Scanner;

public class MotorbikeService implements IMotorbikeService {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Motorbike> motorsList = new ArrayList<>();

    public Motorbike motorbikeInfo() {
        System.out.println("Enter the license plates:");
        String licensePlates = scanner.nextLine();
        System.out.println("Enter the producer:");
        String producer = scanner.nextLine();
        System.out.println("Enter year of produce:");
        int yearOfProduce = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name of owner:");
        String owner = scanner.nextLine();
        System.out.println("Enter wattage :");
        int wattage = Integer.parseInt(scanner.nextLine());
        return new Motorbike(licensePlates, producer, yearOfProduce, owner, wattage);
    }

    @Override
    public void add() {
        Motorbike motorbike = this.motorbikeInfo();
        motorsList.add(motorbike);
        System.out.println("Add new transport successfully.");
        System.out.println();
    }

    @Override
    public void show() {
        for (Motorbike motorbike : motorsList) {
            System.out.println(((Motorbike) motorbike).toString());
        }
    }

    @Override
    public void remove() {
        System.out.print("Enter the license plate of truck you want to remove:");
        String licensePlate = scanner.nextLine();
        boolean flagRemove = false;

        for (int i = 0; i < motorsList.size(); i++) {

            if (licensePlate.equals(motorsList.get(i).getLicensePlates())) {
                System.out.print("Are you confirm? yes:y, no:n.");
                String choice = scanner.nextLine();

                if (choice.equals("y")) {
                    motorsList.remove(i);
                    System.out.println("Remove successfully");
                    System.out.println();
                    flagRemove = true;
                    break;
                }
            }
        }
        if (!flagRemove) {
            System.out.println("Can not find the license plate.");
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public int find() {
        System.out.print("Enter the license plate:");
        String licensePlate = scanner.nextLine();
        for (int i = 0; i < motorsList.size(); i++) {

            if (licensePlate.equals(motorsList.get(i).getLicensePlates())) {
                System.out.println(motorsList.get(i).toString());
                return i;
            }
        }
        System.out.println("There is not transport in the transports list.");
        System.out.println();
        return -1;
    }
}

