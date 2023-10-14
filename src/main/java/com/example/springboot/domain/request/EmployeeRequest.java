package com.example.springboot.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeRequest {
	@NotBlank(message = "name cannot be empty")
	private String name;
	
	@NotBlank(message = "city cannot be empty")
	private String city;
}
