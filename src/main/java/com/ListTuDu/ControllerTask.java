package com.ListTuDu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ControllerTask {
    @Autowired
    private TaskRepository taskRepository;
    private Authentication authentication;

    @GetMapping("task")
    public String taskPage(Model modelTask) {
        return "task/task";
    }

    @PostMapping(value = "task/edit/{id}")
    public String taskPageEditQuarry(Model modelTaskList,
                                     @Valid Task taskAfterEdit,
                                     BindingResult bindingResult) {
        Integer caseCounter = 0;
        if (bindingResult.hasErrors()) {
            Long id = taskAfterEdit.getId();
            modelTaskList.addAttribute("taskBeforeEdit", id);
            modelTaskList.addAttribute("TaskId", id);
            return "redirect:/task/edit/{id}";
        }

        Task taskBeforeEdit = taskRepository.findAllById(taskAfterEdit.getId());
        if (taskBeforeEdit.getStatus() != taskAfterEdit.getStatus()) {
            caseCounter = caseCounter + 1;
        }

        if (taskBeforeEdit.getDateDeadLine() == null) {
            if (taskAfterEdit.getDateDeadLine() == null) {
            } else caseCounter = caseCounter + 2;
        } else {
            if (taskBeforeEdit.getDateDeadLine().equals(taskAfterEdit.getDateDeadLine())) {
            } else caseCounter = caseCounter + 2;
        }

        switch (caseCounter) {
            case 0:
                Long id = taskAfterEdit.getId();
                modelTaskList.addAttribute("taskBeforeEdit", id);
                modelTaskList.addAttribute("TaskId", id);
                return "redirect:/task/edit/{id}";
            case 1:
                taskRepository.updateByStatusWhereId(taskAfterEdit.getStatus(), taskAfterEdit.getId());
                break;
            case 2:
                taskRepository.updateByDateDeadLineWhereId(taskAfterEdit.getDateDeadLine(), taskAfterEdit.getId());
                break;
            case 3:
                taskRepository.updateByStatusAndDateDeadLineWhereId(taskAfterEdit.getStatus(), taskAfterEdit.getDateDeadLine(), taskAfterEdit.getId());
                break;
            default:
                return "redirect:/task/list";
        }
        return "redirect:/task/list";
    }

    @GetMapping(value = {"task/edit/{id}"})
    public String taskPageEdit(Model modelTaskList, @PathVariable Long id) {
        try {
            modelTaskList.addAttribute("taskBeforeEdit", taskRepository.findById(id).get());
            modelTaskList.addAttribute("TaskId", id);
            modelTaskList.addAttribute("TaskStatus", taskRepository.findStatusById(id));
            return "task/edit";
        } catch (Exception e) {
            return "redirect:/task/error";
        }
    }

    @GetMapping(value = {"task/delete/{id}"})
    public String taskPageDeleteQuestion(Model modelTaskDelete, @PathVariable Long id) {
        try {
            modelTaskDelete.addAttribute("TaskDelete", taskRepository.findById(id).get());
            modelTaskDelete.addAttribute("TaskId", id);
            return "task/delete";
        } catch (Exception e) {
            return "redirect:/task/error";
        }
    }

    @PostMapping(value = {"task/delete/{id}"})
    public String taskPageDelete(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/task/list";
    }

    @PostMapping(value = "task/taskAdd")
    public String taskPageCreate(@Valid Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/task/taskAdd";
        authentication = SecurityContextHolder.getContext().getAuthentication();
        task.setCreatedBy(authentication.getName());
        taskRepository.save(task);
        task.overdueDeadLineColor(task.getDateDeadLine());
        return "redirect:/task/list";
    }

    @GetMapping("task/taskAdd")
    public String taskPageAdd(Task task) {
        return "task/taskAdd";
    }

    @GetMapping("task/list")
    public String taskPageList(Model modelTaskList) {
        modelTaskList.addAttribute("TaskList", taskRepository.findAll());
        return "task/list";
    }

    @GetMapping("task/error")
    public String taskPageError(Model modelTaskError) {
        return "task/error";
    }
}
