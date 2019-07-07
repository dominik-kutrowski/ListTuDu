//
package com.ListTuDu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Random;

@Controller
public class ControllerTask implements WebMvcConfigurer {
    @Autowired private TaskRepository taskRepository;
    //
    @PostMapping("task/add")
    public String TaskPageCreate(@Valid Task task, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "redirect:/task/add";
        }
        taskRepository.save(task);
        return "redirect:/task/list";
    }
    //
    @GetMapping("task/add")
    public String TaskPageAdd(Task task) {
        return "task/add";
    }
    //
    @GetMapping("task")
    public String TaskPage(Model modelTask) {
        modelTask.addAttribute("TaskPage", "lista Task-ow!!");
        return "task/task";
    }
    //
    @GetMapping("task/list")
    public String TaskPageList(Model modelTaskList, @RequestParam(value="TaskNew", defaultValue="No") String name) {
        modelTaskList.addAttribute("TaskList", taskRepository.findAll());
        modelTaskList.addAttribute("TaskNew", name);
        return "task/list";
    }
}