package com.ListTuDu;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findAllById(Long id);

    @Transactional
    @Modifying
    @Query("Update Task ul SET ul.dateDeadLine = ?1 WHERE ul.id = ?2")
    void updateByDateDeadLineWhereId(LocalDate dateDeadLine, Long is);
}
