package com.ListTuDu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


@Controller
public class ControllerRegistration {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    SecurityConfiguration securityConfiguration;

    public ControllerRegistration() {
    }

    @GetMapping("/registration")
    public String registrationGet() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPost(
            Model registrationInfo,
            Model modelHome,
            @RequestParam("email") String email,
            @RequestParam("pass") String pass,
            @RequestParam("repeatPass") String repeatPass
    ) {
        if (userRepository.findByEmail(email) != null) {
            registrationInfo.addAttribute(
                    "registrationLoginError",
                    "*login error");
            return "registration";
        }

        if (repeatPass.equals(pass) != true) {
            registrationInfo.addAttribute(
                    "registrationPasswordRepeatError",
                    "*passwords not equal");
            return "registration";
        }

        User user = new User();
        user.setEmail(email);
        user.setPass(passwordEncoder.encode(pass));
        user.setRole("USER");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (violations.size() > 0) {
            registrationInfo.addAttribute("registrationLoginError", "*login error");
            registrationInfo.addAttribute("registrationPasswordError", "*or password error");
            return "registration";
        }
        userRepository.save(user);
        modelHome.addAttribute("HomePage", "New account has been created!!");
        return "home";
    }
}
