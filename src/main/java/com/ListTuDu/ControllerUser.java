package com.ListTuDu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.security.Principal;

@Controller
public class ControllerUser {
    //@Autowired private TaskRepository taskRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    private Authentication authentication;
    private Integer errorCounter;

    @GetMapping("user")
    public String userPage(Model modelUser) {
        modelUser.addAttribute("UserPage", "info o Tobie!!");
        return "user/user";
    }

    @PostMapping("user/userAdd")
    public String userPageCreate(@Valid User user, BindingResult bindingResults) {
        if (bindingResults.hasErrors()) {
            return "redirect:/user/userAdd";
        }
        if (user.getId() == null) {
            user.setId(userRepository.count() + 1);
        }
        userRepository.save(user);
        return "redirect:/user";
    }

    @GetMapping("user/userAdd")
    public String userPageAdd(User user) {
        return "user/userAdd";
    }

    @GetMapping("user/userChangePass")
    public String userChangePassAdd() {
        return "user/userChangePass";
    }

    @PostMapping("user/userChangePass")
    public String userChangePassCreate(
            Model model,
            RedirectAttributes redirectAttributes,
            @RequestParam("oldPass") String oldPass,
            @RequestParam("newPass") String newPass,
            @RequestParam("repeatNewPass") String repeatNewPass) {

        errorCounter=0;
        if (newPass.equals(repeatNewPass) != true) {
            model.addAttribute("userPasswordRepeatError", "*repeat pass error");
            errorCounter = 1;
        }
        if(newPass.length()==0 || newPass.length()>=64){
            model.addAttribute("userNewPasswordError", "*pass error");
            errorCounter = 1;
        }
        authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        user = userRepository.findByEmail(authentication.getName());
        if (passwordEncoder.matches(oldPass, user.getPass()) == true && errorCounter==0) {
            userRepository.updateByPassWhereEmail(passwordEncoder.encode(newPass), user.getEmail());
            redirectAttributes.addFlashAttribute("UserPassChanged", "Pass has been changed!!");
            return "redirect:/user";
        }
        else {
            model.addAttribute("userOldPasswordError", "*old pass error");
        }
        return "user/userChangePass";
    }
}
