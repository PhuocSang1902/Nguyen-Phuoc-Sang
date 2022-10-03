package case_study_furama_resort_module_2.models;

public class Booking {
    private String bookingCode;
    private String startDay;
    private String endDay;
    private String CustomerCode;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }

    public Booking(String bookingCode, String startDay, String endDay, String customerCode, String serviceName, String serviceType) {
        this.bookingCode = bookingCode;
        this.startDay = startDay;
        this.endDay = endDay;
        CustomerCode = customerCode;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String customerCode) {
        CustomerCode = customerCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode='" + bookingCode + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", CustomerCode='" + CustomerCode + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
