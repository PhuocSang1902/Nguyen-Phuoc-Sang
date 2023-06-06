package ss4_class_and_object.practice.Lesson1Rectangular;

import java.util.Scanner;

public class MainRectangular {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the width and height of rectangular: ");
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        Rectangular rectangular = new Rectangular(width, height);
        System.out.println(rectangular.display());
        System.out.println("Perimeter of the rectangular is: " + rectangular.getPerimeter());
        System.out.println("Area of the rectangular is: " + rectangular.getArea());
    }
}
