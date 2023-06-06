package ss18_string_and_regrex.exercise.validate_class_name;

public class Test {
    public static final String[] validClassName = new String[] { "C0001G", "A0001M", "P0201K", "A9991L"};
    public static final String[] invalidClassName = new String[] { "AA0001M", "a0001kk", "A001m", "0001","Aa0001M","A00401M" };

    public static void main(String[] args) {
        ClassName className = new ClassName();

        for (String cla : validClassName){
            boolean isValid = className.valid(cla);
            System.out.println(isValid);
        }
        for (String cla : invalidClassName){
            boolean isValid = className.valid(cla);
            System.out.println(isValid);
        }
    }
}
