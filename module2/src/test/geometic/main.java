package test.geometic;

public class main {
    public static void main(String[] args) {
        Geometic c = new Circle();
        Geometic a = new Circle();
        System.out.println(c.name);
        Circle c1 = (Circle)c;
        System.out.println(a.getArea());
        System.out.println(c1.getArea());
//        System.out.println(c.goemetric);
        System.out.println(c instanceof Circle);
        System.out.println(c instanceof Circle);
    }
}
