package ss10_java_collection_framework.exercise.exercise_extra_1.util;

public class Check {
    public static void checkName(String str) throws FormatException {
        boolean check = str.matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$");
        if (!check){
            throw new FormatException("Name Is Out Of Format Exception");
        }

    }

    public static void checkPoint(double point) throws FormatException {
        if (point < 0 || point > 10) {
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
            throw new FormatException("Name Is Out Of Format Exception");
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
            throw new FormatException("Class Name Is Out Of Format Exception");
        }

    }
    public static void checkCode(String str) throws FormatException {
        boolean check = str.matches("^[AB][0-9]{4}$");
        if (!check) {
            throw new FormatException("Class Name Is Out Of Format Exception");
        }

    }
}
