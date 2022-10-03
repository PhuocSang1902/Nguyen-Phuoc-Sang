package case_study_furama_resort_module_2.models.facility;

import case_study_furama_resort_module_2.models.facility.Facility;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {
    }

    public Room(String serviceName, String usableArea, double rentalCost, int maximumNumberOfPeople, String rentalType) {
        super(serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType);
    }

    public Room(String serviceName, String usableArea, double rentalCost, int maximumNumberOfPeople, String rentalType, String freeServiceIncluded) {
        super(serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeServiceIncluded='" + freeServiceIncluded + '\'' +
                '}';
    }
}
