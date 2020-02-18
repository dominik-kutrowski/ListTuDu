package com.ListTuDu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerMain {

    @GetMapping(value = {"/", "home"})
    public String homePage(Model modelHome) {
        modelHome.addAttribute("HomePage", "Herzlich Willkommen Stranger!!");
        return "home";
    }

    @GetMapping(value = {"welcome"})
    public String welcomePage() {
        return "welcome";
    }
}

