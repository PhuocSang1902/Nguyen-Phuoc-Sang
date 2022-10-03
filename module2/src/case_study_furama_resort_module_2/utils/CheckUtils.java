package case_study_furama_resort_module_2.utils;

public class CheckUtils {
    public static void checkName(String str) throws FormatException {
        boolean check = str.matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$");
        if (!check){
            throw new FormatException("Name Is Out Of Format Exception");
        }
    }

    public static void checkSalary(double point) throws FormatException {
        if (point <= 0) {
            throw new FormatException("Point Is Out Of Format Exception!");
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

    public static void checkClassName(String str) throws FormatException {
        boolean check = str.matches("^[ABC][0-9]{2}$");
        if (!check) {
            throw new FormatException("Class Name Is Out Of Format Exception");
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
}
