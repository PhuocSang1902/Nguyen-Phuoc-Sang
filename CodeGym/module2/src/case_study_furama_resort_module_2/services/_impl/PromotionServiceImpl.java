package case_study_furama_resort_module_2.services._impl;

import case_study_furama_resort_module_2.models.Booking;
import case_study_furama_resort_module_2.models.person.Customer;
import case_study_furama_resort_module_2.services.PromotionService;
import case_study_furama_resort_module_2.services._impl.people_service_impl.CustomerServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class PromotionServiceImpl implements PromotionService {
    private static Scanner sc = new Scanner(System.in);
    private static BookingServiceImpl bookingService = new BookingServiceImpl();
    private static CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    public void display() {
        TreeSet<Booking> bookingSet = bookingService.getDataFromFile();
        String year;
        while (true) {
            System.out.print("Enter the year that you want to display list customer use service: ");
            year = sc.nextLine();
            final String REGEXP = "[0-9]{4}";
            if (!year.matches(REGEXP)) {
                System.out.println("Wrong format. Enter again!");
            } else {
                break;
            }
        }
        for (Booking booking : bookingSet) {
            if (booking.getStartDay().getYear() == Integer.parseInt(year)) {
                List<Customer> customerList = customerService.getDataFromFile();
                for (Customer customer : customerList) {
                    if (customer.getCode().equals(booking.getCustomerCode())) {
                        System.out.println(customer.toString());
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void displayCustomerGetVoucher() {
        TreeSet<Booking> bookingSet = bookingService.getDataFromFile();
        TreeSet<Booking> bookings = new TreeSet<>();
        for (Booking booking : bookingSet) {
            if (booking.getStartDay().getMonth().equals(LocalDate.now().getMonth())) {
                bookings.add(booking);
            }
        }
        System.out.println("Enter the number of voucher 10%: ");
        int voucher10 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the number of voucher 20%: ");
        int voucher20 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the number of voucher 50%: ");
        int voucher50 = Integer.parseInt(sc.nextLine());

        int totalVoucher = voucher10 + voucher20 + voucher50;
        int countCustomer = 0;

        for (Booking booking : bookings) {

            String codeOfBooking = booking.getCustomerCode();
            List<Customer> customerList = customerService.getDataFromFile();

            for (Customer customer : customerList) {

                String codeOfCustomer = customer.getCode();
                boolean isEqual = codeOfCustomer.equals(codeOfBooking);

                if (isEqual && countCustomer < voucher50) {
                    System.out.println("customer get voucher 50%");
                    System.out.println(customer.toString());
                    System.out.println(booking.toString());
                    countCustomer += 1;
                    break;
                } else if (isEqual && countCustomer < (voucher20 + voucher50)) {
                    System.out.println("customer get voucher 20%");
                    System.out.println(customer.toString());
                    System.out.println(booking.toString());
                    countCustomer += 1;
                    break;
                } else if (isEqual && countCustomer < totalVoucher) {
                    System.out.println("customer get voucher 10%");
                    System.out.println(customer.toString());
                    System.out.println(booking.toString());
                    countCustomer += 1;
                    break;
                }
            }
        }
    }
}
