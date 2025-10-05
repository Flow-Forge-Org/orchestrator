package com.flow.service;

import com.flow.dto.WorkflowRequest;
import com.flow.model.Task;
import com.flow.model.Workflow;
import com.flow.repo.TaskRepository;
import com.flow.repo.WorkflowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class WorkflowService {

    private final WorkflowRepository workflowRepo;
    private final TaskRepository taskRepo;

    public WorkflowService(WorkflowRepository workflowRepo, TaskRepository taskRepo) {
        this.workflowRepo = workflowRepo;
        this.taskRepo = taskRepo;
    }

    @Transactional
    public Workflow createWorkflow(WorkflowRequest request) {
        Workflow wf = new Workflow();
        wf.setName(request.getName());
        wf.setSchedule(request.getSchedule());
        wf.setStatus("active");

        if(request.getTasks() != null) {
            for(WorkflowRequest.TaskRequest task : request.getTasks()) {
                Task t = new Task();
                t.setName(task.getName());
                t.setType(task.getType());
                t.setCommand(task.getCommand());
                t.setRetries(task.getRetries());
                t.setWorkflow(wf);
                wf.getTasks().add(t);
            }
        }
        return workflowRepo.save(wf);
    }

    public Optional<Workflow> findById(Long id) {
        return workflowRepo.findById(id);
    }
}
