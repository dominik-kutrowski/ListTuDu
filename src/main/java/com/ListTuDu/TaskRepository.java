package com.ListTuDu;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findAllById(Long id);
    Task findStatusById(Long id);

    @Transactional
    @Modifying
    @Query("Update Task ul SET ul.status = ?1, ul.dateDeadLine = ?2 WHERE ul.id = ?3")
    void updateByStatusAndDateDeadLineWhereId(Task.Status status, LocalDate dateDeadLine, Long id);

    @Transactional
    @Modifying
    @Query("Update Task ul SET ul.status = ?1 WHERE ul.id = ?2")
    void updateByStatusWhereId(Task.Status status, Long id);

    @Transactional
    @Modifying
    @Query("Update Task ul SET ul.dateDeadLine = ?1 WHERE ul.id = ?2")
    void updateByDateDeadLineWhereId(LocalDate dateDeadLine, Long id);
}
