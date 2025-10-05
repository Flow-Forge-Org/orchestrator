package com.example.flow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flow.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

}
