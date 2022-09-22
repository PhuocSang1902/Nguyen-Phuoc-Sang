package ss13_searching_agorithm.exercise.fine_longest_consecutive_string;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FindLongestConsecutiveString find = new FindLongestConsecutiveString();
        System.out.print("Enter string: ");
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(find.findLongestConsecutiveString(str));
    }
}
