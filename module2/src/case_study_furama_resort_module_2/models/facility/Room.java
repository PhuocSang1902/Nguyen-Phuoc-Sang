package case_study_furama_resort_module_2.models.facility;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {
    }

    public Room(String facilityCode, String serviceName, double usableArea, double rentalCost, int maximumNumberOfPeople, String rentalType) {
        super(facilityCode, serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType);
    }

    public Room(String facilityCode, String serviceName, double usableArea, double rentalCost, int maximumNumberOfPeople, String rentalType, String freeServiceIncluded) {
        super(facilityCode, serviceName, usableArea, rentalCost, maximumNumberOfPeople, rentalType);
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
        return "Room{" + super.toString() +
                ", freeServiceIncluded='" + freeServiceIncluded + '\'' +
                '}';
    }
}
