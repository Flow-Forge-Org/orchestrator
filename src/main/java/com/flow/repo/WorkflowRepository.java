package com.example.flow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flow.model.Workflow;

public interface WorkflowRepository extends JpaRepository<Workflow, Long>{

}
