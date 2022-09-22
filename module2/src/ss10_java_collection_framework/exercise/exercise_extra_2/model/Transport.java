package ss10_java_collection_framework.exercise.exercise_extra_2.model;

public class Transport {
    private String licensePlates;
    private String producer;
    private int yearOfProduce;
    private String owner;

    public Transport(){
    }
    public Transport(String licensePlates, String producer, int yearOfProduce, String owner){
        this.licensePlates = licensePlates;
        this.producer = producer;
        this.yearOfProduce = yearOfProduce;
        this.owner = owner;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYearOfProduce() {
        return yearOfProduce;
    }

    public void setYearOfProduce(int yearOfProduce) {
        this.yearOfProduce = yearOfProduce;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "licensePlates='" + licensePlates + '\'' +
                ", producer='" + producer + '\'' +
                ", yearOfProduce=" + yearOfProduce +
                ", owner='" + owner + '\'';
    }
}
