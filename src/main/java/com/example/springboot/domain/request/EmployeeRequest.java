package com.example.springboot.domain.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeRequest {

	@NotBlank(message = "name cannot be empty")
	@Size(min = 4, max = 20)
	private String name;

	@NotBlank(message = "city cannot be empty")
	@Size(min = 4, max = 15)
	private String city;

}
