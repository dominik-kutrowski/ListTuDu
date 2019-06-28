package com.ListTuDu;

import org.springframework.data.repository.CrudRepository;
import com.ListTuDu.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
