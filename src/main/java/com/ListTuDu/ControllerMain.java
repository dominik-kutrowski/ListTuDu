//
package com.ListTuDu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class ControllerMain implements WebMvcConfigurer {
    @GetMapping(value={"/", "home"})
    public String HomePage(Model modelHome) {
        modelHome.addAttribute("HomePage", "Herzlich Willkommen!!");
        return "home";
    }
    //
    @GetMapping("user")
    public String UserPage(Model modelUser) {
        modelUser.addAttribute("UserPage", "info o Tobie!!");
        return "user";
    }
}

