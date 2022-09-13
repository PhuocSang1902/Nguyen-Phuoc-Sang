package ss6_inheritance.exercise.circle_and_cylinder_class;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("red", 3.5);
        Cylinder cylinder = new Cylinder("blue",  2.5, 3);
        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getVolume());
        System.out.println(cylinder.getColor());
    }
}
