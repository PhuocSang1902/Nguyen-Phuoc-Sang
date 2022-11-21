package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.service.PracticeService;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class PracticeController {
    @Autowired
    PracticeService practiceService;

    @GetMapping("")
    public String displayHome(){
        return "home";
    }

    @PostMapping("check")
    public String checkValidate(Model model, String email){
        boolean checkEmail = practiceService.checkEmail(email);
        String mess = null;
        if (checkEmail){
            mess = "Email is valid";
        }else {
            mess = "Email is invalid";
        }
        model.addAttribute("mess", mess);
        return "home";
    }

    @RequestMapping("world-clock")
    public String worldClock(Model model,@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city ){
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "time";
    }
}
