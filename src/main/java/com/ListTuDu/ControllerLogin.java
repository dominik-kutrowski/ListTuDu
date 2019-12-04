package com.ListTuDu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerLogin {
    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public String loginPage() {
        return "login";
    }
}
