package ss10_java_collection_framework.exercise.exercise_extra_2.service.impl;

import ss10_java_collection_framework.exercise.exercise_extra_2.model.Car;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.ICarService;

import java.util.ArrayList;
import java.util.Scanner;

public class CarService implements ICarService {
    public static ArrayList<Car> carsList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public Car carInfo() {
        System.out.println("Enter the license plates:");
        String licensePlates = scanner.nextLine();
        System.out.println("Enter the producer:");
        String producer = scanner.nextLine();
        System.out.println("Enter year of produce:");
        int yearOfProduce = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name of owner:");
        String owner = scanner.nextLine();
        int numberOfSeats = Integer.parseInt(scanner.nextLine());
        boolean carType;
        while (true) {
            System.out.println("Enter type of car:");
            String tempCarType = scanner.nextLine();
            if (tempCarType.equals("coach")) {
                carType = true;
                break;
            } else if (tempCarType.equals("travel car")) {
                carType = false;
                break;
            } else {
                System.out.println("There are 2 type of car. That are coach and travel car.Please, enter correctly type of car.");
            }
        }

        return new Car(licensePlates, producer, yearOfProduce, owner, numberOfSeats, carType);
    }

    @Override
    public void add() {
        carsList.add(carInfo());
        System.out.println("Add new transport successfully");
    }

    @Override
    public void show() {
        for (Car car : carsList) {
            System.out.println(car);
        }
        System.out.println();
    }

    @Override
    public void remove() {
        System.out.print("Enter the license plate of truck you want to remove:");
        String licensePlate = scanner.nextLine();
        boolean flagRemove = false;

        for (int i = 0; i < carsList.size(); i++) {

            if (licensePlate.equals(carsList.get(i).getLicensePlates())) {
                System.out.print("Are you confirm? yes:y, no:n.");
                String choice = scanner.nextLine();

                if (choice.equals("y")) {
                    carsList.remove(i);
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
        for (int i = 0; i < carsList.size(); i++) {

            if (licensePlate.equals(carsList.get(i).getLicensePlates())) {
                System.out.println(carsList.get(i).toString());
                return i;
            }
        }

        return -1;
    }
}
