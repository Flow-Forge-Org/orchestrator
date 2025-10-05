package com.flow.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class WorkflowRequest {

    @NotBlank(message = "Name is request")
    private String name;

    private String schedule;

    @NotNull(message = "Tasks list cannot be null.")
    @Valid
    private List<TaskRequest> tasks = new ArrayList<>();


    // --- getters & setters ---
    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskRequest> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskRequest> tasks) {
        this.tasks = tasks;
    }

    // ----Nested static DTO for a task-----
    public static class TaskRequest{

        @NotBlank(message = "Task name is required.")
        private String name;

        @NotBlank(message = "Task type is required.")
        private String type;

        private String command;

        private int retries;

        // --- getters & setters ---
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public int getRetries() {
            return retries;
        }

        public void setRetries(int retries) {
            this.retries = retries;
        }
    }
}
