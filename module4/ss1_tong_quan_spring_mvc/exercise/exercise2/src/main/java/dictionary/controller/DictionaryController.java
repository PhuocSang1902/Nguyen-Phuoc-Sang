package dictionary.controller;

import dictionary.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DictionaryController {
    @RequestMapping("")
    public String home(){
        return "dictionary";
    }
    @RequestMapping("translate")
    public String translate(Model model, String vnWord){
        String result = null;
        if(vnWord != null) {
           result = DictionaryService.translate(vnWord);
        }
        if(result == null){
            result = "Không có từ cần tìm";
        }
        model.addAttribute("result", result);
        return "dictionary";
    }
}
