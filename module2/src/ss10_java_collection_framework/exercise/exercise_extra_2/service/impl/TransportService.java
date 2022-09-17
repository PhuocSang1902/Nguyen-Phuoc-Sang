package ss10_java_collection_framework.exercise.exercise_extra_2.service.impl;

import ss10_java_collection_framework.exercise.exercise_extra_2.model.Car;
import ss10_java_collection_framework.exercise.exercise_extra_2.model.Motorbike;
import ss10_java_collection_framework.exercise.exercise_extra_2.model.Transport;
import ss10_java_collection_framework.exercise.exercise_extra_2.model.Truck;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.ITransportService;

import java.util.ArrayList;
import java.util.Scanner;

public class TransportService implements ITransportService {
    public static ArrayList<Transport> transportsList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static final int optionOne = 1;
    public static final int optionTwo = 2;
    public static final int optionThree = 3;
    public static final int optionFour = 4;
    public static final int optionFive = 5;

    public Transport carInfo() {
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

    public Transport truckInfo() {
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

    public Transport motorbikeInfo() {
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
        return new Truck(licensePlates, producer, yearOfProduce, owner, wattage);
    }

    @Override
    public void add() {
        while (true) {
            System.out.println("There are 3 types of transport follow the numbers:");
            System.out.println("1.Car.");
            System.out.println("2.Truck.");
            System.out.println("3.Motorbike.");
            System.out.println("4.Return main menu.");
            System.out.print("Enter type of transport:");
            int transportType = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (transportType) {
                case optionOne:
                    Transport transport = this.carInfo();
                    transportsList.add(transport);
                    System.out.println("Add new transport successfully.");
                    System.out.println();
                    break;
                case optionTwo:
                    transport = this.truckInfo();
                    transportsList.add(transport);
                    System.out.println("Add new transport successfully.");
                    System.out.println();
                    break;
                case optionThree:
                    transport = this.motorbikeInfo();
                    transportsList.add(transport);
                    System.out.println("Add new transport successfully.");
                    System.out.println();
                    break;
                case optionFour:
                    return;
                default:
                    System.out.println("Your car type is not correct. Enter again.");
                    System.out.println();
            }
        }
    }

    @Override
    public void show() {
        while (true) {
            System.out.println("List transports:");
            System.out.println("1.List trucks.");
            System.out.println("2.List cars.");
            System.out.println("3.List motorbikes.");
            System.out.println("4.List transports.");
            System.out.println("5.Return main menu.");
            System.out.print("Enter your choice:");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice) {
                case optionOne:
                    for (Transport transport : transportsList) {
                        if (transport instanceof Truck) {
                            System.out.println(((Truck) transport).toString());
                        }
                    }
                    System.out.println();
                    break;
                case optionTwo:
                    for (Transport transport : transportsList) {
                        if (transport instanceof Car) {
                            System.out.println(((Car) transport).toString());
                        }
                    }
                    System.out.println();
                    break;
                case optionThree:
                    for (Transport transport : transportsList) {
                        if (transport instanceof Motorbike) {
                            System.out.println(((Motorbike) transport).toString());
                        }
                    }
                    break;
                case optionFour:
                    for (Transport transport : transportsList) {
                        if (transport instanceof Car) {
                            System.out.println(((Car) transport).toString());
                        } else if (transport instanceof Truck) {
                            System.out.println(((Truck) transport).toString());
                        } else if (transport instanceof Motorbike) {
                            System.out.println(((Motorbike) transport).toString());
                        }
                    }
                    System.out.println();
                    break;
                case optionFive:
                    return;

            }
        }
    }

    @Override
    public void remove() {
        System.out.print("Enter the license plate that you want to remove:");
        String licensePlate = scanner.nextLine();
        boolean flagRemove = false;

        for (int i = 0; i < transportsList.size(); i++) {

            if (licensePlate.equals(transportsList.get(i).getLicensePlates())) {
                System.out.print("Are you confirm? yes:y, no:n.");
                String choice = scanner.nextLine();

                if (choice.equals("y")) {
                    transportsList.remove(i);
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
    }

    @Override
    public void find() {
        System.out.print("Enter the license plate:");
        String licensePlate = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < transportsList.size(); i++) {
            if (licensePlate.equals(transportsList.get(i).getLicensePlates())) {
                index = i;
                if (transportsList.get(i) instanceof Car) {
                    System.out.println(((Car) transportsList.get(index)).toString());
                } else if (transportsList.get(i) instanceof Truck) {
                    System.out.println(((Truck) transportsList.get(index)).toString());
                } else if (transportsList.get(i) instanceof Motorbike) {
                    System.out.println(((Motorbike) transportsList.get(index)).toString());
                }
                System.out.println();
            }
        }
        if (index == -1) {
            System.out.println("There is not transport in the transports list.");
            System.out.println();
        }
    }

    @Override
    public void creatTemp() {
        Transport car1 = new Car("43A1-12345", "Ford", 2009, "Nguyen Van A", 7, false);
        Transport car2 = new Car("43A1-12346", "Mercedes", 2015, "Nguyen Van B", 12, true);
        Transport car3 = new Car("43A1-12347", "Audi", 2015, "Nguyen Van B", 4, false);
        Transport car4 = new Car("43A1-12348", "THACO", 2020, "Nguyen Van C", 45, true);
        Transport truck1 = new Truck("43A1-12351", "THACO", 2001, "Nguyen Van D", 500);
        Transport truck2 = new Truck("43A1-12352", "THACO", 2017, "Nguyen Van E", 3000);
        Transport motorbike1 = new Motorbike("43A1-12368", "YAMAHA", 2021, "Nguyen Van F", 120);
        Transport motorbike2 = new Motorbike("43A1-12376", "HONDA", 2022, "Nguyen Van G", 150);
        transportsList.add(car1);
        transportsList.add(car2);
        transportsList.add(car3);
        transportsList.add(car4);
        transportsList.add(truck1);
        transportsList.add(truck2);
        transportsList.add(motorbike1);
        transportsList.add(motorbike2);
    }
}
