package com.flow.workflow;

import com.flowForge.annotation.EnableFlowDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableFlowDatabase(basePackage = "com.flow.workflow")
@EntityScan("com.flow.entity")
@EnableJpaRepositories("com.flow.repository")
public class WorkflowApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkflowApplication.class, args);
    }
}
