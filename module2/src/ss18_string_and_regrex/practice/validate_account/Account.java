package ss18_string_and_regrex.practice.validate_account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private static Pattern pattern;
    private Matcher matcher;

    private final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

    public Account(){
        pattern = Pattern.compile(ACCOUNT_REGEX);
    }
    public boolean validate (String account){
        matcher = pattern.matcher(account);
        return matcher.matches();
    }
}
