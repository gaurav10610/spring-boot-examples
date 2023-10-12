package com.example.springboot.domain.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeDto {
	private Integer id;
	private String name;
	private String city;
}
