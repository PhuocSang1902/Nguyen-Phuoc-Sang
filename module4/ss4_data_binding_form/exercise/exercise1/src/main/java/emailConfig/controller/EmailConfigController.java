package emailConfig.controller;

import emailConfig.model.EmailConfig;
import emailConfig.model.Login;
import emailConfig.service.EmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class  EmailConfigController {

    @Autowired
    private EmailConfigService emailConfigService;

    @GetMapping("/")
    public String home(Model model) {
        Login login = new Login();
        model.addAttribute("login", login);
        return "home";
    }

    @GetMapping("list")
    public String info(@ModelAttribute("emailConfig") EmailConfig emailConfig) {
        return "list";

    }

    @PostMapping("edit")
    public String edit(Model model, @ModelAttribute("emailConfig") EmailConfig emailConfig) {
        model.addAttribute("emailConfig", emailConfig);
        return "list";

    }
    @PostMapping("login")
    public String login(Model model, @ModelAttribute("login") Login login) {
        EmailConfig emailConfig = emailConfigService.login(login);
        if (emailConfig != null) {
            model.addAttribute("emailConfig", emailConfig);
            return "email-config";
        } else {
            return "error";
        }
    }
}
