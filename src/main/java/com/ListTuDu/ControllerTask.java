//
package com.ListTuDu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ControllerTask  {
    @Autowired private TaskRepository taskRepository;
    //
    @PostMapping(value={"task/delete/{id}"})
    public String TaskPageDelete(@PathVariable Long id){
        taskRepository.deleteById(id);
        return "redirect:/task/list";
    }
    @GetMapping(value={"task/delete/{id}"})
    public String TaskPageDeleteQuestion(Model modelTaskDelete, @PathVariable Long id) {
        //linijka ponizej albo nie dziala, albo nie wiem jak się do atrybutu TaskDelete dobrać w html :S
        modelTaskDelete.addAttribute("TaskDelete", taskRepository.findById(id));
        modelTaskDelete.addAttribute("TaskId", id);
        return "task/delete";
    }
    //
    //
    @GetMapping("task")
    public String TaskPage(Model modelTask) {
        return "task/task";
    }
    //
    @PostMapping("task/add")
    public String TaskPageCreate(@Valid Task task, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "redirect:/task/add";
        }
        taskRepository.save(task);
        return "redirect:/task/list";
    }
    @GetMapping("task/add")
    public String TaskPageAdd(Task task) {
        return "task/add";
    }
    //
    @GetMapping("task/list")
    public String TaskPageList(Model modelTaskList){
        modelTaskList.addAttribute("TaskList", taskRepository.findAll());
        return "task/list";
    }

}