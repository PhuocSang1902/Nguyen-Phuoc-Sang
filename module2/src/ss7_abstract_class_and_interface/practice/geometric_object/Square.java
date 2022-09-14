package ss7_abstract_class_and_interface.practice.geometric_object;

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
    public void setWidth(double side){
        this.setSide(side);
    }
    public void setLength(double side){
        this.setSide(side);
    }
    public String toString() {
        return "A Square with side= " + getSide() + " , witch is a subclass of " + super.toString();
    }
}
