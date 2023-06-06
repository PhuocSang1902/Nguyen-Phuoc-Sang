package ss10_java_collection_framework.exercise.exercise_extra_2.service.impl;

import ss10_java_collection_framework.exercise.exercise_extra_2.model.Truck;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.ITruckService;

import java.util.ArrayList;
import java.util.Scanner;

public class TruckService implements ITruckService {
    public static ArrayList<Truck> trucksList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public Truck truckInfo() {
        System.out.println("Enter the license plates:");
        String licensePlates = scanner.nextLine();
        System.out.println("Enter the producer:");
        String producer = scanner.nextLine();
        System.out.println("Enter year of produce:");
        int yearOfProduce = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name of owner:");
        String owner = scanner.nextLine();
        System.out.println("Enter tonnage :");
        int tonnage = Integer.parseInt(scanner.nextLine());
        return new Truck(licensePlates, producer, yearOfProduce, owner, tonnage);
    }
    @Override
    public void add() {
        trucksList.add(truckInfo());
        System.out.println("Add new transport successfully");
    }

    @Override
    public void show() {
        for (Truck truck : trucksList) {
            System.out.println(truck);
        }
        System.out.println();
    }

    @Override
    public void remove() {
        System.out.print("Enter the license plate of truck you want to remove:");
        String licensePlate = scanner.nextLine();
        boolean flagRemove = false;

        for (int i = 0; i < trucksList.size(); i++) {

            if (licensePlate.equals(trucksList.get(i).getLicensePlates())) {
                System.out.print("Are you confirm? yes:y, no:n.");
                String choice = scanner.nextLine();

                if (choice.equals("y")) {
                    trucksList.remove(i);
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
        for (int i = 0; i < trucksList.size(); i++) {

            if (licensePlate.equals(trucksList.get(i).getLicensePlates())) {
                System.out.println(trucksList.get(i).toString());
                return i;
            }
        }

        return -1;
    }
}
