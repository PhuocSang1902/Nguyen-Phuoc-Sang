package ss18_string_and_regrex.exercise.validate_class_name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    public static Pattern pattern;
    public Matcher matcher;

    public static final String CLASS_NAME_VALID = "^[ACP]{1}+\\d{4}+[GHIKLM]$";

    ClassName (){
        pattern = Pattern.compile(CLASS_NAME_VALID);
    }

    public boolean valid(String className){
        matcher = pattern.matcher(className);
        return matcher.matches();

    }
}
