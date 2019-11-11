package com.ListTuDu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ControllerUser {
    //@Autowired private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("user")
    public String userPage(Model modelUser) {
        modelUser.addAttribute("UserPage", "info o Tobie!!");
        return "user/user";
    }

    @PostMapping("user/userAdd")
    public String userPageCreate(@Valid User user, BindingResult bindingResults) {
        if(bindingResults.hasErrors()){
            return "redirect:/user/userAdd";
        }
        if(user.getId()==null){
            user.setId(userRepository.count()+1);
        }
        userRepository.save(user);
        return "redirect:/user";
    }
    @GetMapping("user/userAdd")
    public String userPageAdd(User user) {
        return "user/userAdd";
    }
}
