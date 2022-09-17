package ss10_java_collection_framework.exercise.exercise_extra_2.controller;

import ss10_java_collection_framework.exercise.exercise_extra_2.model.Transport;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.ITransportService;
import ss10_java_collection_framework.exercise.exercise_extra_2.service.impl.TransportService;

import java.util.Scanner;

public class TransportController {
    public static Scanner scanner = new Scanner(System.in);
    public static ITransportService iTransportService = new TransportService();

    public static void menuTransport() {
        while(true){
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
            switch (choice){
                case 1:
                    iTransportService.add();
                    break;
                case 2:
                    iTransportService.show();
                    break;
                case 3:
                    iTransportService.remove();
                    break;
                case 4:
                    iTransportService.find();
                    break;
                case 6:
                    iTransportService.creatTemp();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
