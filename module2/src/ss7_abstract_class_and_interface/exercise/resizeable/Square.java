package ss7_abstract_class_and_interface.exercise.resizeable;

public class Square extends Rectangular {

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
}
