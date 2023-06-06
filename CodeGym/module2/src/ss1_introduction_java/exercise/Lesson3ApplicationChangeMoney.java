package ss1_introduction_java.exercise;

import java.util.Scanner;

public class Lesson3ApplicationChangeMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount in USD you want to exchange: ");
        double exchangeRate = 23000;
        double inputMoney = scanner.nextFloat();
        double outputMoney = inputMoney * exchangeRate;
        System.out.println(inputMoney + " USD is " + outputMoney + " VND.");
    }
}
