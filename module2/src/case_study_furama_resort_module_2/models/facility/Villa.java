package case_study_furama_resort_module_2.models.facility;

public class Villa extends Facility {
    private String standardRoom;
    private double poolArea;
    private int numberOfFloor;

    public Villa() {
    }

    public Villa(String facilityCode, String serviceName, double usableArea, double rentalCost, int maximumNumberOfPeople, String rentalType) {
        super(facilityCode, serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType);
    }

    public Villa(String facilityCode, String serviceName, double usableArea, double rentalCost, int maximumNumberOfPeople, String rentalType, String standardRoom, double poolArea, int numberOfFloor) {
        super(facilityCode, serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType);
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
                ", standardRoom='" + standardRoom + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
}
