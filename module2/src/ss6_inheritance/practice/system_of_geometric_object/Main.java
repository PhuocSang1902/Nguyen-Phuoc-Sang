package ss6_inheritance.practice.system_of_geometric_object;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("red", false);
        System.out.println(shape);
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(5);
        System.out.println(circle);
        Rectangular rectangular = new Rectangular();
        System.out.println(rectangular);
        rectangular = new Rectangular(2.3,2.5);
        System.out.println(rectangular);
        Square square = new Square();
        System.out.println(square);
        square = new Square(2.5);
        System.out.println(square);
    }
}
