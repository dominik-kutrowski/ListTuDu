package com.ListTuDu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ListTuDu.Task;

import javax.naming.Name;
import javax.persistence.Id;
import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
