package com.ListTuDu;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.apache.commons.codec.digest.DigestUtils;

import javax.validation.Valid;

import org.apache.commons.codec.digest.Sha2Crypt;

@Controller
public class ControllerLogin {
    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public String loginPage() {
        return "login";
    }
}
