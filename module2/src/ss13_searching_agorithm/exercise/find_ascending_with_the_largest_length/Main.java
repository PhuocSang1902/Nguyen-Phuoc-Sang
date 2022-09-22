package ss13_searching_agorithm.exercise.find_ascending_with_the_largest_length;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter string: ");
            String string = sc.nextLine();

            LinkedList<Character> maxList = new LinkedList<>();


            for (int i = 0; i < string.length(); i++) {

                LinkedList<Character> list = new LinkedList<>();

                list.add(string.charAt(i));
                for (int j = i; j < string.length(); j++) {
                    if (string.charAt(j) > list.getLast()) {
                        list.add(string.charAt(j));
                    }
                }

                if (list.size() > maxList.size()) {
                    maxList.clear();
                    maxList.addAll(list);
                }
            }

            for(Character cha : maxList){
                System.out.print(cha);
            }
    }
}
