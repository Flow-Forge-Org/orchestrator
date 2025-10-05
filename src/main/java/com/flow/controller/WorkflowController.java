package com.example.flow.controller;

import com.example.flow.dto.WorkflowRequest;
import com.example.flow.model.Workflow;
import com.example.flow.service.WorkflowService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workflows")
public class WorkflowController {
    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService){
        this.workflowService = workflowService;
    }

    @PostMapping
    public ResponseEntity<Workflow> createWorkflow(@Valid @RequestBody WorkflowRequest request){
        Workflow created = workflowService.createWorkflow(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    public ResponseEntity<Workflow> getWorkflow(@PathVariable Long id) {
        return workflowService.findById(id)
                .map(wf -> ResponseEntity.ok(wf))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
