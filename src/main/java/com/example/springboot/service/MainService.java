package com.example.springboot.service;

import java.util.List;

import com.example.springboot.domain.response.EmployeeDto;

public interface MainService {
	public List<EmployeeDto> getAllEmployees();
}
