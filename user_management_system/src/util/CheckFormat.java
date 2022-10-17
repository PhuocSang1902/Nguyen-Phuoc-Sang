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
            throw new FormatException("Ten khong dung dinh dang");
        }
    }
    public static void checkPaymentCode(String str) throws FormatException {
        boolean check = str.matches("^P[0-9]{4}$");
        if (!check) {
            throw new FormatException("Ma tai khoan thanh toan khong dung");
        }

    }
    public static void checkSaveCode(String str) throws FormatException {
        boolean check = str.matches("^S[0-9]{4}$");
        if (!check) {
            throw new FormatException("Ma tai khoan tiet kiem khong dung");
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
            throw new FormatException("Ngay khong dung");
        }


    }
    public static void checkNumber(double num) throws FormatException {
        if (num < 0) {
            throw new FormatException("Phai lon hon khong");
        }
    }
}
