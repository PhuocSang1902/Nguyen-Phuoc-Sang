package ss15_exception_debug.exercise.illegal_triangle_exception;

import java.util.Scanner;

public class ExampleTriangle {
    static Scanner scanner = new Scanner(System.in);
    static int i=1;

    public static void main(String[] args) {
        int side1;
        int side2;
        int side3;
        while (true){
            side1 = inputTriangleSide();
            side2 = inputTriangleSide();
            side3 = inputTriangleSide();

            try {
                check3TriangleSide(side1, side2, side3);
                System.out.println("These are triangle sides.");
                break;
            } catch (IllegalTriangleException e) {
                i = 1;
                System.out.println("These sides are not sides of triangle");
                System.out.println();
            }
        }

    }

    static int inputTriangleSide() {
        int side;
        while (true) {
            System.out.println("Enter triangle side " + i + ": ");

            try {
                side = Integer.parseInt(scanner.nextLine());
                checkTriangleSide(side);
                i++;
                System.out.println();
                return side;
            } catch (IllegalTriangleException e) {
                System.out.println("Triangle side is greater than zero.");
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Triangle side is a Integer");
                System.out.println();
            }
        }
    }

    static void check3TriangleSide(int side1, int side2, int side3) throws IllegalTriangleException {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side3 + side2 <= side1) {
            throw new IllegalTriangleException("Illegal Triangle Exception!");
        }
    }

    static void checkTriangleSide(int side1) throws IllegalTriangleException {
        if (side1 <= 0) {
            throw new IllegalTriangleException("Illegal Triangle Exception!");
        }
    }
}
