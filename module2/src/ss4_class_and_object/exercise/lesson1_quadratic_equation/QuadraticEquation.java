package ss4_class_and_object.exercise.lesson1_quadratic_equation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getRoot1() {
        double root1;
        root1 = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
        return root1;
    }

    public double getRoot2() {
        double root1;
        root1 = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
        return root1;
    }

    public int checkDelta(){
        double delta = Math.pow(b,2) - 4 * a * c;
        if (delta > 0){
            return 1;
        }
        if (delta == 0){
            return 0;
        }
        return -1;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }


}
