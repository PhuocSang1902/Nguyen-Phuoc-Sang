package validation;

public class CustomerValidation {
    public static boolean checkName(String name) {
        String regexName = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$";
        return name.matches(regexName);
    }
    public static boolean checkPhoneNumber(String name) {
        String regexPhoneNumber = "^((\\+84|0)9)\\d{8}$";
        return name.matches(regexPhoneNumber);
    }
    public static boolean checkIdCard(String name) {
        String regexIdCard = "^\\d{9}|\\d{12}$";
        return name.matches(regexIdCard);
    }
    public static boolean checkEmail(String name) {
        String regexIdCard = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return name.matches(regexIdCard);
    }
}
