package com.example.springboot.service.base;

import com.example.springboot.domain.context.ApiRequestContext;
import com.example.springboot.domain.context.EmployeeConfig;

public abstract class BaseService {

	protected EmployeeConfig getEmployeeConfig() {
		return ApiRequestContext.getEmployeeConfig();
	}

}
