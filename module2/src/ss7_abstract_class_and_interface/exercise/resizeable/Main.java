package ss7_abstract_class_and_interface.exercise.resizeable;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(4);
        Rectangular rec = new Rectangular(2,6);
        Circle c = new Circle(5);
        System.out.println(square);
        System.out.println(rec);
        System.out.println(c);
        square.resize(Math.floor(Math.random()*100 + 1));
        rec.resize(Math.floor(Math.random()*100 + 1));
        c.resize(Math.floor(Math.random()*100 + 1));
        System.out.println(square);
        System.out.println(rec);
        System.out.println(c);
    }
}
