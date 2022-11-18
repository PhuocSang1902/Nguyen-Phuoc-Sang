package dictionary.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class DictionaryService {
    private static Map<String, String> dictionaries = new LinkedHashMap<>();
    static {

        dictionaries.put("xin chào", "hello");
        dictionaries.put("tạm biệt", "goodbye");
        dictionaries.put("ngu dốt", "that you");
        dictionaries.put("Khỏe", "fine");
        dictionaries.put("Ốm", "ill");
        dictionaries.put("ngu", "stupid");
    }
    public static String translate(String vnWord){
        return dictionaries.get(vnWord);
    }
}
