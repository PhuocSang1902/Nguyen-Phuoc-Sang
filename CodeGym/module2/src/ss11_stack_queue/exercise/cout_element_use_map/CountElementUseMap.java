package ss11_stack_queue.exercise.cout_element_use_map;

import java.util.*;

public class CountElementUseMap {
    public static class MapTree {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter string to count element: ");
            String string = scanner.nextLine();
            string = string.toUpperCase();
            System.out.println(string);
            Map<Character, Integer> map = new TreeMap<>();
            for (int i = 0; i < string.length(); i++) {
                if (!map.containsKey(string.charAt(i))) {
                    map.put(string.charAt(i), 1);
                } else {
                    map.put(string.charAt(i), map.get(string.charAt(i)) + 1);
                }
            }
            System.out.println(map);
        }
    }
}
