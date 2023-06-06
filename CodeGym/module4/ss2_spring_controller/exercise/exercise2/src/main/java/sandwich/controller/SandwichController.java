package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {

    @GetMapping("")
    public String displayHome(){
        return "home";
    }

    @PostMapping("save")
    public String save(Model model, String lettuce, String tomato, String mustard, String sprouts){
        List<String> condiments = new ArrayList<>();
        if (lettuce != null){
            condiments.add(lettuce);
        }
        if (tomato != null){
            condiments.add(tomato);
        }
        if (mustard != null){
            condiments.add(mustard);
        }
        if (sprouts != null){
            condiments.add(sprouts);
        }
        model.addAttribute("condiments", condiments);
        return "home";
    }
}
