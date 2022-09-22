package test;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String str = "NguyenPhuocSang";
        System.out.println(solution(str));
    }
    static String solution(String str) {
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            charList.add(str.charAt(i));
        }
        for (int i = 0; i < charList.size(); i++) {
            if(charList.get(i).equals(Character.toUpperCase(charList.get(i)))){
                if(i != 0) {
                    charList.set(i,Character.toLowerCase(charList.get(i)));
                    charList.add(i, ' ');
                }else {
                    charList.set(i,Character.toLowerCase(charList.get(i)));
                }
            }
        }
        String str2 = "";
        for (Character character : charList) {
            str2 += character;
        }
        return str2;
    }
}
