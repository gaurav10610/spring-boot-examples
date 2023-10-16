package com.example.springboot.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.springboot.service.AsyncEmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsyncEmployeeServiceImpl implements AsyncEmployeeService {

	@Override
	@Async("threadPoolTaskExecutor")
	public void generateEmployeeRecords() {
		for (int i = 0; i < 1000000; i++) {
			log.info("Generated Employee with id: {}", i);
		}
	}

}
