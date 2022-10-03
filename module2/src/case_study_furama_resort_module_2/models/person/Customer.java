package case_study_furama_resort_module_2.models.person;

public class Customer extends Person {
    private String guestType;
    private String address;

    public Customer() {
    }

    public Customer(String employeeCode, String fullName, String dateOfBirth, String gender, String idNumber, String phoneNumber, String email) {
        super(employeeCode, fullName, dateOfBirth, gender, idNumber, phoneNumber, email);
    }

    public Customer(String employeeCode, String fullName, String dateOfBirth, String gender, String idNumber, String phoneNumber, String email, String guestType, String address) {
        super(employeeCode, fullName, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.guestType = guestType;
        this.address = address;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "guestType='" + guestType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
