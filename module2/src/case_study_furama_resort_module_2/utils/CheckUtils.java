package case_study_furama_resort_module_2.utils;

import java.time.LocalDate;
import java.time.Period;

public class CheckUtils {
    public static void checkName(String str) throws FormatException {
        boolean check = str.matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$");
        if (!check){
            throw new FormatException("Name Is Out Of Format Exception");
        }
    }

    public static void checkNameService(String str) throws FormatException {
        boolean check = str.matches("^([A-Z][a-z]+)+([a-z]+[ ])+([a-z]+)$");
        if (!check){
            throw new FormatException(" Service Name Is Out Of Format Exception");
        }
    }

    public static void checkSalary(double salary) throws FormatException {
        if (salary <= 0) {
            throw new FormatException("Point Is Out Of Format Exception!");
        }
    }

    public static void checkMoney(double cost) throws FormatException {
        if (cost < 0) {
            throw new FormatException("Rental Cost Is Out Of Format Exception!");
        }
    }

    public static void checkNumberOfPeople(int num) throws FormatException {
        if (num <= 0 || num >= 20) {
            throw new FormatException("Number Of People Is Out Of Format Exception!");
        }
    }

    public static void checkNumberOfFloors(int num) throws FormatException {
        if (num <= 0 ) {
            throw new FormatException("Number Of Floor Is Out Of Format Exception!");
        }
    }

    public static void checkArea(double area) throws FormatException {
        if (area <= 30) {
            throw new FormatException("Area Is Out Of Format Exception!");
        }
    }

    public static void checkEmail(String str) throws FormatException {
        boolean check = str.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        if (!check){
            throw new FormatException("Email Is Out Of Format Exception");
        }
    }

    public static void checkPhoneNumber(String str) throws FormatException {
        boolean check = str.matches("^0\\d{9}$");
        if (!check){
            throw new FormatException("Phone Number Is Out Of Format Exception");
        }
    }

    public static void checkAddress(String str) throws FormatException {
        boolean check = str.matches("^([\\w/]+[ ]?)*([A-Z][a-z]+\\s)+([A-z][a-z]+)$");
        if (!check){
            throw new FormatException("Address Is Out Of Format Exception");
        }

    }

    public static void checkCustomerCode(String str) throws FormatException {
        boolean check = str.matches("^CT[0-9]{4}$");
        if (!check) {
            throw new FormatException("Customer Code Is Out Of Format Exception");
        }

    }

    public static void checkFacilityCode(String str) throws FormatException {
        boolean check = str.matches("^(SVVL)|(SVHO)|(SVRO)[-][0-9]{4}$");
        if (!check) {
            throw new FormatException("Facility Code Is Out Of Format Exception");
        }

    }

    public static void checkBookingCode(String str) throws FormatException {
        boolean check = str.matches("^(BK)[0-9]{4}$");
        if (!check) {
            throw new FormatException("Facility Code Is Out Of Format Exception");
        }

    }

    public static void checkGender(String str) throws FormatException {
        boolean check = str.matches("^(male)|(female)|(other)$");
        if (!check) {
            throw new FormatException("Gender Is Out Of Format Exception");
        }

    }
    public static void checkId(String str) throws FormatException {
        boolean check = str.matches("^[0-9]{10}$");
        if (!check) {
            throw new FormatException("Code Is Out Of Format Exception");
        }

    }
    public static void checkDate(String str) throws FormatException {
        boolean check = str.matches("^\\d{2}-\\d{2}-\\d{4}$");
        if (!check) {
            throw new FormatException("Date Is Out Of Format Exception");
        }

    }
    public static void checkDateOfBirth(LocalDate dob) throws FormatException {
        LocalDate now = LocalDate.now();
        Period period = Period.between(dob, now);
        boolean isGreatThan18 = (period.getYears() >= 18);
        boolean isLessThan100 = (period.getYears() <= 100);

        if (!isGreatThan18 || !isLessThan100) {
            throw new FormatException("Date Of Birth Is Great Than 18 And Less Than 100 Exception");
        }

    }
}
