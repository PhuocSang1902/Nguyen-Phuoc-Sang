package ss3_array_function.practice;

import java.util.Scanner;

public class Lesson4ConvertTemperature {
    public static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * fahrenheit + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double celsius;
        double fahrenheit;
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Fahrenheit to Celsius.");
            System.out.println("2. Celsius to Fahrenheit.");
            System.out.println("0. Exit.");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in fahrenheit ");
                    fahrenheit = Double.parseDouble(scanner.nextLine());
                    System.out.println(fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.print("Enter temperature in celsius ");
                    celsius = Double.parseDouble(scanner.nextLine());
                    System.out.println(celsiusToFahrenheit(celsius));
                    break;
            }
        } while (choice != 0);
    }
}
