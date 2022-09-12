package ss5_access_modifier_static_method_static_property.practice.static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car s1 = new Car("ford", "v8");
        Car s2 = new Car("toyota", "v6");
        Car s3 = new Car("huyndai", "v4");
        System.out.println(Car.numberOfCar);
    }
}
