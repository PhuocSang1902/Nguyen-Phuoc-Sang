package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CheckFormat {
    public static void checkName (String str) throws FormatException {
        boolean check = str.matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$");
        if (!check) {
            throw new FormatException("Name Is Out Of Format Exception");
        }
    }
    public static void checkStudentCode(String str) throws FormatException {
        boolean check = str.matches("^A[0-9]{4}$");
        if (!check) {
            throw new FormatException("Student Code Is Out Of Format Exception");
        }

    }
    public static void checkTeacherCode(String str) throws FormatException {
        boolean check = str.matches("^B[0-9]{4}$");
        if (!check) {
            throw new FormatException("Teacher Code Is Out Of Format Exception");
        }

    }
    public static void checkDate(String str) throws FormatException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.setLenient(false);
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try{
            simpleDateFormat.parse(str);
            LocalDate date = LocalDate.parse(str, fm);
        }catch (ParseException | DateTimeParseException e){
            throw new FormatException("Date Format Exception");
        }


    }

    public static void checkDateOfBirth(String str) throws FormatException {
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dob = LocalDate.parse(str, fm);

        LocalDate nowSub18 = LocalDate.now().minusYears(18);
        LocalDate nowSub100 = LocalDate.now().minusYears(100);

        boolean isGreatThan18 = (dob.compareTo(nowSub18) < 0);
        boolean isLessThan100 = (dob.compareTo(nowSub100) > 0);

        if (!isGreatThan18 || !isLessThan100) {
            throw new FormatException("Date Of Birth Is Great Than 18 And Less Than 100 Exception");
        }

    }

    public static void checkPoint(double point) throws FormatException {
        if (point < 0 || point > 10) {
            throw new FormatException("Point Is Great Than 0 And Less Than 10 Exception");
        }
    }

}
