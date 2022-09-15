package ss8_clean_code_and_refactoring.practice.separating_method;

public class Cylinder {
    public static double getVolume(int radius, int height) {
        return getPerimeter(radius) * height + 2 * getBaseArea(radius);
    }

    public static double getPerimeter(int radius) {
        return 2 * Math.PI * radius;
    }

    public static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }
}
