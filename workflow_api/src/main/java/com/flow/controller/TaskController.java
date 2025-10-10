package com.flow.controller;

import com.flow.workflow.request.dto.SaveTaskRequestDTO;
import com.flow.workflow.request.dto.UpdateTaskRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public interface TaskController {

    @PostMapping("/save")
    public ResponseEntity<String> saveTask(SaveTaskRequestDTO requestDTO);

    @PutMapping("/update")
    public ResponseEntity<String> updateTask(UpdateTaskRequestDTO requestDTO);
}
