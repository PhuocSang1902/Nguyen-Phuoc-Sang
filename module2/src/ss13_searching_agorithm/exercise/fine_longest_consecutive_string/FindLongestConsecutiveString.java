package ss13_searching_agorithm.exercise.fine_longest_consecutive_string;

import java.util.LinkedList;

public class FindLongestConsecutiveString {

    public String findLongestConsecutiveString(String str) {
        LinkedList<Character> maxList = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();

            for (int j = i; j < str.length(); j++) {
                Character cha = str.charAt(j);

                if (!list.isEmpty()){

                    if (cha >= str.charAt(j-1)){// Vẫn kiểm tra bằng vì trường hợp bằng vẫn là sắp xếp nhỏ đến lớn và liên tiếp.
                        list.add(cha);
                    }else {
                        break;
                    }

                }else {
                    list.add(cha);
                }
            }

            if (list.size() > maxList.size()) {
                maxList.clear();
                maxList.addAll(list);
            }
        }

        String result = "";
        for (Character character : maxList) {
            result += character;
        }

        return result;
    }
}
