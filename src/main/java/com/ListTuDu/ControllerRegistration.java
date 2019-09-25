package com.ListTuDu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;

@Controller
public class ControllerRegistration {

    @Autowired
    private UserRepository userRepository;
    private User userExists;


    @GetMapping("registration")
    public String RegistrationGet(User user) {
        return "registration";
    }

    @PostMapping("registration")
    public String RegistrationPost(
            Model registrationInfo,
            @RequestParam("repeatPassword") String repeatPassword,
            @Valid User user,
            BindingResult bindingResults
    ) {
        if (bindingResults.hasErrors()) {
            registrationInfo.addAttribute(
                    "registrationLoginError",
                    "*login error");
            registrationInfo.addAttribute(
                    "registrationPasswordError",
                    "*password error");
            return "registration2";
        }
        userExists = userRepository.findByEmail(user.getEmail());
        if (userExists != null) {
            registrationInfo.addAttribute(
                    "registrationLoginError",
                    "*login in use");
            return "registration2";
        }

        if (repeatPassword.equals(user.getPass())!=true) {
            registrationInfo.addAttribute(
                    "registrationPasswordRepeatError",
                    "*passwords not equal");
            return "registration2";
        }

        userRepository.save(user);
        registrationInfo.addAttribute(
                "registrationLoginName",
                user.getEmail());
        return "welcome";
    }
}
