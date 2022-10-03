package case_study_furama_resort_module_2.models.facility;

import case_study_furama_resort_module_2.models.facility.Facility;

public class House extends Facility {
    private String roomStandard;
    private int numberOfFloor;

    public House() {
    }

    public House(String serviceName, String usableArea, double rentalCost, int maximumNumberOfPeople, String rentalType) {
        super(serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType);
    }

    public House(String serviceName, String usableArea, double rentalCost, int maximumNumberOfPeople, String rentalType, String roomStandard, int numberOfFloor) {
        super(serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
}
