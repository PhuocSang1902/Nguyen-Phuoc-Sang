package validation;

public class CustomerValidation {
    public static boolean checkName(String name) {
        String regexName = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$";
        return name.matches(regexName);
    }
}
