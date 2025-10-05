package com.flow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flow.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

}
