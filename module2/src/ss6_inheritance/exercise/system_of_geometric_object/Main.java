package ss6_inheritance.exercise.system_of_geometric_object;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3,4,5);
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getArea());
    }
}
