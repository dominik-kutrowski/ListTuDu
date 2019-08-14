package com.ListTuDu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ControllerUser {
    //
    @GetMapping("user")
    public String UserPage(Model modelUser) {
        modelUser.addAttribute("UserPage", "info o Tobie!!");
        return "user/user";
    }
    //
    @PostMapping("user/userAdd")
    public String userPageCreate() {
        return "redirect:/user";
    }
    @GetMapping("user/userAdd")
    public String userPageAdd(User user) {
        return "user/userAdd";
    }
}
