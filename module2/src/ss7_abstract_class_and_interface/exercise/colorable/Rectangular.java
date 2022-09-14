package ss7_abstract_class_and_interface.exercise.colorable;

public class Rectangular extends Shape {
    private double width;
    private double length;

    Rectangular() {
        this.width = 1;
        this.length = 1;
    }

    Rectangular(double width, double length) {
        super();
        this.width = width;
        this.length = length;
    }

    Rectangular(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getAre() {
        return this.width * this.length;
    }

    public double getPerimeter() {
        return (this.width * this.length) * 2;
    }

    @Override
    public String toString() {
        return "A Rectangular with width= " + this.width + ", length= " + this.length;
    }

    public static class Main {
        public static void main(String[] args) {
            Shape[] shapes = new Shape[3];
            shapes[0] = new Circle(4);
            shapes[0] = new Square(4);
            shapes[0] = new Rectangular(4,8);
            for(Shape shape: shapes){
                System.out.println(shape);
                if(shape instanceof Square){
                    System.out.println(shape);
                }
            }
        }
    }
}
