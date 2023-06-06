package ss10_java_collection_framework.exercise.exercise_extra_2.model;

public class Truck extends Transport {
    private int tonnage;

    public Truck(){
    }

    public Truck(String licensePlates, String producer, int yearOfProduce, String owner, int tonnage){
        super(licensePlates, producer, yearOfProduce, owner);
        this.tonnage = tonnage;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tonnage=" + tonnage + "kg" +
                '}';
    }
}
