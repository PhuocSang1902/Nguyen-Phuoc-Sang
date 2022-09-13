package ss5_access_modifier_static.practice.static_property;

public class Car {
    private String name;
    private String engine;
    static int numberOfCar;

    Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCar++;
    }
}
