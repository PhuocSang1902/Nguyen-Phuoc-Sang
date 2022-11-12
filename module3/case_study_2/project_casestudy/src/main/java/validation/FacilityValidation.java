package validation;

public class FacilityValidation {
    public static boolean checkName(String name) {
        String regexName = "^([A-Z0-9][a-z0-9]+[ ])+([A-Z0-9][a-z0-9]*)$";
        return name.matches(regexName);
    }
}
