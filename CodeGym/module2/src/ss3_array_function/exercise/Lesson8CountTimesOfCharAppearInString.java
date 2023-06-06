package ss3_array_function.exercise;

import java.util.Scanner;

public class Lesson8CountTimesOfCharAppearInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "nguyen phuoc sang";
        System.out.println("Enter a char: ");
        char c = sc.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)){
                count++;
            }
        }
        System.out.println("Times the char appear in String is: " + count);
    }
}
