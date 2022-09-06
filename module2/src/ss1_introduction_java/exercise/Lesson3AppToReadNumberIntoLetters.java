package ss1_introduction_java.exercise;

import java.util.Scanner;

public class Lesson3AppToReadNumberIntoLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number you want to read: ");
        int number = scanner.nextInt();
        String text = "";
        int hundreds = number / 100;
        int ones = number % 10;
        int tens = (number % 100) / 10;
        switch (hundreds) {
            case 1:
                text = "One hundred";
                break;
            case 2:
                text = "Two hundred";
                break;
            case 3:
                text = "Three hundred";
                break;
            case 4:
                text = "Four hundred";
                break;
            case 5:
                text = "Five hundred";
                break;
            case 6:
                text = "Six hundred";
                break;
            case 7:
                text = "Seven hundred";
                break;
            case 8:
                text = "Eight hundred";
                break;
            case 9:
                text = "Nine hundred";
                break;
        }
        if (number > 100) {
            text += " ";
        }
        if (tens == 1) {
            switch (ones) {
                case 0:
                    text += "Ten";
                    break;
                case 1:
                    text += "Eleven";
                    break;
                case 2:
                    text += "Twelve";
                    break;
                case 3:
                    text += "Thirteen";
                    break;
                case 4:
                    text += "Fourteen";
                    break;
                case 5:
                    text += "Fifteen";
                    break;
                case 6:
                    text += "Sixteen";
                    break;
                case 7:
                    text += "Seventeen";
                    break;
                case 8:
                    text += "Eighteen";
                    break;
                case 9:
                    text += "Nineteen";
                    break;
            }
        }
        switch (tens) {
            case 2:
                text += "Twenty";
                break;
            case 3:
                text += "Thirty";
                break;
            case 4:
                text += "Forty";
                break;
            case 5:
                text += "Fifty";
                break;
            case 6:
                text += "Sixty";
                break;
            case 7:
                text += "Seventy";
                break;
            case 8:
                text += "Eighty";
                break;
            case 9:
                text += "Ninety";
                break;
        }
        if (number > 100 && number < 110) {
            text += "and ";
        }else if (number > 10){
            text += " ";
        }
        if (tens != 1) {
            switch (ones) {
                case 0:
                    if (number < 10) {
                        text += "Zero";
                    }
                    break;
                case 1:
                    text += "One";
                    break;
                case 2:
                    text += "Two";
                    break;
                case 3:
                    text += "Three";
                    break;
                case 4:
                    text += "Four";
                    break;
                case 5:
                    text += "Five";
                    break;
                case 6:
                    text += "Six";
                    break;
                case 7:
                    text += "Seven";
                    break;
                case 8:
                    text += "Eight";
                    break;
                case 9:
                    text += "Nine";
                    break;
            }
        }
        System.out.println(number + " is " + text);
    }
}
