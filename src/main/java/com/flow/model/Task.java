package com.flow.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter 
@Setter 
@NoArgsConstructor
public class Task {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	private String type;
	
	@Column(columnDefinition = "text")
	private String command;
	
	private int retries;
	
	@ManyToOne
	@JoinColumn(name = "workflow_id")
    @JsonBackReference
	private Workflow workflow;

}
