//
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
public class ControllerTask  {
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
        return "task/task";
    }
    //
    @GetMapping("task/list")
    public String TaskPageList(Model modelTaskList, @RequestParam(value="TaskNew", defaultValue="No") String name)
    {
        modelTaskList.addAttribute("TaskList", taskRepository.findAll());
        modelTaskList.addAttribute("TaskNew", name);
        return "task/list";
    }

}