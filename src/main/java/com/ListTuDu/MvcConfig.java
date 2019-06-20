package com.ListTuDu;

import java.io.IOException;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@Configuration
@Controller
public class MvcConfig implements WebMvcConfigurer {
    //
    //public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/").setViewName("home");
        //registry.addViewController("/user").setViewName("user");
        //registry.addViewController("/home").setViewName("home");
        //registry.addViewController("/TuDu").setViewName("TuDu");
    //}

    @GetMapping(value={"/", "home"})
    public String HomePage(Model modelhome) {
        modelhome.addAttribute("HomePage", "Herzlich Willkommen!!");
        return "home";
    }
    @GetMapping("/user")
    public String UserPage(Model modeluser) {
        modeluser.addAttribute("UserPage", "info o Tobie!!");
        return "user";
    }
    @GetMapping("/TuDu")
    public String TuDuPage(Model modelTuDu) {
        modelTuDu.addAttribute("TuDuPage", "lista TuDu!!");
        return "TuDu";
    }
}

