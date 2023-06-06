package ss6_inheritance.exercise.circle_and_cylinder_class;

public class Cylinder extends Circle {
    private double height;

    Cylinder() {
    }

    Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                super.toString() +
                "height=" + height +
                '}';
    }
}
