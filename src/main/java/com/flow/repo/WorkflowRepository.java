package com.flow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flow.model.Workflow;

public interface WorkflowRepository extends JpaRepository<Workflow, Long>{

}
