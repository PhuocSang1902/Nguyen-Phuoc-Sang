package ss7_abstract_class_and_interface.exercise.resizeable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(4);
        shapes[1] = new Rectangular(2, 6);
        shapes[2] = new Circle(5);
        for (Shape shape : shapes) {
            System.out.printf("%.2f\n",shape.getArea());
            ((Resizeable) shape).resize(Math.floor(Math.random() * 100 + 1));
            System.out.printf("%.2f\n",shape.getArea());
        }
    }
}
