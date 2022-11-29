package com.controller;

import com.dto.UserDto;
import com.model.User;
import com.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("create")
    public String showCreateForm(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "/create";
    }
    @PostMapping("create")
    public String showCreateForm(@Validated @ModelAttribute("userDto")UserDto userDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        model.addAttribute("mess", "User added successfully");
        return "/create";
    }
}
