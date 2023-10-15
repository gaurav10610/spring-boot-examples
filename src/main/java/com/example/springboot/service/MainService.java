package com.example.springboot.service;

import com.example.springboot.domain.request.EmployeeRequest;
import com.example.springboot.domain.response.EmployeeDto;
import com.example.springboot.domain.response.EmployeeListDto;

public interface MainService {

	public EmployeeListDto getAllEmployees();

	public EmployeeDto updateEmployee(Integer id, EmployeeRequest request);

}
