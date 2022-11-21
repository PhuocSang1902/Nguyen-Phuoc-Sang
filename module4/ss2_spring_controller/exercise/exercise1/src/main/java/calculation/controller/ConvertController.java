package calculation.controller;

import calculation.service.ConvertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConvertController {
    @RequestMapping("")
    public String view(){
        return "calculation";
    }
    @RequestMapping("calculate")
    public String calculate(Model model, Float number1, Float number2, String math) {
        if (number1 == null){
            number1 = 0f;
        }
        if (number2 == null){
            number2 = 0f;
        }
        String result = String.valueOf(ConvertService.calculate(number1, number2, math));
        if (result.equals("null")){
            result = "Không có kết quả";
        }
        model.addAttribute("result", result);
        return "calculation";
    }
}
