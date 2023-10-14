package com.example.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.domain.request.EmployeeRequest;
import com.example.springboot.domain.response.EmployeeDto;
import com.example.springboot.service.MainService;

@Service
public class MainServiceImpl implements MainService {

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeDto> list = new ArrayList<EmployeeDto>();
		list.add(EmployeeDto.builder().id(123).name("Gaurav").city("Mathura").build());
		list.add(EmployeeDto.builder().id(121).name("Shikha").city("Agra").build());
		return list;
	}

	@Override
	public EmployeeDto updateEmployee(Integer id, EmployeeRequest request) {
		return EmployeeDto.builder().id(id).name(request.getName()).city(request.getCity()).build();
	}

}
