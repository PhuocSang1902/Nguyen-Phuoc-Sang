package com.exercise.finish_project.controller;


import com.exercise.finish_project.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;


@Controller
@RequestMapping(value = {"/", "/welcome"})
public class UserController {

    @GetMapping("")
    public String welcomePage(Model model){
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "/welcomePage";
    }

    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal){
        User loginedUser = (User) ((Authentication)principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "/adminPage";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        return "/login";
    }

    @GetMapping("/userInfo")
    public String userInfo(Model model, Principal principal){
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "/userInfoPage";
    }

    @GetMapping("/logoutSuccessful")
    public String logoutSuccessful(Model model){
        model.addAttribute("title", "Logout");
        return "/logoutSuccessfulPage";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal){
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "/403Page";
    }
}
