package convert.controller;

import convert.service.ConvertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConvertController {
    @RequestMapping("")
    public String view(){
        return "convert";
    }
    @RequestMapping("convert")
    public String calculate(Model model, float money) {
        Float result = ConvertService.convert(money);
        model.addAttribute("result", result);
        return "convert";
    }
}
