package ss10_java_collection_framework.exercise.exercise_extra_2.model;

public class Motorbike extends Transport {
    private int wattage;

    public Motorbike(){
    }

    public Motorbike(String licensePlates, String producer, int yearOfProduce, String owner, int wattage){
        super(licensePlates, producer, yearOfProduce, owner);
        this.wattage = wattage;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", wattage=" + wattage + "cc" +
                '}';
    }
}
