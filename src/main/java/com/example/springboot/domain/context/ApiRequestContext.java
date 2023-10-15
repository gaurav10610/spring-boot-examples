package com.example.springboot.domain.context;

public class ApiRequestContext {

	private static final ThreadLocal<EmployeeConfig> context = new ThreadLocal<>();

	public static void setContext(EmployeeConfig employeeConfig) {
		context.set(employeeConfig);
	}

	public static EmployeeConfig getEmployeeConfig() {
		return context.get();
	}

	public static void clear() {
		context.remove();
	}

}
