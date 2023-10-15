package com.example.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.domain.request.EmployeeRequest;
import com.example.springboot.domain.response.EmployeeDto;
import com.example.springboot.domain.response.EmployeeListDto;
import com.example.springboot.service.EmployeeService;
import com.example.springboot.service.base.BaseService;

@Service
public class EmployeeServiceImpl extends BaseService implements EmployeeService {

	@Override
	public EmployeeListDto getAllEmployees() {
		/**
		 * fetch country from request context
		 */
		String country = getEmployeeConfig().getCountry();

		List<EmployeeDto> list = new ArrayList<EmployeeDto>();

		list.add(EmployeeDto.builder().id(123).name("Gaurav").city("Mathura").country(country).build());
		list.add(EmployeeDto.builder().id(121).name("Shikha").city("Agra").country(country).build());

		return EmployeeListDto.builder().list(list).build();
	}

	@Override
	public EmployeeDto updateEmployee(Integer id, EmployeeRequest request) {
		/**
		 * fetch country from request context
		 */
		String country = getEmployeeConfig().getCountry();

		return EmployeeDto.builder().id(id).name(request.getName()).city(request.getCity()).country(country).build();
	}

}
