package ss10_java_collection_framework.exercise.exercise_extra_2.controller;

import ss10_java_collection_framework.exercise.exercise_extra_2.model.Car;
import ss10_java_collection_framework.exercise.exercise_extra_2.model.Motorbike;
import ss10_java_collection_framework.exercise.exercise_extra_2.model.Truck;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.ICarService;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.IMotorbikeService;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.ITruckService;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.impl.CarService;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.impl.MotorbikeService;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.impl.TruckService;

import java.util.Scanner;

public class TransportController {
    public static Scanner scanner = new Scanner(System.in);
    public static ICarService iCarService = new CarService();
    public static ITruckService iTruckService = new TruckService();
    public static IMotorbikeService iMotorbikeService = new MotorbikeService();

    public static void menuTransport() {
        while (true) {
            System.out.println("TRANSPORT MANAGEMENT TRANSPORT");
            System.out.println("Choose the function follow the number");
            System.out.println("1.Add new transport");
            System.out.println("2.Show transport list");
            System.out.println("3.Remove transport");
            System.out.println("4.Find transport follow license plates");
            System.out.println("5.Exit");
            System.out.println("6.Creat temp to test.");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice) {
                case 1:
                    menuAdd();
                    break;
                case 2:
                    menuShow();
                    break;
                case 3:
                    menuRemove();
                    break;
                case 4:
                    findRemove();
                    break;
                case 6:
                    Car car1 = new Car("43A1-12345", "Ford", 2009, "Nguyen Van A", 7, false);
                    Car car2 = new Car("43A1-12346", "Mercedes", 2015, "Nguyen Van B", 12, true);
                    Car car3 = new Car("43A1-12347", "Audi", 2015, "Nguyen Van B", 4, false);
                    Car car4 = new Car("43A1-12348", "THACO", 2020, "Nguyen Van C", 45, true);
                    Truck truck1 = new Truck("43A1-12351", "THACO", 2001, "Nguyen Van D", 500);
                    Truck truck2 = new Truck("43A1-12352", "THACO", 2017, "Nguyen Van E", 3000);
                    Motorbike motorbike1 = new Motorbike("43A1-12368", "YAMAHA", 2021, "Nguyen Van F", 120);
                    Motorbike motorbike2 = new Motorbike("43A1-12376", "HONDA", 2022, "Nguyen Van G", 150);
                    CarService.carsList.add(car1);
                    CarService.carsList.add(car2);
                    CarService.carsList.add(car3);
                    CarService.carsList.add(car4);
                    TruckService.trucksList.add(truck1);
                    TruckService.trucksList.add(truck2);
                    MotorbikeService.motorsList.add(motorbike1);
                    MotorbikeService.motorsList.add(motorbike2);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Enter again.");
                    System.out.println();
            }
        }
    }

    public static void menuAdd() {
        while (true) {
            System.out.println("ADD TRANSPORT");
            System.out.println("Choose the function follow the number");
            System.out.println("1.Add new car");
            System.out.println("2.Add new truck");
            System.out.println("3.Add new motorbike");
            System.out.println("4.Return main menu.");
            System.out.println("5.Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice) {
                case 1:
                    iCarService.add();
                    break;
                case 2:
                    iTruckService.add();
                    break;
                case 3:
                    iMotorbikeService.add();
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Enter again.");
                    System.out.println();
            }
        }
    }

    public static void menuShow() {
        while (true) {
            System.out.println("SHOW TRANSPORT");
            System.out.println("Choose the function follow the number");
            System.out.println("1.Show cars list");
            System.out.println("2.Show trucks list");
            System.out.println("3.Show motorbikes list");
            System.out.println("4.Show transport list");
            System.out.println("5Return main menu.");
            System.out.println("6.Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice) {
                case 1:
                    iCarService.show();
                    break;
                case 2:
                    iTruckService.show();
                    break;
                case 3:
                    iMotorbikeService.show();
                    break;
                case 4:
                    iCarService.show();
                    iTruckService.show();
                    iMotorbikeService.add();
                    break;
                case 5:
                    return;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter again.");
                    System.out.println();
            }
        }
    }

    public static void menuRemove() {
        while (true) {
            System.out.println("REMOVE TRANSPORT");
            System.out.println("Choose the function follow the number");
            System.out.println("1.Remove a car");
            System.out.println("2.Remove a truck");
            System.out.println("3.Remove a motorbike");
            System.out.println("4.Return main menu.");
            System.out.println("5.Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice) {
                case 1:
                    iCarService.remove();
                    break;
                case 2:
                    iTruckService.remove();
                    break;
                case 3:
                    iMotorbikeService.remove();
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Enter again.");
                    System.out.println();
            }
        }
    }

    public static void findRemove() {
        while (true) {
            System.out.println("REMOVE TRANSPORT");
            System.out.println("Choose the function follow the number");
            System.out.println("1.Find a car");
            System.out.println("2.Find a truck");
            System.out.println("3.Find a motorbike");
            System.out.println("4.Find a transport");
            System.out.println("5.Return main menu.");
            System.out.println("6.Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (choice) {
                case 1:
                    iCarService.find();
                    if (iCarService.find() == -1) {
                        System.out.println("There is not transport in the transports list.");
                    }
                    break;
                case 2:
                    iTruckService.find();
                    if (iTruckService.find() == -1) {
                        System.out.println("There is not transport in the transports list.");
                    }
                    break;
                case 3:
                    iMotorbikeService.find();
                    if (iMotorbikeService.find() == -1) {
                        System.out.println("There is not transport in the transports list.");
                    }
                    break;
                case 4:
                    if (iCarService.find() != -1) {
                        iCarService.find();
                    } else if (iTruckService.find() != -1) {
                        iTruckService.find();
                    } else if (iMotorbikeService.find() != -1) {
                        iMotorbikeService.find();
                    }else {
                        System.out.println("There is not transport in the transports list.");
                    }
                    return;
                case 5:
                    return;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter again.");
                    System.out.println();
            }
        }
    }
}
