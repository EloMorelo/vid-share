package com.vd.vid_share.controller;

import com.vd.vid_share.service.UserService;
import jakarta.validation.Valid;
import com.vd.vid_share.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);
        model.addAttribute("message", "User registered successfully!");
        return "register-success";
    }
}
