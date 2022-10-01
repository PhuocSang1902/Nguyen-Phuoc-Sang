package ss18_string_and_regrex.exercise.validate_phone_number;

public class Test {
    public static String[] valid = new String[]{"(83)-(0987654357)","(80)-(0980654357)"};
    public static String[] invalid = new String[]{"83)-(0987654357)","(80-(0980654357)","(83)-0987654357)","(83)-(0987654357","(8)-(0987654357)","(83)-(6987654357)","(83)-(098765357)","(835)-(0987654357)","(83)-(09876594357)","(835-(0987654357)"};

    public static void main(String[] args) {

        TestPhoneNumber testPhoneNumber = new TestPhoneNumber();
        for (String phone : valid){
            System.out.println(testPhoneNumber.isValid(phone));
        }
        for (String phone : invalid){
            System.out.println(testPhoneNumber.isValid(phone));
        }
    }
}
