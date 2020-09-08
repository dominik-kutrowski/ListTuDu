package com.ListTuDu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class TaskTest {

    @Test
    void should_enumStatus_works() {
        //given
        Task task = new Task();
        //when
        task.setStatus(Task.Status.NotStarted);
        String enumStatusNotStarted = task.getStatus().toString();
        task.setStatus(Task.Status.InProgress);
        String enumStatusInProgress = task.getStatus().toString();
        task.setStatus(Task.Status.Completed);
        String enumStatusCompleted = task.getStatus().toString();
        //then
        Assertions.assertEquals(enumStatusNotStarted,"NotStarted");
        Assertions.assertEquals(enumStatusInProgress,"InProgress");
        Assertions.assertEquals(enumStatusCompleted,"Completed");
    }
    @Test
    void should_overdue_colors_do_not_work() {
        //given
        Task task = new Task();
        //when
        String resultGreen = task.overdueDeadLineColor(LocalDate.now().plusDays(1));
        String resultRed = task.overdueDeadLineColor(LocalDate.now().minusDays(1));
        String resultBlack = task.overdueDeadLineColor(LocalDate.now().plusDays(10));
        String resultEmpty = task.overdueDeadLineColor(task.getDateDeadLine());
        //then
        Assertions.assertNotEquals(resultGreen, "Black");
        Assertions.assertNotEquals(resultGreen, "Red");
        Assertions.assertNotEquals(resultGreen, "????-??-??");
        //
        Assertions.assertNotEquals(resultRed, "Green");
        Assertions.assertNotEquals(resultRed, "Black");
        Assertions.assertNotEquals(resultRed, "????-??-??");
        //
        Assertions.assertNotEquals(resultBlack, "Green");
        Assertions.assertNotEquals(resultBlack, "Red");
        Assertions.assertNotEquals(resultBlack, "????-??-??");
        //
        Assertions.assertNotEquals(resultEmpty, "Green");
        Assertions.assertNotEquals(resultEmpty, "Red");
        Assertions.assertNotEquals(resultEmpty, "Black");
    }

    @Test
    void should_overdue_colors_work() {
        //given
        Task task = new Task();
        //when
        String resultGreen = task.overdueDeadLineColor(LocalDate.now().plusDays(1));
        String resultRed = task.overdueDeadLineColor(LocalDate.now().minusDays(1));
        String resultBlack = task.overdueDeadLineColor(LocalDate.now().plusDays(10));
        String resultEmpty = task.overdueDeadLineColor(task.getDateDeadLine());
        //then
        Assertions.assertEquals(resultGreen, "Green");
        Assertions.assertEquals(resultBlack, "Black");
        Assertions.assertEquals(resultRed, "Red");
        Assertions.assertEquals(resultEmpty, "????-??-??");
    }

    @Test
    void should_overdue_colors_work_on_color_days_range(){
        //given
        Task task = new Task();
        //when
        String dateNow = task.overdueDeadLineColor(LocalDate.now());
        String dateNowPlus5days = task.overdueDeadLineColor(LocalDate.now().plusDays(5));
        //then
        Assertions.assertEquals(dateNow, "Red");
        Assertions.assertEquals(dateNowPlus5days, "Green");
    }
    @Test
    void should_getters_and_setters_work() {
        //given
        Task task = new Task();
        task.setId(11L);
        task.setStatus(Task.Status.Completed);
        task.setName("testTask");
        task.setDateDeadLine(LocalDate.parse("2020-06-29"));
        task.setCreatedBy("doku");
        //when
        Task taskToCheck = new Task();
        taskToCheck.setId(task.getId());
        taskToCheck.setStatus(task.getStatus());
        taskToCheck.setName(task.getName());
        taskToCheck.setDateDeadLine(task.getDateDeadLine());
        taskToCheck.setCreatedBy(task.getCreatedBy());
        //then
        Assertions.assertEquals(taskToCheck.getId(), task.getId());
        Assertions.assertEquals(taskToCheck.getStatus(), task.getStatus());
        Assertions.assertEquals(taskToCheck.getName(), task.getName());
        Assertions.assertEquals(taskToCheck.getDateDeadLine(), task.getDateDeadLine());
        Assertions.assertEquals(taskToCheck.getCreatedBy(), task.getCreatedBy());
    }
}