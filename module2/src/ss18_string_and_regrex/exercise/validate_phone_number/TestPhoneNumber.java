package ss18_string_and_regrex.exercise.validate_phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPhoneNumber {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_NUMBER_VALID = "^[(]\\d{2}[)][-][(]0\\d{9}[)]$";

    public TestPhoneNumber(){
        pattern = Pattern.compile(PHONE_NUMBER_VALID);
    }

    public boolean isValid(String phoneNumber){
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
