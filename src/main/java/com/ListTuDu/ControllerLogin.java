package com.ListTuDu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerLogin {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("login")
    public String LoginUser(Model loginInfo, @RequestParam("email") String email, @RequestParam("password") String pass) {
        User userExists = userRepository.findByEmail(email);
        if (userExists != null) {
            loginInfo.addAttribute("loginExist", "Email in use!");
        }
        return "redirect:home";
    }

    @GetMapping(value = {"login"})
    public String LoginPage() {
        return "login";
    }
}
