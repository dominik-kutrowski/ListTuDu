package com.ListTuDu;

import java.util.Random;
import java.util.List;
import com.ListTuDu.Task;

import java.io.IOException;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MvcConfig implements WebMvcConfigurer {
    @Autowired private TaskRepository taskRepository;

    @GetMapping(value={"/", "home"})
    public String HomePage(Model modelhome) {
        modelhome.addAttribute("HomePage", "Herzlich Willkommen!!");
        return "home";
    }
    //
    @GetMapping("user")
    public String UserPage(Model modeluser) {
        modeluser.addAttribute("UserPage", "info o Tobie!!");
        return "user";
    }
    //
    @GetMapping("TuDu")
    public String TuDuPage(Model modelTuDu) {
        modelTuDu.addAttribute("TuDuPage", "lista TuDu!!");
        return "TuDu";
    }
    //
    @GetMapping("TuDu/add")
    public String TuDuPageAdd(Model modelTuDuAdd, RedirectAttributes TaskCreated) {
        Random rand = new Random();
        Task tasktosave = new Task();
        tasktosave.setName("auto generated task no. "+rand.nextInt(1000)+1);
        taskRepository.save(tasktosave);
        TaskCreated.addAttribute("NewTask", "yes");
        return "redirect:/TuDu/list";
    }
    @GetMapping("TuDu/list")
    public String TuDuPageList(Model modelTuDuList, @RequestParam(value="NewTask", defaultValue="No") String name) {
        modelTuDuList.addAttribute("TuDuTask", taskRepository.findAll());
        modelTuDuList.addAttribute("NewTask", name);
        return "list";
    }
}

