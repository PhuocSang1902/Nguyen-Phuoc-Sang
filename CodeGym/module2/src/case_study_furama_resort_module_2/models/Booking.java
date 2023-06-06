package case_study_furama_resort_module_2.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Booking implements Comparable<Booking> {
    private String bookingCode;
    private LocalDate startDay;
    private LocalDate endDay;
    private String CustomerCode;
    private String serviceCode;
    private String serviceType;

    public Booking() {
    }

    public Booking(String bookingCode, LocalDate startDay, LocalDate endDay, String customerCode, String serviceName, String serviceType) {
        this.bookingCode = bookingCode;
        this.startDay = startDay;
        this.endDay = endDay;
        CustomerCode = customerCode;
        this.serviceCode = serviceName;
        this.serviceType = serviceType;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String customerCode) {
        CustomerCode = customerCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return "Booking{" +
                "bookingCode='" + bookingCode + '\'' +
                ", startDay='" + startDay.format(fm) + '\'' +
                ", endDay='" + endDay.format(fm) + '\'' +
                ", CustomerCode='" + CustomerCode + '\'' +
                ", serviceName='" + serviceCode + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        if(this.getStartDay().compareTo(o.getStartDay()) != 0){
            return this.getStartDay().compareTo(o.getStartDay());
        }
        return this.getEndDay().compareTo(o.getEndDay());
    }
}
