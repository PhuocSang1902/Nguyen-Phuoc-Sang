package ss7_abstract_class_and_interface.exercise.colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        Circle[] array = new Circle[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Square(5);
        shapes[2] = new Rectangular(4,6);
        for(Shape shape: shapes){
            System.out.println(shape);
            if(shape instanceof Square){
                System.out.println(((Square)shape).howToColor());
            }
        }
    }
}
