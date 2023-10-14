package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.domain.request.EmployeeRequest;
import com.example.springboot.service.MainService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController()
@RequestMapping(value = "spring-boot")
@AllArgsConstructor
public class MainRestController extends BaseController {

	private final MainService mainService;
	
	@GetMapping(value = "/employees")
	public ResponseEntity<?> getAllEmployees() {
		return buildResponse(mainService.getAllEmployees());
	}
	
	@PostMapping(value = "/employees/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable(name = "id") Integer id, @Valid @RequestBody EmployeeRequest request) {
		return buildResponse(mainService.updateEmployee(id, request));
	}
}
