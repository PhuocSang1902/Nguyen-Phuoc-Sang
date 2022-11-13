package validation;

public class FacilityValidation {
    public static boolean checkName(String name) {
        String regexName = "^([A-Z0-9][a-z0-9]+[ ])*([A-Z0-9][a-z0-9]*)$";
        return name.matches(regexName);
    }
    public static boolean checkArea(String name) {
        String regexArea = "^\\d+\\.?\\d*$";
        return name.matches(regexArea);
    }
    public static boolean checkCost(String name) {
        String regexCost = "^\\d+\\.?\\d*$";
        return name.matches(regexCost);
    }
    public static boolean checkPeopleNumber(String name) {
        String regexCost = "^\\d+$";
        return name.matches(regexCost);
    }
}
