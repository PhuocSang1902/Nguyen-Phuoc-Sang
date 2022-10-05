package case_study_furama_resort_module_2.services._impl;

import case_study_furama_resort_module_2.models.Booking;
import case_study_furama_resort_module_2.models.person.Customer;
import case_study_furama_resort_module_2.services.PromotionService;
import case_study_furama_resort_module_2.services._impl.people_service_impl.CustomerServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PromotionServiceImpl implements PromotionService {
    private static Scanner sc = new Scanner(System.in);
    private static BookingServiceImpl bookingService = new BookingServiceImpl();
    private static CustomerServiceImpl customerService = new CustomerServiceImpl();
    private static TreeSet<Booking> bookingPromotionTreeSet = new TreeSet<>();

    @Override
    public void display() {
        Set<Booking> bookingSet = bookingService.getDataFromFile();
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
        Set<Booking> bookingSet = bookingService.getDataFromFile();
        System.out.println("Enter the number of voucher 10%: ");
        int voucher10 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the number of voucher 20%: ");
        int voucher20 = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the number of voucher 50%: ");
        int voucher50 = Integer.parseInt(sc.nextLine());

        int totalVoucher = voucher10 + voucher20 + voucher50;
        int count = 0;
        for (Booking booking : bookingSet) {
            if (booking.getStartDay().getMonth() == LocalDate.now().getMonth() && count <= totalVoucher) {
                bookingPromotionTreeSet.add(booking);
                count++;
            }
        }
        for (Booking booking : bookingPromotionTreeSet) {
            int countCustomer = 0;
            List<Customer> customerList = customerService.getDataFromFile();
            for (Customer customer : customerList) {
                if (customer.getCode().equals(booking.getCustomerCode()) && countCustomer <= voucher10) {
                    System.out.println(customer.toString());
                    countCustomer++;
                } else if (customer.getCode().equals(booking.getCustomerCode()) && countCustomer <= (voucher20 + voucher10)) {
                    System.out.println(customer.toString());
                    countCustomer++;
                }else {
                    System.out.println(customer.toString());
                }
            }
        }
    }
}
