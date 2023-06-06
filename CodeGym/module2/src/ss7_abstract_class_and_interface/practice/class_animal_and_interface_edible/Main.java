package ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal:animals) {
            System.out.println(animal.makeSound());
        }
        Chicken chicken = (Chicken)animals[1];
        System.out.println(chicken.howToEat());
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
