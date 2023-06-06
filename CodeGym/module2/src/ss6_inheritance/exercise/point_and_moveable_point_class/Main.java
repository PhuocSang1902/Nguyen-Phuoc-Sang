package ss6_inheritance.exercise.point_and_moveable_point_class;

public class Main {
    public static void main(String[] args) {
        MovablePoint m = new MovablePoint(1, 2, 2, 4);
        System.out.println(m);
        MovablePoint a = m.move().move().move();
        System.out.println(a);

    }
}
