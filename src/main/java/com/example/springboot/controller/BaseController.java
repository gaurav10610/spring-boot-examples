package com.example.springboot.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class BaseController {
	protected ResponseEntity<?> buildResponse(Object object) {
		return new ResponseEntity(object, HttpStatusCode.valueOf(200));
	}
}
