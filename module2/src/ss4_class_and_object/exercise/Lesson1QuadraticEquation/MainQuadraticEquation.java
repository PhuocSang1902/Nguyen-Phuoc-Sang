package ss4_class_and_object.exercise.Lesson1QuadraticEquation;

import java.util.Scanner;

public class MainQuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a b c of quadratic equation:");
        double a = Double.parseDouble(sc.nextLine());
        double b = Double.parseDouble(sc.nextLine());
        double c = Double.parseDouble(sc.nextLine());
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.checkDelta() == 1) {
            System.out.printf("Root 1 of quadratic equation is %.2f\n", quadraticEquation.getRoot1());
            System.out.printf("Root 2 of quadratic equation is %.2f\n", quadraticEquation.getRoot2());
        }else if (quadraticEquation.checkDelta() == 0){
            System.out.printf("Root of quadratic equation is %.2f\n", quadraticEquation.getRoot1());
        }else {
            System.out.println("Quadratic equation is not have really root.");
        }
    }

}
