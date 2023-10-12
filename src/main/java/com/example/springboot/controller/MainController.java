package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.service.MainService;

import lombok.AllArgsConstructor;

@RestController()
@RequestMapping(value = "/spring-boot")
@AllArgsConstructor
public class MainController extends BaseController {

	private final MainService mainService;
	
	@GetMapping(value = "/employees")
	public ResponseEntity<?> getAllEmployees() {
		return buildResponse(mainService.getAllEmployees());
	}
}
