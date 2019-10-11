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

    @GetMapping("task")
    public String taskPage(Model modelTask) {
        return "task/task";
    }

    @PostMapping(value={"task/delete/{id}"})
    public String taskPageDelete(@PathVariable Long id){
        taskRepository.deleteById(id);
        return "redirect:/task/list";
    }
    @GetMapping(value={"task/delete/{id}"})
    public String taskPageDeleteQuestion(Model modelTaskDelete, @PathVariable Long id) {
        try {
            modelTaskDelete.addAttribute("TaskDelete", taskRepository.findById(id).get());
            modelTaskDelete.addAttribute("TaskId", id);
            return "task/delete";
        }
        catch(Exception e) {
            //return "task/error";
            return "redirect:/task/error";
        }
    }

    @PostMapping(value="task/taskAdd")
    public String taskPageCreate(@Valid Task task, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "redirect:/task/taskAdd";
        }
        taskRepository.save(task);
        task.overdueDeadLineColor(task.getDateDeadLine());
        return "redirect:/task/list";
    }
    @GetMapping("task/taskAdd")
    public String taskPageAdd(Task task) {
        return "task/taskAdd";
    }

    @GetMapping("task/list")
    public String taskPageList(Model modelTaskList){
        modelTaskList.addAttribute("TaskList", taskRepository.findAll());
        return "task/list";
    }

    @GetMapping("task/error")
    public String taskPageError(Model modelTaskError){
        return "task/error";
    }
}
