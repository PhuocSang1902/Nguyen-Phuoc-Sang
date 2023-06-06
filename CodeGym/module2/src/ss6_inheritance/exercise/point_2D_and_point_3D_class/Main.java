package ss6_inheritance.exercise.point_2D_and_point_3D_class;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point2D coordinate = new Point2D();
        Point3D coordinate2 = new Point3D();
        System.out.println(coordinate);
        System.out.println(coordinate2);
        System.out.println(Arrays.toString(coordinate2.getXY()));
        coordinate2.setXY(1f,4f);
        System.out.println(coordinate2);
    }
}
