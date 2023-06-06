package ss5_access_modifier_static.exercise.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2);
        Circle c3 = new Circle(3);
        System.out.println(c1.getRadius());
        System.out.println(c2.getRadius());
        System.out.println(c3.getRadius());
    }
}
