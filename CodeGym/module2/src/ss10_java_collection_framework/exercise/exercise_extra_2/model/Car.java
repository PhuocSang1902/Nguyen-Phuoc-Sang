package ss10_java_collection_framework.exercise.exercise_extra_2.model;

public class Car extends Transport {
    private int numberOfSeats;
    private boolean carType;

    public Car(){
    }

    public Car(String licensePlates, String producer, int yearOfProduce, String owner, int numberOfSeats, boolean carType){
        super(licensePlates, producer, yearOfProduce, owner);
        this.numberOfSeats = numberOfSeats;
        this.carType = carType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isCarType() {
        return carType;
    }

    public void setCarType(boolean carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        if (this.carType) {
            return super.toString() +
                    "numberOfSeats=" + numberOfSeats +
                    ", carType= coach" +
                    '}';
        }else {
            return super.toString() +
                    "numberOfSeats=" + numberOfSeats +
                    ", carType= travel car" +
                    '}';
        }
    }
}
