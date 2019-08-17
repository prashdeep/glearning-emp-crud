package com.glearning.empcrud.controller;

import com.glearning.empcrud.model.User;
import com.glearning.empcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserWebController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String displayHomePage(Model model){
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/submit")
    public String registetUser(@Valid @ModelAttribute User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "register";
        }
        this.userService.saveUser(user);
        return "redirect:/";
    }


}