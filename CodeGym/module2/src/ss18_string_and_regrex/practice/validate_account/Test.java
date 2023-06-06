package ss18_string_and_regrex.practice.validate_account;

public class Test {
    public static final String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abcdefgh" };
    public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

    public static void main(String args[]) {
        Account account = new Account();
        for (String acc : validAccount) {
            boolean isValid = account.validate(acc);
            System.out.println("Account is " + acc +" is valid: "+ isValid);
        }
        for (String acc : invalidAccount) {
            boolean isValid = account.validate(acc);
            System.out.println("Account is " + acc +" is valid: "+ isValid);
        }
    }
}
