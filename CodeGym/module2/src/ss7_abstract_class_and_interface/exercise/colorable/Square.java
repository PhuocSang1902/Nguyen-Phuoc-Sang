package ss7_abstract_class_and_interface.exercise.colorable;


public class Square extends Rectangular implements Colorable {

    Square() {
    }

    Square(double side) {
        super(side, side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setLength(side);
        setWidth(side);
    }
    @Override
    public String toString() {
        return "A Square with side= " + getSide();
    }

    @Override
    public String howToColor() {
        return "Color all four sides.";
    }
}
