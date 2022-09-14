package ss7_abstract_class_and_interface.practice.geometric_object;

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
        return "A Rectangular with width= " + this.width + ", length= " + this.length +
                " , witch is a subclass of " + super.toString();
    }
}
