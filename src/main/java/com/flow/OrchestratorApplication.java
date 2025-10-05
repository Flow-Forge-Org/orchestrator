package com.flow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrchestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestratorApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner runner(WorkflowRepository repo) {
//		return args -> {
//			Workflow w = new Workflow();
//			w.setName("test");
//			w.setStatus("active");
//			repo.save(w);
//			System.out.println("Saved Workflow Id: "+ w.getId());
//		};
//	}

}
